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
		<li><a href="#">员工管理</a></li>
		<li class="active">员工详情</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-12">
		<div class="page-title">
			<h2>员工详情</h2>
		</div>
		<div class="col-md-12">
			<form class="form-horizontal" role="form" id="form-goods">
				<input type="hidden" name="id" value="${salesId}" id="input-salesId">
				<div class="panel panel-default">
					<div class="col-md-4">
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered">
									<tbody>
										<tr>
											<td>员工名</td>
											<td id="sales_name"></td>
										</tr>
										<tr>
											<td>佣金收入总额</td>
											<td id="sales_commision_total"></td>
										</tr>
										<tr>
											<td>员工状态</td>
											<td id="sales_status"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- <form class="form-horizontal" role="form">
							<div class="form-group">
								<h4 class="col-md-1">员工名</h4>
								<div class="col-md-8">
									<h4 id="sales_name"></h4>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-1">佣金收入总额</h4>
								<div class="col-md-4">
									<h4 id="sales_commision_total"></h4>
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-1">员工状态</h4>
								<div class="col-md-4">
									<h4 id="sales_status"></h4>
								</div>
							</div>
						</form> -->
						</div>
					</div>

					<div class="panel-body">
						<div class="col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">员工客户</h3>
								</div>
								<div class="panel-body panel-body-table">
									<div class="table-responsive">
										<table class="table table-bordered table-striped table-actions">
											<thead>
												<tr>
													<th>姓名</th>
												</tr>
											</thead>
											<tbody id="table-customer-body"></tbody>
										</table>
									</div>
								</div>
								<div class="panel-footer" id="table-customer-footer"></div>
							</div>
						</div>
						<div class="col-md-12" style="margin-top: 30px;">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">员工收入明细</h3>
								</div>
								<div class="panel-body panel-body-table">
									<div class="table-responsive">
										<table class="table table-bordered table-striped table-actions">
											<thead>
												<tr>
													<th>订单号</th>
													<th>商品</th>
													<th>数量</th>
													<th>合计</th>
													<th>时间</th>
													<th>获得佣金</th>
												</tr>
											</thead>
											<tbody id="table-commision-body"></tbody>
										</table>
									</div>
								</div>
								<div class="panel-footer" id="table-commision-footer"></div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-12" id="panel-product-seleted">
			<!-- <div class="panel panel-primary">
				<div class="panel-body">
					<div class="col-md-9">
						<h3 style="margin:0;line-height:28px;">速霸1000四升保养</h3>
					</div>
					<div class="col-md-2">
						<input type="number" class="form-control" placeHolder="数量" pid="abc" name="product-item" />
					</div>
					<div class="col-md-1">
						<div class="btn btn-danger pull-right btn-remove-product">删除</div>
					</div>
				</div>
			</div> -->
		</div>
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">选择要添加的产品</h3>
				</div>
				<div class="panel-body">
					<ul class="list-group border-bottom">
						<!-- <li class="list-group-item">速霸1000四升保养</li>
						<li class="list-group-item">速霸1000五升保养</li>
						<li class="list-group-item">速霸2000四升保养</li>
						<li class="list-group-item">速霸2000五升保养</li>
						<li class="list-group-item">速霸2000六升保养</li>
						<li class="list-group-item">速霸2000七升保养</li>
						<li class="list-group-item">速霸2000七升保养</li> -->
						<c:forEach items="${products}" var="product">
							<a href="javascript:void(0)" class="list-group-item list-item-product" pid="${product.id}">${product.name}</a>
						</c:forEach>
					</ul>
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
					<span class="fa fa-check"></span> 添加产品成功
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
					<p></p>
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
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.function.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.basic-data.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/AtlantPagination.js"></script>

	<script type="text/javascript" src="<%=basePath%>scripts/company/sales_detail.js"></script>

</body>
</html>






