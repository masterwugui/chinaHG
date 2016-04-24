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
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" />
<link
	href="assets/plugins/bootstrap-datepicker/css/datepicker-theme.css"
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
							<li class="active"><i class="fa fa-search"></i>派单查询</li>
						</ol>
					</div>
					<div class="pull-right">
						<h2>现场派单</h2>
					</div>
				</div>
				<!-- End Page Header -->
				<div class="row">
					<div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default bk-bg-white">
							<div class="panel-heading bk-bg-white">
								<h6>
									<i class="fa fa-indent red"></i>业务查询
								</h6>
								<div class="panel-actions">
									<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
									<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body form-horizontal">
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">用户名称</label>
									<div class="col-md-9">
										<select id="yhSelect" class="m-wrap form-control">
											<option value="0">不限</option>
											<c:forEach items="${userList}" var="user">
												<option value="${user.yhbh}">${user.yhmc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">场地类别</label>
									<div class="col-md-9">
										<select id="cdlbSelect" class="m-wrap span12 form-control">
											<option value="0">不限</option>
											<c:forEach items="${cdList}" var="cd">
												<option value="${cd.DMBH}">${cd.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">业务类别</label>
									<div class="col-md-9">
										<select id="ywlbSelect" class="m-wrap span12 form-control">
											<option value="0">不限</option>
											<c:forEach items="${ywList}" var="yw">
												<option value="${yw.DMBH}">${yw.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">检查要求</label>
									<div class="col-md-9">
										<select id="jcyqSelect" class="m-wrap span12 form-control">
											<option value="0">不限</option>
											<c:forEach items="${jcyqList}" var="jcyq">
												<option value="${jcyq.DMBH}">${jcyq.DMMS}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">派单生成时间</label>
									<div class="col-md-9">
										<div class="input-daterange input-group"
											data-plugin-datepicker>
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span> <input type="text" class="form-control" name="start"
												id="startScsj" /> <span class="input-group-addon">到</span>
											<input type="text" class="form-control" name="end"
												id="endScsj" />
										</div>
									</div>
								</div>
								<div class="form-group col-md-6">
									<label class="col-md-3 control-label">完成时间</label>
									<div class="col-md-9">
										<div class="input-daterange input-group"
											data-plugin-datepicker>
											<span class="input-group-addon"> <i
												class="fa fa-calendar"></i>
											</span> <input type="text" class="form-control" name="start"
												id="startWcsj" /> <span class="input-group-addon">到</span>
											<input type="text" class="form-control" name="end"
												id="endWcsj" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label"></label>
									<div class="col-md-9">
										<a onclick='cxChecks()'
											class="bk-margin-5 btn btn-labeled btn-success pull-right">
											<span class="btn-label"><i class="fa fa-check"></i></span>查询
										</a>
										<a href='printSearchResult.do'
											class="bk-margin-5 btn btn-labeled btn-primary pull-right">
											<span class="btn-label"><i class="fa fa-print"></i></span>打印
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default bk-bg-white">
							<div class="panel-heading bk-bg-white">
								<h6>
									<i class="fa fa-table red"></i><span class="break"></span>作业列表
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
											<th>生成时间</th>
											<th>用户名称</th>
											<th>场地类别</th>
											<th>业务类别</th>
											<th>检查内容</th>
											<th>确认时间</th>
											<th>完成时间</th>
											<th>派单领导</th>
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
												<td>${model.zxrb_status}</td>
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
		src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
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
	<script src="assets/js/pages/form-elements.js"></script>
	<!-- end: JavaScript-->
	<script>
		var oTable = $('#sample_editable_1').dataTable();
		function cxChecks() {
			oTable.fnClearTable();
			var yhbh = $('#yhSelect').val();
			var cd = $("#cdlbSelect").val();
			var ywlb = $("#ywlbSelect").val();
			var jcyq = $("#jcyqSelect").val();
			var startScsj = $('#startScsj').val();
			var endScsj = $('#endScsj').val();
			var startWcsj = $('#startWcsj').val();
			var endWcsj = $('#endWcsj').val();
			if (startScsj == "" || endScsj == "") {
				alert("请选择派单生成时间的范围");
			} else if (startWcsj == "" || endWcsj == "") {
				alert("请选择派单完成时间的范围");
			} else {
				startScsj = startScsj + " 00:00:00";
				endScsj = endScsj + " 23:59:59";
				startWcsj = startWcsj + " 00:00:00";
				endWcsj = endWcsj + " 23:59:59";
				$.ajax({
					url : "searchChecks.json",
					contentType : "application/json",//application/xml  
					processData : true,//contentType为xml时，些值为false  
					data : {
						yhbh : yhbh,
						cd : cd,
						ywlb : ywlb,
						jcyq : jcyq,
						startScsj : startScsj,
						endScsj : endScsj,
						startWcsj : startWcsj,
						endWcsj : endWcsj
					},
					dataType : "json",//json--返回json数据类型；xml--返回xml  
					success : function(msg) {
						for (var i = 0; i < msg.modelList.length; i++) {
							var model = msg.modelList[i];
							oTable.fnAddData([ model.scsj, model.zxr_name,
									model.cdChn, model.ywlbChn, model.jcyqChn,
									model.zxr_qrsj, model.zxr_wcsj,
									model.scr_name ]);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
					},
				});
			}
		}
	</script>
</body>

</html>