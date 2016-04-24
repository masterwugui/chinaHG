<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="sidebar">
	<div class="sidebar-collapse">
		<!-- Sidebar Header Logo-->
		<div class="sidebar-header">
			<img src="assets/img/logo.png" class="img-responsive" alt="" />
		</div>
		<!-- Sidebar Menu-->
		<div class="sidebar-menu">
			<nav id="menu" class="nav-main" role="navigation">
				<ul class="nav nav-sidebar">
					<div class="panel-body text-center">
						<div class="flag">
							<img src="assets/img/flags/china.png" class="img-flags" alt="" />
						</div>
					</div>
					<li class="active"><a href="toManageHome.do"> <i
							class="fa fa-laptop" aria-hidden="true"></i><span>首页</span>
					</a></li>
					<li><a href="toCheckSearch.do"> <i class="fa fa-search"
							aria-hidden="true"></i><span>派单查询</span>
					</a></li>
					<li><a href="toSettings.do"> <i class="fa fa-cog"
							aria-hidden="true"></i><span>参数维护</span>
					</a></li>
				</ul>
			</nav>
		</div>
		<!-- End Sidebar Menu-->
	</div>
	<!-- Sidebar Footer-->
	<div class="sidebar-footer hidden">
		<div class="small-chart-visits">
			<div class="small-chart" id="sparklineLineVisits"></div>
			<div class="small-chart-info">
				<label>New Visits</label> <strong>70,79%</strong>
			</div>
			<script type="text/javascript">
				var sparklineLineVisitsData = [ 15, 16, 17, 19, 15, 25, 23, 35,
						29, 15, 30, 45 ];
			</script>
		</div>
		<ul class="sidebar-terms bk-margin-top-10">
			<li><a href="#">Terms</a></li>
			<li><a href="#">Privacy</a></li>
			<li><a href="#">Help</a></li>
			<li><a href="#">About</a></li>
		</ul>
	</div>
	<!-- End Sidebar Footer-->
</div>