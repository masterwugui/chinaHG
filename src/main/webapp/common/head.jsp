<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<div class="navbar" role="navigation">
		<div class="container-fluid container-nav">
			<!-- Navbar Action -->
			<ul class="nav navbar-nav navbar-actions navbar-left">
				<li class="visible-md visible-lg"><a href="#"
					id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
				<li class="visible-xs visible-sm"><a href="#" id="sidebar-menu"><i
						class="fa fa-navicon"></i></a></li>
			</ul>
			<!-- Navbar Left -->
			<div class="navbar-left">
				<!-- Search Form -->
			</div>
			<!-- Navbar Right -->
			<div class="navbar-right">
				<!-- Userbox -->
				<div class="userbox">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<figure class="profile-picture hidden-xs hidden">
							<img src="assets/img/avatar.jpg" class="img-circle hidden" alt="" />
						</figure>
						<div class="profile-info">
							<span class="name"> ${sessionScope.yhmc}</span> <span class="role"><i
								class="fa fa-circle bk-fg-success"></i>  ${sessionScope.yhzw}</span>
						</div> <i class="fa custom-caret"></i>
					</a>
					<div class="dropdown-menu">
						<ul class="list-unstyled">
							<li class="dropdown-menu-header bk-bg-white bk-margin-top-15">
								<div class="progress progress-xs  progress-striped active">
									<div class="progress-bar progress-bar-primary"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%;">60%</div>
								</div>
							</li>
							<li><a href="toManageHome.do"><i class="fa fa-anchor"></i> 现场派单</a></li>
							<li><a href="toCheckSearch.do"><i class="fa fa-search"></i> 派单查询</a></li>
							<li><a href="toSettings.do"><i class="fa fa-cog"></i> 参数维护</a></li>
							<li><a href="index.do"><i class="fa fa-power-off"></i>
									登出</a></li>
						</ul>
					</div>
				</div>
				<!-- End Userbox -->
			</div>
			<!-- End Navbar Right -->
		</div>
	</div>