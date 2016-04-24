<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!-- Modal Animation -->
	<div id="modalAnim"
		class="zoom-anim-dialog modal-block modal-block-primary mfp-hide">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">作业执行情况</h2>
			</div>
			<div class="panel-body bk-noradius">
				<div class="modal-wrapper">
					<div class="modal-icon"></div>
					<div class="modal-text">
						<div class="timelineProfile timeline-profile">
							<div class="timeline-body">
								<div class="timeline-title">
									<h5 class="text-uppercase">执行情况时间轴</h5>
								</div>
								<ol class="timeline-items">
									<li>
										<div class="timeline-box">
											<p class="text-muted">2016年1月19日 下午2点</p>
											<p>由 李主任 随机抽取派单</p>
										</div>
									</li>
									<li>
										<div class="timeline-box">
											<p class="text-muted">2016年1月20日 上午11点.</p>
											<p>确认派单 开始作业</p>
										</div>
									</li>
									<li>
										<div class="timeline-box">
											<p class="text-muted">2016年1月22日 上午11点.</p>
											<p>完成作业</p>

										</div>
									</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-md-12 text-right">
						<button id='modal_btn_ok' class="btn btn-primary modal-confirm"
							data-dismiss="modal">确定</button>
						<button class="btn btn-default modal-dismiss" data-dismiss="modal">取消</button>
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
			<jsp:include page="/common/sidebarUser.jsp"></jsp:include>
			<!-- End Sidebar -->

			<!-- Main Page -->
			<div class="main">
				<!-- Page Header -->
				<div class="page-header">
					<div class="pull-left">
						<ol class="breadcrumb visible-sm visible-md visible-lg">
							<li><a href="index1.html"><i class="icon fa fa-home"></i>首页</a></li>
							<li class="active"><i class="fa fa-laptop"></i>作业情况</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>作业情况</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row profile">
					<div class="col-lg-4 col-md-5 col-sm-5">
						<div class="panel">
							<div class="panel-body">
								<div
									class="text-left bk-bg-white bk-padding-top-40 bk-padding-bottom-10">
									<div class="row">
										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 bk-vcenter text-center">
											<div class="bk-avatar hidden">
												<img src="assets/img/avatar.jpg" alt=""
													class="img-circle bk-img-120 bk-border-light-gray bk-border-3x" />
											</div>
											<h4 class="bk-margin-top-10 bk-docs-font-weight-300"> ${sessionScope.yhmc}</h4>
										</div>
										<hr class="bk-margin-off" />

										<div
											class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-left bk-vcenter text-center">
											<hr class="bk-margin-off" />
											<small>待确认：<span>${sessionScope.notStarted}</span>件</small>
											<div class="progress bk-margin-bottom-10"
												style="height: 8px;">
												<div class="progress thin progress-striped active">
													<div class="progress-bar progress-bar-primary"
														role="progressbar" aria-valuenow="60" aria-valuemin="0"
														aria-valuemax="100" style="width: 60%;">
														<span class="sr-only">60% Complete</span>
													</div>
												</div>
											</div>
											<small>待执行：<span>${sessionScope.notFinished}</span>件</small>
											<div class="progress bk-margin-bottom-10"
												style="height: 8px;">
												<div class="progress thin progress-striped active">
													<div class="progress-bar progress-bar-danger"
														role="progressbar" aria-valuenow="88" aria-valuemin="0"
														aria-valuemax="100" style="width: 88%;">
														<span class="sr-only">88% Complete</span>
													</div>
												</div>
											</div>
											<small>已完成： <span>${sessionScope.hasFinished}</span>件</small>
											<div class="progress bk-margin-off-bottom"
												style="height: 8px;">
												<div class="progress thin progress-striped active">
													<div class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="35" aria-valuemin="0"
														aria-valuemax="100" style="width: 35%;">
														<span class="sr-only">35% Complete</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr class="bk-margin-off" />
								<div class="bk-ltr bk-bg-white">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="bk-widget bk-border-off bk-webkit-fix">
												<div
													class="bk-bg-white text-center bk-padding-top-20 bk-padding-bottom-10">
													<div class="row">
														<div class="text-left bk-padding-left-10">
															<h4 class="bk-margin-off">个人信息</h4>
														</div>
													</div>
												</div>
												<div class="bs-example">
													<div id="carousel-example-generic3"
														class="carousel bk-carousel-fade slide"
														data-ride="carousel">
														<div class="carousel-inner">
															<div class="item">
																<a
																	class="panel-body bk-bg-white bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
																	<div
																		class="pull-left bk-margin-top-10 bk-margin-right-10">
																		<div
																			class="bk-round bk-bg-darken bk-border-off bk-icon bk-icon-default bk-bg-primary">
																			<i class="fa fa-thumbs-up"></i>
																		</div>
																	</div>
																	<h5
																		class="bk-fg-primary bk-fg-darken bk-margin-off-bottom">职务</h5>
																	<p>
																		<small>${sessionScope.yhzw}</small>
																	</p>
																</a>
															</div>
															<div class="item active">
																<a
																	class="panel-body bk-bg-white bk-bg-lighten bk-padding-off-top bk-padding-off-bottom">
																	<div
																		class="pull-left bk-margin-top-10 bk-margin-right-10">
																		<div
																			class="bk-round bk-bg-darken bk-border-off bk-icon bk-icon-default bk-bg-info">
																			<i class="fa fa-building-o"></i>
																		</div>
																	</div>
																	<h5
																		class="bk-fg-info bk-fg-darken bk-margin-off-bottom">工号</h5>
																	<p>
																		<small>${sessionScope.yhJobNum}</small>
																	</p>
																</a>
															</div>
														</div>
														<a
															class="left carousel-control bk-carousel-control bk-carousel-control-white bk-carousel-hide-init"
															href="#carousel-example-generic3" role="button"
															data-slide="prev"> <span
															class="fa fa-angle-left icon-prev bk-bg-very-light-gray"></span>
														</a> <a
															class="right carousel-control bk-carousel-control bk-carousel-control-white bk-carousel-hide-init"
															href="#carousel-example-generic3" role="button"
															data-slide="next"> <span
															class="fa fa-angle-right icon-next"></span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr class="bk-margin-off" />
								<div class="bk-ltr bk-bg-white">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div
												class="bk-bg-white text-center bk-padding-top-20 bk-padding-bottom-10">
												<div class="row">
													<div class="text-left bk-padding-left-10">
														<h4 class="bk-margin-off">地址</h4>
													</div>
												</div>
											</div>
											<div
												class="bk-bg-white bk-bg-lighten bk-padding-top-10 bk-padding-left-20">
												<div class="pull-left bk-margin-right-10">
													<div class="bk-round bk-bg-darken bk-border-off">
														<i class="fa fa-map-marker fa-2x bk-fg-danger"></i>
													</div>
												</div>
												<p class="text-left">
													<small>南京市四牌楼大街双科小区5栋</small>
												</p>
											</div>
										</div>
									</div>
								</div>
								<div class="bk-ltr bk-padding-bottom-20 bk-padding-left-20">
									<div class="row">
										<div
											class="col-12-4 col-md-12 col-sm-12 col-xs-12 bk-bg-white bk-padding-top-10">
											<i class="fa fa-phone"></i> +0512 8888 8888
										</div>
										<div
											class="col-12-4 col-md-12 col-sm-12 col-xs-12 bk-bg-white bk-padding-top-10">
											<i class="fa fa-tablet"></i> +157 8888 8888
										</div>
										<div
											class="col-12-4 col-md-12 col-sm-12 col-xs-12 bk-bg-white bk-padding-top-10">
											<i class="fa fa-envelope"></i> ********@mail.com
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-8 col-md-7 col-sm-7">
						<div class="panel">
							<div class="panel-body">
								<div class="tabs tabs-warning">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#overview" data-toggle="tab">未确认作业</a>
										</li>
										<li><a href="#edit" data-toggle="tab">未完成作业</a></li>
										<li><a href="#finish" data-toggle="tab">已完成作业</a></li>
									</ul>
									<div class="tab-content">
										<div id="overview" class="tab-pane active">
											<div class="panel panel-default bk-bg-white">
												<div class="panel-heading bk-bg-white">
													<h6>
														<i class="fa fa-table red"></i><span class="break"></span>待确认作业
													</h6>
													<div class="panel-actions">
														<a href="#" class="btn-minimize"><i
															class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
															class="fa fa-times"></i></a>
													</div>
												</div>

												<div class="panel-body">
													<table
														class="table table-bordered table-striped datatable-default"
														id="datatable-overview">
														<thead>
															<tr>
																<th>场地类别</th>
																<th>业务类别</th>
																<th>检查要求</th>
																<th class='hidden'></th>
																<th class='hidden'></th>
																<th class='hidden'></th>
																<th>操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${modelNotStartedList}" var="model">
																<tr>
																	<td>${model.cdChn}</td>
																	<td>${model.ywlbChn}</td>
																	<td>${model.jcyqChn}</td>
																	<td class='hidden'>${model.checkId}</td>
																	<td class='hidden'>${model.scr_name}</td>
																	<td class='hidden'>${model.scsj}</td>
																	<td><a class="confirmWork modal-with-zoom-anim"
																		href="javascript:;">确认作业</a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
										<div id="edit" class="tab-pane updateProfile">
											<div class="panel panel-default bk-bg-white">
												<div class="panel-heading bk-bg-white">
													<h6>
														<i class="fa fa-table red"></i><span class="break"></span>在执行作业
													</h6>
													<div class="panel-actions">
														<a href="#" class="btn-minimize"><i
															class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
															class="fa fa-times"></i></a>
													</div>
												</div>

												<div class="panel-body">
													<table
														class="table table-bordered table-striped datatable-default"
														id="datatable-edit">
														<thead>
															<tr>
																<th>派单编号</th>
																<th>场地类别</th>
																<th>业务类别</th>
																<th>检查要求</th>
																<th>确认时间</th>
																<th>操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${modelConfirmedList}" var="model">
																<tr>
																	<td>${model.checkId}</td>
																	<td>${model.cdChn}</td>
																	<td>${model.ywlbChn}</td>
																	<td>${model.jcyqChn}</td>
																	<td>${model.zxr_qrsj}</td>
																	<td><a class="finishWork modal-with-zoom-anim"
																		href="javascript:;">完成作业</a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
										</div>
										<div id="finish" class="tab-pane">
											<div class="panel panel-default bk-bg-white">
												<div class="panel-heading bk-bg-white">
													<h6>
														<i class="fa fa-table red"></i><span class="break"></span>已完成作业
													</h6>
													<div class="panel-actions">
														<a href="#" class="btn-minimize"><i
															class="fa fa-caret-up"></i></a> <a href="#" class="btn-close"><i
															class="fa fa-times"></i></a>
													</div>
												</div>

												<div class="panel-body">
													<table
														class="table table-bordered table-striped datatable-default"
														id="datatable-finish">
														<thead>
															<tr>
																<th>派单编号</th>
																<th>场地类别</th>
																<th>业务类别</th>
																<th>检查要求</th>
																<th>确认时间</th>
																<th>完成时间</th>
																<th>操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${modelFinishedList}" var="model">
																<tr>
																	<td>${model.checkId}</td>
																	<td>${model.cdChn}</td>
																	<td>${model.ywlbChn}</td>
																	<td>${model.jcyqChn}</td>
																	<td>${model.zxr_qrsj}</td>
																	<td>${model.zxr_wcsj}</td>
																	<td><a class='checkWork modal-with-zoom-anim'
																		href='javascript:;'>查看</a></td>
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
					</div>
				</div>
			</div>
		</div>
		<!-- End Main Page -->

		<!-- Footer -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- End Footer -->

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
	<script src="assets/js/pages/index.js"></script>
	<script src="assets/js/pages/table-advanced.js"></script>
	<!-- <script src="assets/js/pages/ui-modals.js"></script> -->
	<script src="assets/js/main.js"></script>
	<!-- end: JavaScript-->
	<script>
		var tableOverView = $('#datatable-overview').dataTable();
		var tableEdit = $('#datatable-edit').dataTable();
		var tableFinish = $('#datatable-finish').dataTable();
		var nRow = null;
		var checkId;
		var status;
		//完成派单
		$('#datatable-edit a.finishWork')
				.live(
						'click',
						function(e) {
							e.preventDefault();

							nRow = $(this).parents('tr')[0];
							checkId = nRow.cells[0].innerHTML;
							status = 1;
							$
									.ajax({
										url : "getUserCheckInfo.json",
										contentType : "application/json",// application/xml
										processData : true,// contentType为xml时，些值为false
										data : {
											checkId : checkId,
										},
										dataType : "json",// json--返回json数据类型；xml--返回xml
										success : function(msg) {
											var item = "<li><div class='timeline-box'><p class='text-muted'>"
													+ msg.checkModel.scsj
													+ "</p><p>由 "
													+ msg.checkModel.scr_name
													+ " 随机抽取派单</p></div></li>";
											var confirmItem = "<li><div class='timeline-box'><p class='text-muted'>"
													+ msg.checkModel.zxr_qrsj
													+ "</p><p>确认派单 开始作业</p></div></li>";
											$('#modalAnim ol.timeline-items')
													.empty();
											$('#modalAnim ol.timeline-items')
													.append(item);
											$('#modalAnim ol.timeline-items')
													.append(confirmItem);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
										},
									});
						});
		//查看派单
		$('#datatable-finish a.checkWork')
				.live(
						'click',
						function(e) {
							e.preventDefault();
							status = 2;
							nRow = $(this).parents('tr')[0];
							checkId = nRow.cells[0].innerHTML;
							$
									.ajax({
										url : "getUserCheckInfo.json",
										contentType : "application/json",// application/xml
										processData : true,// contentType为xml时，些值为false
										data : {
											checkId : checkId,
										},
										dataType : "json",// json--返回json数据类型；xml--返回xml
										success : function(msg) {
											var item = "<li><div class='timeline-box'><p class='text-muted'>"
													+ msg.checkModel.scsj
													+ "</p><p>由 "
													+ msg.checkModel.scr_name
													+ " 随机抽取派单</p></div></li>";
											var confirmItem = "<li><div class='timeline-box'><p class='text-muted'>"
													+ msg.checkModel.zxr_qrsj
													+ "</p><p>确认派单 开始作业</p></div></li>";
											var finishItem = "<li><div class='timeline-box'><p class='text-muted'>"
													+ msg.checkModel.zxr_wcsj
													+ "</p><p>完成作业</p></div></li>";
											$('#modalAnim ol.timeline-items')
													.empty();
											$('#modalAnim ol.timeline-items')
													.append(item);
											$('#modalAnim ol.timeline-items')
													.append(confirmItem);
											$('#modalAnim ol.timeline-items')
											.append(finishItem);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
										},
									});
						});
		//确认派单
		$('#datatable-overview a.confirmWork')
				.live(
						'click',
						function(e) {
							e.preventDefault();
							status = 0;
							nRow = $(this).parents('tr')[0];
							var scr_name = nRow.cells[4].innerHTML;
							checkId = nRow.cells[3].innerHTML;
							var scsj = nRow.cells[5].innerHTML;
							status = 0;
							var item = "<li><div class='timeline-box'><p class='text-muted'>"
									+ scsj
									+ "</p><p>由 "
									+ scr_name
									+ " 随机抽取派单</p></div></li>";
							$('#modalAnim ol.timeline-items').empty();
							$('#modalAnim ol.timeline-items').append(item);
							/*$('#modalAnim').modal({
								backdrop : 'static',
								keyboard : false
							});*/

						});
		$('.modal-with-zoom-anim').magnificPopup({
			items : {
				src : '#modalAnim',
				type : 'inline',
			},
			fixedContentPos : false,
			fixedBgPos : true,

			overflowY : 'auto',

			closeBtnInside : true,
			preloader : false,

			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in',
			modal : true
		});
		/*
		Modal Dismiss
		 */
		$(document).on('click', '.modal-dismiss', function(e) {
			e.preventDefault();
			$.magnificPopup.close();
		});

		/*
		Modal Confirm
		 */
		$(document)
				.on(
						'click',
						'.modal-confirm',
						function(e) {
							e.preventDefault();
							$
									.ajax({
										url : "confirmCheck.json",
										contentType : "application/json",// application/xml
										processData : true,// contentType为xml时，些值为false
										data : {
											checkId : checkId,
											status : status
										},
										dataType : "json",// json--返回json数据类型；xml--返回xml
										success : function(msg) {
											if (status == 0) {
												tableOverView.fnDeleteRow(nRow);
												tableEdit
														.fnAddData([
																msg.checkModel.checkId,
																msg.checkModel.cdChn,
																msg.checkModel.ywlbChn,
																msg.checkModel.jcyqChn,
																msg.checkModel.zxr_qrsj,
																"<td><a class='finishWork  modal-with-zoom-anim' href='javascript:;'>完成作业</a></td>" ]);
											} else if (status == 1) {
												tableEdit.fnDeleteRow(nRow);
												tableFinish
														.fnAddData([
																msg.checkModel.checkId,
																msg.checkModel.cdChn,
																msg.checkModel.ywlbChn,
																msg.checkModel.jcyqChn,
																msg.checkModel.zxr_qrsj,
																msg.checkModel.zxr_wcsj,
																"<td><a class='checkWork modal-with-zoom-anim' href='javascript:;'>查看</a></td>" ]);
											}
											$('.modal-with-zoom-anim').magnificPopup({
												items : {
													src : '#modalAnim',
													type : 'inline',
												},
												fixedContentPos : false,
												fixedBgPos : true,

												overflowY : 'auto',

												closeBtnInside : true,
												preloader : false,

												midClick : true,
												removalDelay : 300,
												mainClass : 'my-mfp-zoom-in',
												modal : true
											});
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
										},
									});
							$.magnificPopup.close();
						});
	</script>
</body>

</html>