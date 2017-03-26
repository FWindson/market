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
		<li class="active">添加产品</li>
	</ul>
	<!-- END 当前路径 -->
	<div class="col-md-8">
		<div class="page-title">
			<h2>添加产品</h2>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form" id="form-product">
					<div class="form-group">
						<h4 class="col-md-1 control-label">产品名</h4>
						<div class="col-md-5">
							<input type="text" class="form-control" name="name">
						</div>
					</div>
					<div class="form-group">
						<h4 class="col-md-1 control-label">价格</h4>
						<div class="col-md-5">
							<input type="number" class="form-control" name="price">
						</div>
					</div>
					<div class="form-group">
						<h4 class="col-md-1 control-label">属性</h4>
						<div class="col-md-5">
							<select class="form-control select" name="nature">
								<!-- <option>服务</option>
								<option>实体</option> -->
								<c:forEach items="${productNature}" var="nature">
									<option value="${nature.code}">${nature.label}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<h4 class="col-md-1 control-label">库存</h4>
						<div class="col-md-5">
							<input type="number" class="form-control" name="stock">
						</div>
						<p class="form-control-static">提示：不填代表库存无限</p>
					</div>
				</form>
			</div>
			<div class="panel-footer">
				<button class="btn btn-primary btn-lg pull-right" id="btn-submit">
					保存 <span class="fa fa-floppy-o fa-right"></span>
				</button>
			</div>
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
	<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>  --%>

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

	<script type="text/javascript" src="<%=basePath%>jslib/jquery.serializejson/jquery.serializejson.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/admin/product_add.js"></script>

	<%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/demo_dashboard.js"></script> --%>

</body>
</html>






