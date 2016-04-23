// Data Tables - Config
(function($) {

	'use strict';

	// we overwrite initialize of all datatables here
	// because we want to use select2, give search input a bootstrap look
	// keep in mind if you overwrite this fnInitComplete somewhere,
	// you should run the code inside this function to keep functionality.
	//
	// there's no better way to do this at this time :(
	if ($.isFunction($.fn['dataTable'])) {

		$
				.extend(
						true,
						$.fn.dataTable.defaults,
						{
							sDom : "<'row datatables-header form-inline'<'col-sm-12 col-md-6'l><'col-sm-12 col-md-6'f>r><'table-responsive't><'row datatables-footer'<'col-sm-12 col-md-6'i><'col-sm-12 col-md-6'p>>",
							oLanguage : {
								sLengthMenu : '_MENU_ 条记录 每页',
								sProcessing : '<i class="fa fa-spinner fa-spin"></i> Loading'
							},
							fnInitComplete : function(settings, json) {
								// select 2
								if ($.isFunction($.fn['select2'])) {
									$('.dataTables_length select',
											settings.nTableWrapper).select2({
										minimumResultsForSearch : -1
									});
								}

								var options = $('table', settings.nTableWrapper)
										.data('plugin-options')
										|| {};

								// search
								var $search = $('.dataTables_filter input',
										settings.nTableWrapper);

								$search
										.attr(
												{
													placeholder : typeof options.searchPlaceholder !== 'undefined' ? options.searchPlaceholder
															: '搜索'
												}).addClass('form-control');

								if ($.isFunction($.fn.placeholder)) {
									$search.placeholder();
								}
							}
						});

	}

}).apply(this, [ jQuery ]);

