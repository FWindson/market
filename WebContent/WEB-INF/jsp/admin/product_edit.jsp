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
<body style="overflow: visible;">

	<!-- START 当前路径 -->
	<ul class="breadcrumb">
		<li><a href="#">商品管理</a></li>
		<li class="active">添加产品</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-8">
		<div class="page-title">
			<h2>添加产品</h2>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<h4 class="col-md-1">产品名</h4>
						<div class="col-md-5">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<h4 class="col-md-1">价格</h4>
						<div class="col-md-5">
							<input type="number" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<h4 class="col-md-1">库存</h4>
						<div class="col-md-5">
							<input type="number" class="form-control">
						</div>
					</div>
				</form>
			</div>
			<div class="panel-body">
				<div class="col-md-6">
					<h4>产品简介</h4>
					<textarea class="summernote" id="textarea-intro"></textarea>
				</div>
				<div class="col-md-6">
					<h4>产品详情</h4>
					<textarea class="summernote" id="textarea-desc"></textarea>
				</div>
			</div>
		</div>
	</div>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>               --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>

	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/icheck/icheck.min.js'></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/scrolltotop/scrolltopcontrol.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-timepicker.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-colorpicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-file-input.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-select.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/tagsinput/jquery.tagsinput.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/summernote/summernote.js"></script>
	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/settings.js"></script> --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/demo_dashboard.js"></script> --%>

</body>
</html>






