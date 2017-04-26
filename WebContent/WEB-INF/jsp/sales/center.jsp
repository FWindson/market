<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<%=basePath%>/styles/global.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/styles/sales/center.css" rel="stylesheet" type="text/css">

<title>销售员中心</title>
</head>
<body>
	<div class="lutu-navigation">
		<div class="lutu-logo"><img src="<%=basePath%>/images/lutu-logo.jpg"></div>
	</div>
	<div class="s-head"></div>
	<div class="s-body">
		<a href="<%=basePath%>/sales/goods_shelf"><div class="s-item">我的货架</div></a>
		<a href="<%=basePath%>/sales/customers"><div class="s-item">我的客户</div></a>
		<a href="<%=basePath%>/sales/customer_orders"><div class="s-item">客户订单</div></a>
		<a href="<%=basePath%>/sales/incomes"><div class="s-item">收入明细</div></a>
		<a href="<%=basePath%>/sales/my_account"><div class="s-item">我的账户</div></a>
	</div>
</body>
</html>