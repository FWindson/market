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
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css" id="theme" href="<%=basePath%>jslib/atlant/css/theme-default.css">
</head>
<body style="overflow: visible;">

	<!-- START 当前路径 -->
	<ul class="breadcrumb">
		<li><a href="#">公司管理</a></li>
		<li class="active">公司列表</li>
	</ul>
	<!-- END 当前路径 -->

	<div class="col-md-12">

		<!-- START DATATABLE EXPORT -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">公司列表</h3>
				<div class="btn-group pull-right">
					<button class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
						<i class="fa fa-bars"></i> Export Data
					</button>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a href="#" onClick="$('#customers2').tableExport({type:'excel',escape:'false'});"><img src='<%=basePath%>jslib/atlant/img/icons/xls.png' width="24" /> XLS</a></li>
					</ul>
				</div>

			</div>
			<div class="panel-body panel-body-table">
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-actions">
						<thead>
							<tr>
								<th>公司名</th>
								<th>状态</th>
								<th>剩余佣金</th>
								<th>冻结佣金</th>
								<th width="250">创建时间</th>
								<th width="250">创建者</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="table-body"></tbody>
					</table>
				</div>
			</div>
			<div class="panel-footer" id="table-footer"></div>
		</div>
		<!-- END DATATABLE EXPORT -->
	</div>

	<!-- 提示框 -->
	<div class="message-box message-box-success animated fadeIn" id="message-box-success">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-check"></span> 删除成功
				</div>
				<div class="mb-content" id="mb-content-success">
					<p></p>
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="message-box message-box-danger animated fadeIn" id="message-box-danger">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-times"></span> 删除失败
				</div>
				<div class="mb-content" id="mb-content-danger">
					<p></p>
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end s提示框 -->
	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>  --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/jquery.serializejson/jquery.serializejson.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>

	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.function.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.basic-data.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/AtlantPagination.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>scripts/admin/company_list.js"></script>

</body>
</html>