/* Datatable - editable */
(function($) {

	'use strict';

	var EditableTable = {

		options : {
			addButton : '#addToTableCdlb',
			table : '#datatable-cdlb',
			dialog : {
				wrapper : '#dialog',
				cancelButton : '#dialogCancel',
				confirmButton : '#dialogConfirm',
			}
		},

		initialize : function() {
			this.setVars().build().events();
		},

		setVars : function() {
			this.$table = $(this.options.table);
			this.$addButton = $(this.options.addButton);

			// dialog
			this.dialog = {};
			this.dialog.$wrapper = $(this.options.dialog.wrapper);
			this.dialog.$cancel = $(this.options.dialog.cancelButton);
			this.dialog.$confirm = $(this.options.dialog.confirmButton);

			return this;
		},

		build : function() {
			this.datatable = this.$table.DataTable({
				aoColumns : [ null, null, {
					"bSortable" : false
				} ]
			});

			window.dt = this.datatable;

			return this;
		},

		events : function() {
			var _self = this;

			this.$table.on('click', 'a.save-row', function(e) {
				e.preventDefault();

				_self.rowSave($(this).closest('tr'));
			}).on('click', 'a.cancel-row', function(e) {
				e.preventDefault();

				_self.rowCancel($(this).closest('tr'));
			}).on('click', 'a.edit-row', function(e) {
				e.preventDefault();

				_self.rowEdit($(this).closest('tr'));
			}).on('click', 'a.remove-row', function(e) {
				e.preventDefault();

				var $row = $(this).closest('tr');

				$.magnificPopup.open({
					items : {
						src : '#dialog',
						type : 'inline'
					},
					preloader : false,
					modal : true,
					callbacks : {
						change : function() {
							_self.dialog.$confirm.on('click', function(e) {
								e.preventDefault();

								_self.rowRemove($row);
								$.magnificPopup.close();
							});
						},
						close : function() {
							_self.dialog.$confirm.off('click');
						}
					}
				});
			});

			this.$addButton.on('click', function(e) {
				e.preventDefault();

				_self.rowAdd();
			});

			this.dialog.$cancel.on('click', function(e) {
				e.preventDefault();
				$.magnificPopup.close();
			});

			return this;
		},

		// ==========================================================================================
		// ROW FUNCTIONS
		// ==========================================================================================
		rowAdd : function() {
			this.$addButton.attr({
				'disabled' : 'disabled'
			});
			var table = this;
			$
					.ajax({
						url : "getMaxDMBH.json",// 
						contentType : "application/json",// application/xml
						processData : true,// contentType为xml时，些值为false
						data : {
							LX : 1
						},
						dataType : "json",// json--返回json数据类型；xml--返回xml
						success : function(msg) {
							var actions, data, $row, DMBH = 0;

							actions = [
									'<a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>',
									'<a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>',
									'<a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>',
									'<a href="#" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>' ]
									.join(' ');
							DMBH = msg.DMBH;
							data = table.datatable.row
									.add([ DMBH, '', actions ]);
							$row = table.datatable.row(data[0]).nodes().to$();

							$row.addClass('adding').find('td:last').addClass(
									'actions');

							table.rowEdit($row);

							table.datatable.order([ 0, 'desc' ]).draw(); // always
																			// show
																			// fields
						},
						error : function(jqXHR, textStatus, errorThrown) {

						},
					});

		},

		rowCancel : function($row) {
			var _self = this, $actions, i, data;

			if ($row.hasClass('adding')) {
				this.rowRemove($row);
			} else {

				data = this.datatable.row($row.get(0)).data();
				this.datatable.row($row.get(0)).data(data);

				$actions = $row.find('td.actions');
				if ($actions.get(0)) {
					this.rowSetActionsDefault($row);
				}

				this.datatable.draw();
			}
		},

		rowEdit : function($row) {
			var _self = this, data;

			data = this.datatable.row($row.get(0)).data();

			$row
					.children('td')
					.each(
							function(i) {
								var $this = $(this);

								if ($this.hasClass('actions')) {
									_self.rowSetActionsEditing($row);
								} else if (i == 1) {
									$this
											.html('<input type="text" class="form-control input-block" value="'
													+ data[i] + '"/>');
								} else{
									$this
									.html('<input type="text" class="form-control input-block" value="'
											+ data[i] + '" disabled/>');
								}
							});
		},

		rowSave : function($row) {
			var _self = this, $actions, values = [];
			var dmbh = $row[0].children[0].children[0].value;
			var cdlb =  $row[0].children[1].children[0].value;
			$
			.ajax({
				url : "updateDMBH.json",// 
				contentType : "application/json",// application/xml
				processData : true,// contentType为xml时，些值为false
				data : {
					lx :1,
					dmbh : dmbh,
					cdlb : cdlb
				},
				dataType : "json",// json--返回json数据类型；xml--返回xml
				success : function(msg) {
					if ($row.hasClass('adding')) {
						_self.$addButton.removeAttr('disabled');
						$row.removeClass('adding');
					}
					values = $row.find('td').map(function() {
						var $this = $(this);

						if ($this.hasClass('actions')) {
							_self.rowSetActionsDefault($row);
							return _self.datatable.cell(this).data();
						} else {
							return $.trim($this.find('input').val());
						}
					});

					_self.datatable.row($row.get(0)).data(values);

					$actions = $row.find('td.actions');
					if ($actions.get(0)) {
						_self.rowSetActionsDefault($row);
					}

					_self.datatable.draw();
				},
				error : function(jqXHR, textStatus, errorThrown) {

				},
			});
		},

		rowRemove : function($row) {
			var _self = this;
			var dmbh = $row[0].children[0].innerHTML;
			$
			.ajax({
				url : "deleteDMBH.json",// 
				contentType : "application/json",// application/xml
				processData : true,// contentType为xml时，些值为false
				data : {
					lx :1,
					dmbh : dmbh
				},
				dataType : "json",// json--返回json数据类型；xml--返回xml
				success : function(msg) {
					if ($row.hasClass('adding')) {
						_self.$addButton.removeAttr('disabled');
					}

					_self.datatable.row($row.get(0)).remove().draw();
				},
				error : function(jqXHR, textStatus, errorThrown) {

				},
			});
		},

		rowSetActionsEditing : function($row) {
			$row.find('.on-editing').removeClass('hidden');
			$row.find('.on-default').addClass('hidden');
		},

		rowSetActionsDefault : function($row) {
			$row.find('.on-editing').addClass('hidden');
			$row.find('.on-default').removeClass('hidden');
		}

	};

	$(function() {
		EditableTable.initialize();
	});

}).apply(this, [ jQuery ]);