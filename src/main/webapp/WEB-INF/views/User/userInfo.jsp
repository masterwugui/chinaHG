<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">

<head>

<!-- Basic -->
<meta charset="UTF-8" />

<title>中国海关 |个人信息</title>

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
	<!-- Start: Header -->
	<jsp:include page="/common/headUser.jsp"></jsp:include>
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
							<li class="active"><i class="fa fa-laptop"></i>个人信息</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>个人信息</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default bk-bg-white">
							<div class="panel-heading bk-bg-white">
								<h6>
									<i class="fa fa-indent red"></i>个人基本信息
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body form-horizontal ">
								<div class="form-group">
									<label class="col-md-3 control-label">用户名称</label>
									<div class="col-md-9">
										<p class="form-control-static">${userModel.yhmc}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="disabled-input">密码</label>
									<div class="col-md-3">
										<input type="text" id="pwd-input" value="${userModel.yhkl}"
											class="form-control disable-input" placeholder="Disabled"
											disabled>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3">
										<button onclick='resetPwd()' class="bk-margin-5 btn btn-info">修改密码</button>
										<button onclick='savePwd()'
											class="bk-margin-5 btn btn-default">保存</button>
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
	<script>
		function resetPwd() {
			$('.disable-input').removeAttr("disabled");
		}
		function savePwd() {
			var pwd = $('#pwd-input').val();
			$
			.ajax({
				url : "savePwd.json",
				contentType : "application/json",// application/xml
				processData : true,// contentType为xml时，些值为false
				data : {
					pwd : pwd
				},
				dataType : "json",// json--返回json数据类型；xml--返回xml
				success : function(msg) {
					$('.disable-input').attr("disabled", "disabled");
				},
				error : function(jqXHR, textStatus,
						errorThrown) {
				},
			});
		}
	</script>
	<!-- end: JavaScript-->
</body>

</html>