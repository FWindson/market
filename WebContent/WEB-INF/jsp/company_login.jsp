<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="jslib/bootstrap/css/bootstrap.css"></link>
</head>
<body>
	<form>
		<div class="form-group">
			<label for="inputUserName">用户名</label> 
			<input type="text" class="form-control" id="inputUserName" placeholder="请输入用户名" />
		</div>
		<div class="form-group">
			<label for="inputPassword">Password</label> 
			<input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" />
		</div>
		<div class="btn btn-success">登录</div>
	</form>

	<!-- JavaScript引用 -->
	<script src="jslib/jquery/jquery-3.2.0.js"></script>
	<script src="jslib/bootstrap/bootstrap.js"></script>
</body>
</html>