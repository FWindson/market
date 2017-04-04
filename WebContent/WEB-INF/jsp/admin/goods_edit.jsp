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
		<li><a href="#">商品管理</a></li>
		<li class="active">添加商品</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-12">
		<div class="page-title">
			<h2>添加商品</h2>
		</div>
		<div class="col-md-12">
			<form class="form-horizontal" role="form" id="form-goods">
				<input type="hidden" name="id" value="${goodsId}" id="input-goodsid">
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<h4 class="col-md-1">商品名</h4>
								<div class="col-md-8">
									<input type="text" class="form-control" name="name">
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-1">价格</h4>
								<div class="col-md-4">
									<input type="number" class="form-control" name="price">
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-1">市场价</h4>
								<div class="col-md-4">
									<input type="number" class="form-control" name="markePrice">
								</div>
							</div>
							<div class="form-group">
								<h4 class="col-md-1">状态</h4>
								<div class="col-md-4">
									<select class="form-control select" name="status">
										<!-- <option>初始化</option>
										<option>即将上市</option>
										<option>上架</option>
										<option>下架</option> -->
										<c:forEach items="${goodsStatus}" var="status">
											<option value="${status.code}">${status.label}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-body">
						<div class="col-md-6">
							<h4>商品简介</h4>
							<textarea class="summernote" id="textarea-intro" name="intro"></textarea>
						</div>
						<div class="col-md-6">
							<h4>商品详情</h4>
							<textarea class="summernote" id="textarea-desc" name="description"></textarea>
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
                    <div class="mb-title"><span class="fa fa-times"></span> Danger</div>
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
	<script type="text/javascript" src="<%=basePath%>scripts/admin/goods_edit.js"></script>

</body>
</html>






