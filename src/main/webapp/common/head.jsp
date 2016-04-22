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
				<!-- Notifications -->
				<ul class="notifications hidden-xs">
					<li><a href="#" class="dropdown-toggle notification-icon"
						data-toggle="dropdown"> <i class="fa fa-bell"></i> <span
							class="badge">3</span>
					</a>
						<ul class="dropdown-menu list-group">
							<li class="dropdown-menu-header"><strong>执行中任务</strong>
								<div class="progress progress-xs  progress-striped active">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%;">60%</div>
								</div></li>
							<li class="list-item"><a href="page-inbox.html">
									<div class="pull-left">
										<i class="fa fa-envelope-o bk-fg-primary"></i>
									</div>
									<div class="media-body clearfix">
										<div>抽检任务一</div>
										<h6>未确认</h6>
									</div>
							</a></li>
							<li class="list-item"><a href="#">
									<div class="pull-left">
										<i class="fa fa-cogs bk-fg-primary"></i>
									</div>
									<div class="media-body clearfix">
										<div>抽检任务二</div>
										<h6>执行中</h6>
									</div>
							</a></li>
							<li class="list-item-last"><a href="#">
									<h6>未读任务</h6> <span class="badge">2</span>
							</a></li>
						</ul></li>
				</ul>
				<!-- End Notifications -->
				<!-- Userbox -->
				<div class="userbox">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<figure class="profile-picture hidden-xs">
							<img src="assets/img/avatar.jpg" class="img-circle" alt="" />
						</figure>
						<div class="profile-info">
							<span class="name">张三</span> <span class="role"><i
								class="fa fa-circle bk-fg-success"></i> 关员</span>
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
							<li><a href=""><i class="fa fa-user"></i> 个人资料</a></li>
							<li><a href="#"><i class="fa fa-wrench"></i> 作业情况</a></li>
							<li><a href="page-invoice"><i class="fa fa-usd"></i>
									个人设置</a></li>
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