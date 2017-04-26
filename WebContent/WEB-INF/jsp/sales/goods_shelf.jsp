<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="<%=basePath%>/styles/sales/goods_shelf.css" rel="stylesheet" type="text/css">
<title>货架</title>
</head>
<body>
	<div class="lutu-navigation">
		<div class="lutu-logo"><img src="<%=basePath%>/images/lutu-logo.jpg"></div>
	</div>
	<div id="gs-body">
		<div class="gs-g-i">
			<div class="gs-g-i-img">
				<img src="<%=basePath%>images/g1.jpg">
			</div>
			<div class="gs-g-i-name">速霸1000四升两次保养</div>
			<div class="gs-g-i-price">￥ 899</div>
			<div class="gs-g-i-btn">
				<div class="gs-g-i-btn-qrcode">二维码</div>
				<div class="gs-g-i-btn-detail">详情</div>
			</div>
		</div>
		<div class="gs-g-i">
			<div class="gs-g-i-img">
				<img src="<%=basePath%>images/g2.jpg">
			</div>
			<div class="gs-g-i-name">美孚1号六升两次保养</div>
			<div class="gs-g-i-price">￥ 1259</div>
			<div class="gs-g-i-btn">
				<div class="gs-g-i-btn-qrcode">二维码</div>
				<div class="gs-g-i-btn-detail">详情</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/WechatPagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/sales/goods_shelf.js"></script>
</body>
</html>