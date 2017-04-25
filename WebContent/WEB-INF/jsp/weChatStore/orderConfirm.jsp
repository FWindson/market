<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>styles/style.css" />
<link href="<%=basePath%>styles/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<title>订单确认</title>
</head>
<body>
	<div class="check-out">
		<h1>订单确认</h1>
		<table>
			<tr>
				<th>订单号：${orderNo}</th>
			</tr>
			<tr>
				<th>客户名称：${customerName}</th>
			</tr>
			<tr>
				<th>商品名称：${name}</th>
			</tr>
			<tr>
				<th>商品详情：${descirption}</th>
			</tr>
			<tr>
				<th>支付方式：在线支付</th>
			</tr>
			<tr>
				<th>商品类型：服务类</th>
			</tr>
			<tr>
				<th>商品价格： ${sumPrice}</th>
			</tr>
			<tr>
				<th><a href="<%=basePath%>store/placeOrder?goodsId=${id}&companyId=${companyId}&salesId=${salesId}&discountCode=${discountCode}&count=${count}" class=" to-buy">确定购买</a></th>
			</tr>



		</table>
		<!-- <a href="#" class=" to-buy">立即购买</a> -->
		<div class="clearfix"></div>
	</div>
</body>
</html>