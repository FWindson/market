<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en" class="body-full-height">
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css" id="theme"
	href="<%=basePath%>jslib/atlant/css/theme-default.css">
</head>
<body>
	<input type="hidden" id="input-returnUrl" value="${returnUrl}" />
	<div class="login-container">

		<div class="login-box animated fadeInDown">
			<div class="login-logo"></div>
			<div class="login-body">
				<div class="login-title">
					<strong>欢迎</strong>，请登录您的公司账号
				</div>
				<form action="login_submit" class="form-horizontal" method="post">
					<div class="form-group">
						<div class="col-md-12">
							<input type="text" name="name" class="form-control"
								placeholder="公司名" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<input type="password" name="password" class="form-control"
								placeholder="密码" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-6">
							<a href="#" class="btn btn-link btn-block">忘记密码?</a>
						</div>
						<div class="col-md-6">
							<div class="btn btn-info btn-block" id="btn-login">登录</div>
						</div>
					</div>
				</form>
			</div>
			<div class="login-footer">
				<div class="pull-left">&copy; 2015 路途商城</div>
				<div class="pull-right">
					<a href="#">About</a> | <a href="#">Privacy</a> | <a href="#">Contact
						Us</a>
				</div>
			</div>
		</div>

	</div>

	<!-- danger with sound -->
	<div class="message-box message-box-danger animated fadeIn"
		data-sound="fail" id="message-box-sound-2">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-times"></span> 登录失败
				</div>
				<div class="mb-content">
					<h4 style="color:white;">公司名或密码输入错误，请重新尝试</h4>
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- js引用 -->
	<script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/company/login.js"></script>

	<script type='text/javascript' src="<%=basePath%>jslib/atlant/plugins/noty/jquery.noty.js"></script>
        
    </body>
</html>






