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
		<li class="active">编辑公司</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="row">
		<div class="col-md-6">
			<div class="page-title">
				<h2>编辑公司</h2>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">基础信息</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" id="form-company">
						<input type="hidden" value="${companyId}" name="id" id="input-companyId">
						<div class="form-group">
							<h4 class="col-md-2 control-label">公司名</h4>
							<div class="col-md-10">
								<input type="text" class="form-control" name="name" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<h4 class="col-md-2 control-label">初始密码</h4>
							<div class="col-md-3">
								<input type="password" class="form-control" name="password" autocomplete="off">
							</div>
							<div class="col-md-5">
								<label class="check"> <input type="checkbox" class="icheckbox" id="checkbox-resetPassword">重置密码？
								</label>
							</div>
						</div>
					</form>
				</div>
				<div class="panel-footer">
					<button class="btn btn-success btn-lg pull-right" id="btn-submit">
						保存基础信息 <span class="fa fa-floppy-o fa-right"></span>
					</button>
				</div>
			</div>
		</div>
	</div>

	<div class="page-tabs">
		<a href="#first-tab" class="active">公司佣金配置</a> 
		<a href="#second-tab">员工佣金配置</a>
	</div>
	<!-- 公司配置页 开始 -->
	<div class="page-content-wrap page-tabs-item active" id="first-tab">
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">商品</h3>
					</div>
					<div class="panel-body">
						<!-- 商品列表 -->
						<div class="list-group border-bottom" id="list-goods"></div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">佣金配置</h3>
						<ul class="panel-controls">
							<li><div class="btn btn-default" id="btn-add-straight" style="margin-right: 8px;">
									添加<strong>直接</strong>售出配置
								</div></li>
							<li><div class="btn btn-default" id="btn-add-bySales">
									添加<strong>员工</strong>售出配置
								</div></li>
						</ul>
					</div>
					<!-- 公司配置-模板页容器 开始 -->
					<div class="panel-body" id="panel-commision-configuration">
						<!-- 公司配置-模板页 开始 -->
						<div class="panel-body template-configuration template-configuration-straight" id="template-configuration-straight" style="display: none;">
							<table class="table table-bordered table-striped table-actions">
								<thead>
									<tr>
										<th>售出方式</th>
										<th>值</th>
										<th>结算类型</th>
										<th>最小值</th>
										<th>最大值</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="100">直接售出<input class="form-control" type="hidden" name="id"></td>
										<td><input class="form-control" type="number" name="number" value="0"></td>
										<td width="100"><select class="form-control" name="calculateType">
												<option value="1">百分比</option>
												<option value="2">固定值</option>
										</select></td>
										<td><input class="form-control" type="number" name="minSales" value="0"></td>
										<td><input class="form-control" type="number" name="maxSales" value="0"></td>
										<td><div class="btn btn-danger">删除</div></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="panel-body template-configuration template-configuration-bySales" id="template-configuration-bySales" style="display: none;">
							<table class="table table-bordered table-striped table-actions">
								<thead>
									<tr>
										<th>售出方式</th>
										<th>值</th>
										<th>结算类型</th>
										<th>最小值</th>
										<th>最大值</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="100">员工售出<input class="form-control" type="hidden" name="id"></td>
										<td><input class="form-control" type="number" name="number" value="0"></td>
										<td width="100"><select class="form-control" name="calculateType">
												<option value="1">百分比</option>
												<option value="2">固定值</option>
										</select></td>
										<td><input class="form-control" type="number" name="minSales" value="0"></td>
										<td><input class="form-control" type="number" name="maxSales" value="0"></td>
										<td><div class="btn btn-danger">删除</div></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- 公司配置-模板页 结束 -->
						<h3 class="text-center none-configuration-tip">暂无配置</h3>
					</div>
					<!-- 公司配置-模板页容器 结束 -->
					<div class="panel-footer">
						<button class="btn btn-warning btn-lg pull-right" id="btn-save-commisionConfiguration">
							保存佣金配置 <span class="fa fa-floppy-o fa-right"></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 公司配置页 结束 -->
	<!-- 员工配置页 开始 -->
	<div class="page-content-wrap page-tabs-item" id="second-tab">
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">商品</h3>
					</div>
					<div class="panel-body">
						<!-- 商品列表 -->
						<div class="list-group border-bottom" id="sales-list-goods"></div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">佣金配置</h3>
						<ul class="panel-controls">
							<li>
								<div class="btn btn-default" id="sales_btn-add-configuration">添加配置</div>
							</li>
						</ul>
					</div>
					<!-- 员工配置-模板页容器 开始 -->
					<div class="panel-body" id="panel-commision-salesConfiguration">
						<!-- 员工配置-模板页 开始 -->
						<div class="panel-body sales_template-configuration" id="sales_template-configuration" style="display: none;">
							<table class="table table-bordered table-striped table-actions">
								<thead>
									<tr>
										<th>售出方式</th>
										<th>值</th>
										<th>结算类型</th>
										<th>最小值</th>
										<th>最大值</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="100">直接售出<input class="form-control" type="hidden" name="id"></td>
										<td><input class="form-control" type="number" name="number" value="0"></td>
										<td width="100"><select class="form-control" name="calculateType">
												<option value="1">百分比</option>
												<option value="2">固定值</option>
										</select></td>
										<td><input class="form-control" type="number" name="minSales" value="0"></td>
										<td><input class="form-control" type="number" name="maxSales" value="0"></td>
										<td><div class="btn btn-danger">删除</div></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- 员工配置-模板页 结束 -->
						<h3 class="text-center none-configuration-tip">暂无配置</h3>
					</div>
					<!-- 员工配置-模板页容器 结束 -->
					<div class="panel-footer">
						<button class="btn btn-warning btn-lg pull-right" id="sales_btn-save-commisionConfiguration">
							保存佣金配置 <span class="fa fa-floppy-o fa-right"></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 员工配置页 结束 -->

	<!-- 提示框 -->
	<div class="message-box message-box-success animated fadeIn" id="message-box-success">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-check"></span> 添加成功
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
					<span class="fa fa-times"></span> 失败
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
	<!-- 删除配置确认对话框 开始 -->
	<div class="message-box message-box-danger animated fadeIn" id="dialog-configurationRemoveConfirm">
		<input type="hidden" id="input-configurationToRemove">
		<div class="mb-container">
			<div class="mb-middle">
				<div class="mb-title">
					<span class="fa fa-times"></span> 确定配置？
				</div>
				<div class="mb-footer">
					<button class="btn btn-default btn-lg pull-right mb-control-close">取消</button>
					<button class="btn btn-warning btn-lg pull-right" id="btn-removeConfiguration" style="margin-right: 12px;">确定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除配置确认对话框 结束 -->

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>  --%>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-select.js"></script>
	<script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/icheck/icheck.min.js'></script>

	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>
	<script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>

	<script type="text/javascript" src="<%=basePath%>jslib/jquery.serializejson/jquery.serializejson.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/global.function.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/admin/company_edit.js"></script>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/demo_dashboard.js"></script> --%>

</body>
</html>






