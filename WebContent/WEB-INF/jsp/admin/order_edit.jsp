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
		<li><a href="#">订单管理</a></li>
		<li class="active">订单详情</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-12">
		<div class="page-title">
			<h2>订单详情</h2>
		</div>
		<div class="col-md-12">
			<form class="form-horizontal" role="form">
				<input type="hidden" name="id" value="${orderId}" id="input-orderId">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">订单号：</h4>
							<div class="col-md-8">
								<h3 class="form-control-static" id="order-code"></h3>
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">状态：</h4>
							<div class="col-md-2">
								<h3 class="form-control-static" id="order-status"></h3>
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">客户：</h4>
							<div class="col-md-4">
								<h3 class="form-control-static" id="order-customer"></h3>
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">订单实付：</h4>
							<div class="col-md-4">
								<h3 class="form-control-static" id="order-totalPrice"></h3>
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">订单原价：</h4>
							<div class="col-md-4">
								<h3 class="form-control-static" id="order-oldPrice"></h3>
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-1 text-right control-label">下单时间：</h4>
							<div class="col-md-4">
								<h3 class="form-control-static" id="order-createTime"></h3>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4" id="row-orderInfluence" style="display:none;">
			<div class="panel panel-default">
				<div class="panel-body panel-body-table">
					<div class="table-responsive">
						<table class="table table-bordered table-striped table-actions">
							<thead>
								<tr>
									<th>折扣类型</th>
									<th>折扣价格</th>
								</tr>
							</thead>
							<tbody id="table-influence-body"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body panel-body-table">
					<div class="table-responsive">
						<table class="table table-bordered table-striped table-actions">
							<thead>
								<tr>
									<th>商品名</th>
									<th>单价</th>
									<th>数量</th>
									<th>原总价</th>
									<th>实付总价</th>
								</tr>
							</thead>
							<tbody id="table-orderDetail-body"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-12">
			<div class="btn btn-success btn-lg pull-right" id="btn-submit">保存</div>
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
	<script type="text/javascript" src="<%=basePath%>scripts/admin/order_edit.js"></script>

</body>
</html>






