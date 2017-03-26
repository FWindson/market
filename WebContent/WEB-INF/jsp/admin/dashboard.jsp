<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css" id="theme" href="<%=basePath%>jslib/atlant/css/theme-default.css">
</head>
<body>
	<!-- 当前路径 -->
	<ul class="breadcrumb">
		<li><a href="#">工作台</a></li>
	</ul>
	<div class="container-fluid">
		<!-- END 当前路径 -->

		<!-- 内容 -->
		<div class="panel panel-success">
			<div class="panel-heading">
				<div class="panel-title">工作台</div>
			</div>
			<div class="panel-body">
				<div class="">这里放工作台内容</div>
			</div>
		</div>
		<!-- END 内容 -->
	</div>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script> --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-select.js"></script>

	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/icheck/icheck.min.js'></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/scrolltotop/scrolltopcontrol.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/morris/raphael-min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/morris/morris.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/rickshaw/d3.v3.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/rickshaw/rickshaw.min.js"></script>
	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>
	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-datepicker.js'></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/owl/owl.carousel.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/moment.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/daterangepicker/daterangepicker.js"></script>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/settings.js"></script> --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/demo_dashboard.js"></script> --%>

</body>
</html>






