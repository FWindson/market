<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>商品列表</title>

</head>

<body> 
    <input id="input-companyId" type="hidden" value="${companyId}" />
    <input id="input-salsId" type="hidden" value="${salesId}" />
	 <div id="goodsnDiv" class="content-top1">
	
	</div>
	<%-- <img src="<%=basePath%>images/ce1.jpg"/> --%>

	<script type="text/javascript"
		src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>scripts/store/goods.js"></script> 
	<script type='text/javascript'
		src="<%=basePath%>jslib/atlant/plugins/noty/jquery.noty.js"></script>
</body>
</html>