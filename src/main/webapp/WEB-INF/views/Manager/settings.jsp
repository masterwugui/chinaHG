<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">

<head>

<!-- Basic -->
<meta charset="UTF-8" />

<title>中国海关 |作业情况</title>

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- start: CSS file-->

<!-- Vendor CSS-->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="assets/vendor/css/pace.preloader.css" rel="stylesheet" />

<!-- Plugins CSS-->
<link href="assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />
<link href="assets/plugins/scrollbar/css/mCustomScrollbar.css"
	rel="stylesheet" />
<link href="assets/plugins/magnific-popup/css/magnific-popup.css"
	rel="stylesheet" />
<link href="assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css"
	rel="stylesheet" />

<!-- Theme CSS -->
<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />

<!-- Page CSS -->
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/add-ons.min.css" rel="stylesheet" />

<link href="assets/plugins/jquery-datatables-bs3/css/datatables.css"
	rel="stylesheet" />
<!-- end: CSS file-->


<!-- Head Libs -->
<script src="assets/plugins/modernizr/js/modernizr.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- dialog for confirm delete -->
	<div id="dialog"
		class="modal-block modal-header-color modal-block-primary mfp-hide">
		<div class="panel">
			<div class="panel-heading">
				<h2 class="panel-title">确定删除？</h2>
			</div>
			<div class="panel-body bk-noradius">
				<div class="modal-wrapper">
					<div class="modal-icon">
						<i class="fa fa-question-circle"></i>
					</div>
					<div class="modal-text">
						<p>您确定删除本条目吗？</p>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-md-12 text-right">
						<button id='dialogConfirm' class="btn btn-primary modal-confirm">确认</button>
						<button id='dialogCancel' class="btn btn-default modal-dismiss">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- dialog end -->
	<!-- Modal addUser -->
	<div id="modalAnim"
		class="zoom-anim-dialog modal-block modal-block-primary mfp-hide">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">增加用户</h2>
			</div>
			<div class="panel-body bk-noradius">
				<div class="form-group mt-lg">
					<label class="col-sm-3 control-label">用户名</label>
					<div class="col-sm-9">
						<input type="text" id="userName" class="form-control"
							placeholder="输入用户的姓名..." required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-9">
						<input class="form-control input-sm valid" id="userPwd" required
							type="password">
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-md-12 text-right">
						<button class="btn btn-primary modal-confirm" onclick='addYh()'>确定</button>
						<button class="btn btn-default modal-dismiss">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Model addUser End -->

	<!-- Modal Animation -->
	<div id="userInfo"
		class="zoom-anim-dialog modal-block modal-block-primary mfp-hide">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">增加用户</h2>
			</div>
			<div class="panel-body bk-noradius">
				<form id="demo-form" class="form-horizontal mb-lg"
					novalidate="novalidate">
					<div class="form-group mt-lg">
						<label class="col-sm-3 control-label">姓名</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control"
								placeholder="输入用户的姓名..." required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">职务</label>
						<div class="col-sm-9">
							<select id="select" name="select" class="form-control" size="1">
								<option value="0">请选择</option>
								<option value="1">关员</option>
								<option value="2">主任</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">工号</label>
						<div class="col-sm-9">
							<input type="text" name="workId" class="form-control"
								placeholder="输入用户的工号..." />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">电话</label>
						<div class="col-sm-9">
							<input type="text" name="phone" class="form-control"
								placeholder="输入用户的电话..." />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">手机号码</label>
						<div class="col-sm-9">
							<input type="text" name="mobile" class="form-control"
								placeholder="输入用户的手机号码..." />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">邮箱地址</label>
						<div class="col-sm-9">
							<input type="email" name="email" class="form-control"
								placeholder="输入用户的邮箱地址..." />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">住址</label>
						<div class="col-sm-9">
							<input type="text" name="address" class="form-control"
								placeholder="输入用户的家庭住址..." />
						</div>
					</div>
				</form>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-md-12 text-right">
						<button class="btn btn-primary modal-confirm">确定</button>
						<button class="btn btn-default modal-dismiss">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Animation End-->

	<!-- Start: Header -->
	<jsp:include page="/common/head.jsp"></jsp:include>
	<!-- End: Header -->

	<!-- Start: Content -->
	<div class="container-fluid content">
		<div class="row">

			<!-- Sidebar -->
			<jsp:include page="/common/sidebarManage.jsp"></jsp:include>
			<!-- End Sidebar -->

			<!-- Main Page -->
			<div class="main ">
				<!-- Page Header -->
				<div class="page-header">
					<div class="pull-left">
						<ol class="breadcrumb visible-sm visible-md visible-lg">
							<li><a href="index.html"><i class="icon fa fa-home"></i>首页</a></li>
							<li class="active"><i class="fa fa-cog"></i>参数维护</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>参数维护</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row mailbox">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<div class="panel">
							<div class="panel-body bk-bg-very-light-gray mailbox-menu">
								<h5 class="bk-fg-primary">参数维护</h5>
								<ul class="">
									<li><a href="#tab_1" data-toggle="tab">人员维护 <span
											class="ball red"></span></a></li>
									<li><a href="#tab_2" data-toggle="tab">场地类别维护 <span
											class="ball green"></span></a></li>
									<li><a href="#tab_3" data-toggle="tab">业务类别维护<span
											class="ball blue"></span></a></li>
									<li><a href="#tab_4" data-toggle="tab">检查要求维护<span
											class="ball orange"></span></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-9 col-md-8 col-sm-8 col-xs-12">
						<div class="tab-content bk-bg-very-light-gray">
							<div id="tab_1" class="tab-pane active">
								<div class="panel panel-default bk-bg-white">
									<div class="panel-heading bk-bg-white">
										<h6>
											<i class="fa fa-table red"></i><span class="break"></span>场地类别列表
										</h6>
										<div class="panel-actions">
											<a href="#" class="btn-minimize"><i
												class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
												class="fa fa-times"></i></a>
										</div>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="bk-margin-bottom-10">
													<button id="addToTableYh" class="btn btn-info">
														增加用户 <i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
										</div>
										<table class="table table-bordered table-striped mb-none"
											id="datatable-yh">
											<thead>
												<tr>
													<th>编号</th>
													<th>姓名</th>
													<th>用户名</th>
													<th>密码</th>
													<th>职务</th>
													<th>工号</th>
													<th>用户角色</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${userList}" var="user">
													<tr>
														<td>${user.yhbh}</td>
														<td>${user.yhmc}</td>
														<td>${user.yhdm}</td>
														<td>${user.yhkl}</td>
														<td>${user.yh_duty}</td>
														<td>${user.yh_jobNum}</td>
														<td>${user.perChn}</td>
														<td class="actions"><a href="#"
															class="hidden on-editing save-row"><i
																class="fa fa-save"></i></a> <a href="#"
															class="hidden on-editing cancel-row"><i
																class="fa fa-times"></i></a> <a href="#"
															class="on-default edit-row"><i class="fa fa-pencil"></i></a>
															<a href="#" class="on-default remove-row"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div id="tab_2" class="tab-pane">
								<div class="panel panel-default bk-bg-white">
									<div class="panel-heading bk-bg-white">
										<h6>
											<i class="fa fa-table red"></i><span class="break"></span>场地类别列表
										</h6>
										<div class="panel-actions">
											<a href="#" class="btn-minimize"><i
												class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
												class="fa fa-times"></i></a>
										</div>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="bk-margin-bottom-10">
													<button id="addToTableCdlb" class="btn btn-info">
														增加场地类别 <i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
										</div>
										<table class="table table-bordered table-striped mb-none"
											id="datatable-cdlb">
											<thead>
												<tr>
													<th>编号</th>
													<th>场地类别</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${cdList}" var="cd">
													<tr>
														<td>${cd.DMBH}</td>
														<td>${cd.DMMS}</td>
														<td class="actions"><a href="#"
															class="hidden on-editing save-row"><i
																class="fa fa-save"></i></a> <a href="#"
															class="hidden on-editing cancel-row"><i
																class="fa fa-times"></i></a> <a href="#"
															class="on-default edit-row"><i class="fa fa-pencil"></i></a>
															<a href="#" class="on-default remove-row"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div id="tab_3" class="tab-pane">
								<div class="panel panel-default bk-bg-white">
									<div class="panel-heading bk-bg-white">
										<h6>
											<i class="fa fa-table red"></i><span class="break"></span>业务类别列表
										</h6>
										<div class="panel-actions">
											<a href="#" class="btn-minimize"><i
												class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
												class="fa fa-times"></i></a>
										</div>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="bk-margin-bottom-10">
													<button id="addToTableYwlb" class="btn btn-info">
														增加业务类别 <i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
										</div>
										<table class="table table-bordered table-striped mb-none"
											id="datatable-ywlb">
											<thead>
												<tr>
													<th>编号</th>
													<th>场地类别</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${ywList}" var="yw">
													<tr>
														<td>${yw.DMBH}</td>
														<td>${yw.DMMS}</td>
														<td class="actions"><a href="#"
															class="hidden on-editing save-row"><i
																class="fa fa-save"></i></a> <a href="#"
															class="hidden on-editing cancel-row"><i
																class="fa fa-times"></i></a> <a href="#"
															class="on-default edit-row"><i class="fa fa-pencil"></i></a>
															<a href="#" class="on-default remove-row"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div id="tab_4" class="tab-pane">
								<div class="panel panel-default bk-bg-white">
									<div class="panel-heading bk-bg-white">
										<h6>
											<i class="fa fa-table red"></i><span class="break"></span>检查要求列表
										</h6>
										<div class="panel-actions">
											<a href="#" class="btn-minimize"><i
												class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
												class="fa fa-times"></i></a>
										</div>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="bk-margin-bottom-10">
													<button id="addToTableJcyq" class="btn btn-info">
														增加检查要求<i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
										</div>
										<table class="table table-bordered table-striped mb-none"
											id="datatable-jcyq">
											<thead>
												<tr>
													<th>编号</th>
													<th>场地类别</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${jcyqList}" var="jcyq">
													<tr>
														<td>${jcyq.DMBH}</td>
														<td>${jcyq.DMMS}</td>
														<td class="actions"><a href="#"
															class="hidden on-editing save-row"><i
																class="fa fa-save"></i></a> <a href="#"
															class="hidden on-editing cancel-row"><i
																class="fa fa-times"></i></a> <a href="#"
															class="on-default edit-row"><i class="fa fa-pencil"></i></a>
															<a href="#" class="on-default remove-row"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End Main Page -->

			<!-- Footer -->
			<jsp:include page="/common/footer.jsp"></jsp:include>
			<!-- End Footer -->

		</div>
	</div>
	<!--/container-->


	<div class="clearfix"></div>

	<!-- start: JavaScript-->

	<!-- Vendor JS-->
	<script src="assets/vendor/js/jquery.min.js"></script>
	<script src="assets/vendor/js/jquery-2.1.1.min.js"></script>
	<script src="assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/skycons/js/skycons.js"></script>
	<script src="assets/vendor/js/pace.min.js"></script>

	<!-- Plugins JS-->
	<script src="assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
	<script
		src="assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="assets/plugins/bootkit/js/bootkit.js"></script>
	<script src="assets/plugins/magnific-popup/js/magnific-popup.js"></script>
	<script src="assets/plugins/moment/js/moment.min.js"></script>
	<script src="assets/plugins/fullcalendar/js/fullcalendar.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.pie.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.resize.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.stack.min.js"></script>
	<script src="assets/plugins/flot/js/jquery.flot.time.min.js"></script>
	<script src="assets/plugins/flot-tooltip/js/jquery.flot.tooltip.js"></script>
	<script src="assets/plugins/chart-master/js/Chart.js"></script>
	<script src="assets/plugins/jqvmap/jquery.vmap.js"></script>
	<script src="assets/plugins/jqvmap/data/jquery.vmap.sampledata.js"></script>
	<script src="assets/plugins/jqvmap/maps/jquery.vmap.world.js"></script>
	<script src="assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>

	<script
		src="assets/plugins/jquery-datatables/media/js/jquery.dataTables.js"></script>
	<script
		src="assets/plugins/jquery-datatables/extras/TableTools/js/dataTables.tableTools.min.js"></script>
	<script src="assets/plugins/jquery-datatables-bs3/js/datatables.js"></script>

	<!-- Theme JS -->
	<script src="assets/js/jquery.mmenu.min.js"></script>
	<script src="assets/js/core.min.js"></script>

	<!-- Pages JS -->
	<script src="assets/js/pages/mailbox.js"></script>
	<script src="assets/js/pages/table-editable-tab1.js"></script>
	<script src="assets/js/pages/table-editable-tab2.js"></script>
	<script src="assets/js/pages/table-editable-tab3.js"></script>
	<script src="assets/js/pages/table-editable-tab4.js"></script>
	<script src="assets/js/pages/ui-modals.js"></script>

	<script>
		var oTable = $('#sample_editable_1').dataTable();
		$('#sample_editable_1 a.delete').live('click', function(e) {
			e.preventDefault();
			if (confirm("确定要删除此用户？") == false) {
				return;
			}
			var nRow = $(this).parents('tr')[0];
			oTable.fnDeleteRow(nRow);
		});
		function addYh() {
			var yhdm = $('#userName').val();
			var yhkl = $('#userPwd').val();
			$.ajax({
				url : "addYh.json",//
				contentType : "application/json",//application/xml  
				processData : true,//contentType为xml时，些值为false  
				data : {
					yhdm : yhdm,
					yhkl : yhkl
				},
				dataType : "json",//json--返回json数据类型；xml--返回xml  
				success : function(msg) {
					$('#modalAnim #yhdm').val("");
					$('#modalAnim #yhkl').val("");
					$('#modalAnim').modal('hide');
					oTable.fnAddData([ yhdm, '', '', '',
							'<a class="edit" href="javascript:;">编辑</a>',
							'<a class="delete" href="javascript:;">删除</a>' ]);
				},
				error : function(jqXHR, textStatus, errorThrown) {

				},
			});
		}
	</script>
	<!-- end: JavaScript-->

</body>

</html>