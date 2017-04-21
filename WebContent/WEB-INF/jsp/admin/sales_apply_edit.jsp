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
		<li><a href="#">销售员管理</a></li>
		<li class="active">销售员申请详情</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-12">
		<div class="page-title">
			<h2>销售员申请详情</h2>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form class="form-horizontal" role="form">
					<input type="hidden" name="id" value="${salesApplyId}" id="input-salesApplyId">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">姓名：</h4>
								<div class="col-md-8">
									<h3 class="form-control-static" id="sales-apply-name"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">手机号：</h4>
								<div class="col-md-2">
									<h3 class="form-control-static" id="sales-apply-mobileNumber"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">状态：</h4>
								<div class="col-md-2">
									<h3 class="form-control-static" id="sales-apply-status"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">所属公司：</h4>
								<div class="col-md-4">
									<h3 class="form-control-static" id="sales-apply-companyName"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">留言：</h4>
								<div class="col-md-4">
									<h3 class="form-control-static" id="sales-apply-comment"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">创建时间：</h4>
								<div class="col-md-4">
									<h3 class="form-control-static" id="sales-apply-createTime"></h3>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-2 text-right control-label">审核者：</h4>
								<div class="col-md-4">
									<h3 class="form-control-static" id="sales-apply-handlerBy"></h3>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="col-md-8">
			<div class="col-md-1 pull-right">
				<div class="btn btn-danger btn-lg" id="btn-refuse">拒绝</div>
			</div>
			<div class="col-md-1 pull-right">
				<div class="btn btn-success btn-lg" id="btn-accept">通过</div>
			</div>
		</div>
	</div>

	<!-- 提示框 -->
	<div class="message-box message-box-success animated fadeIn" id="message-box-success">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-check"></span> 成功
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div class="message-box message-box-danger animated fadeIn" id="message-box-danger">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-times"></span> Danger
				</div>
				<div class="mb-content" id="mb-content-danger">
					<span class="fa fa-check"></span> 失败
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end s提示框 -->

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>               --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-select.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/summernote/summernote.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/jquery.serializejson/jquery.serializejson.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.basic-data.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.function.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/AtlantPagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/admin/sales_apply_edit.js"></script>

</body>
</html>






