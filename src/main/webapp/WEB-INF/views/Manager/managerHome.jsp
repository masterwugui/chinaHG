<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">

<head>

<!-- Basic -->
<meta charset="UTF-8" />

<title>中国海关 |首页</title>

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
<style>
.panel .panel-body {
	background-color: transparent;
}
</style>
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
			<div class="panel-body bk-noradius">
				<div class="ele-container">
					<div class="ele-wrapper">
						<div class="ele-tail"></div>
						<div class="ele-body">
							<div class="ele-head">
								<div class="ele-eyebrows"></div>
								<div class="ele-eyes"></div>
								<div class="ele-mouth"></div>
								<div class="ele-fang-front"></div>
								<div class="ele-fang-back"></div>
								<div class="ele-ear"></div>
							</div>
						</div>
						<div class="ele-leg-1 ele-leg-back">
							<div class="ele-foot"></div>
						</div>
						<div class="ele-leg-2 ele-leg-front">
							<div class="ele-foot"></div>
						</div>
						<div class="ele-leg-3 ele-leg-back">
							<div class="ele-foot"></div>
						</div>
						<div class="ele-leg-4 ele-leg-front">
							<div class="ele-foot"></div>
						</div>
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
							<li><a href="index1.html"><i class="icon fa fa-home"></i>首页</a></li>
							<li class="active"><i class="fa fa-laptop"></i>现场派单</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>现场派单</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default bk-bg-white">
							<div class="panel-heading bk-bg-white">
								<h6>
									<i class="fa fa-indent red"></i>随机抽取关员
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body form-horizontal">
								<div class="form-group">
									<label class="col-md-2 control-label">场地类别</label>
									<div class="col-md-9">
										<select id="cdlbSelect" class="m-wrap  form-control">
											<c:forEach items="${cdList}" var="cd">
												<option value="${cd.DMBH}">${cd.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">业务类别</label>
									<div class="col-md-9">
										<select id="ywlbSelect" class="m-wrap  form-control">
											<c:forEach items="${ywList}" var="yw">
												<option value="${yw.DMBH}">${yw.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">检查要求</label>
									<div class="col-md-9">
										<select id="jcyqSelect" class="m-wrap  form-control">
											<c:forEach items="${jcyqList}" var="jcyq">
												<option value="${jcyq.DMBH}">${jcyq.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label"></label>
									<div class="col-md-9">
										<a onclick='cqUser()'
											class="bk-margin-5 btn btn-labeled btn-success pull-right">
											<span class="btn-label"><i class="fa fa-check"></i></span>确定
										</a>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default bk-bg-white">
							<div class="panel-heading bk-bg-white">
								<h6>
									<i class="fa fa-table red"></i><span class="break"></span>作业进度
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<table
									class="table table-bordered table-striped datatable-default"
									id="sample_editable_1">
									<thead>
										<tr>
											<th>场地类别</th>
											<th>业务类别</th>
											<th>检查要求</th>
											<th>作业人员一</th>
											<th>作业人员一进度</th>
											<th>作业人员二</th>
											<th>作业人员二进度</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${modelList}" var="model">
											<tr>
												<td>${model.cdChn}</td>
												<td>${model.ywlbChn}</td>
												<td>${model.jcyqChn}</td>
												<td>${model.zxra_name}</td>
												<td>${model.zxra_status}</td>
												<td>${model.zxrb_name}</td>
												<td>${model.zxrb_status}</td>
												<td class=""><a
													onclick="removeCheck('${model.ck_bh}')"
													class="on-default remove-row"><i class="fa fa-trash-o"></i></a></td>
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
	<!-- <script src="assets/js/pages/table-advanced.js"></script> -->
	<script src="assets/js/pages/table-advanced.js"></script>
	<script src="assets/js/pages/ui-modals.js"></script>
	<!-- end: JavaScript-->
	<script>
		function removeCheck(checkId) {
			$
			.ajax({
				url : "removeCheck.json",
				contentType : "application/json",//application/xml  
				processData : true,//contentType为xml时，些值为false  
				data : {
					checkId : checkId
				},
				dataType : "json",//json--返回json数据类型；xml--返回xml  
				success : function(msg) {
					window.location.href = "toManageHome.do";
				},
				error : function(jqXHR, textStatus, errorThrown) {
				},
			});
		}
		var oTable = $('#sample_editable_1').dataTable();
		function delayCqUser() {
			$
					.ajax({
						url : "cqUser.json",
						contentType : "application/json",//application/xml  
						processData : true,//contentType为xml时，些值为false  
						data : {
							cd : $("#cdlbSelect").val(),
							ywlb : $("#ywlbSelect").val(),
							jcyq : $("#jcyqSelect").val(),
						},
						dataType : "json",//json--返回json数据类型；xml--返回xml  
						success : function(msg) {
							oTable
									.fnAddData([ msg.checkModel.cdChn,
											msg.checkModel.ywlbChn,
											msg.checkModel.jcyqChn,
											msg.checkModel.zxra_name,
											msg.checkModel.zxra_status,
											msg.checkModel.zxrb_name,
											msg.checkModel.zxrb_status,
											"<a href='#' class='on-default remove-row' 	onclick='removeCheck("+msg.checkModel.ck_bh+")'><i class='fa fa-trash-o'></i></a>" ]);
							$('.form-group a').removeAttr("disabled");
						},
						error : function(jqXHR, textStatus, errorThrown) {
						},
					});
		}
		function cqUser() {
			$('.form-group a').attr("disabled", "disabled");
			setTimeout("delayCqUser()", 2000);
		}
	</script>
</body>

</html>