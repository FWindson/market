<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>styles/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>styles/product.css" />
<link href="<%=basePath%>styles/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<title>Insert title here</title>
</head>
<body>
	<div id="bigpic">
		<div id="cell">
			<section class="turn"> <section id="slider">
			<ul class="top-slider" style="width: 200%; -webkit-transition: 0ms cubic-bezier(0.1, 0.57, 0.1, 1); transition: 0ms cubic-bezier(0.1, 0.57, 0.1, 1); -webkit-transform: translate(0px, 0px) translateZ(0px);">
				<li style="width: 50%"><a> <img
						<img src="<%=basePath%>${path}">
                </a>
      </li>

        </ul>
    <div class="dot">
    <ul>
                   <li class="on"></li>
                     <li class=""></li>
                   </ul>
    </div>
  </section>
</section>
</div>
</div>
<section class="detail">
	<div class="left">
		<b>￥<span id="main_price">${price}</span></b>
		<aside>
						
			                        					</aside>
	</div>
	<div class="right">
		<ul>
						<li class="fav"><a>收藏</a></li>
		</ul>
	</div>
	<article>${descirption}</article>
								<p></p>
</section>
<section class="promotion">
	<a href="javascript:void(0)" class="arrow_con">
		<div class="label">
		    <div class="table">
		       <div class="cell">
		                </div>
			        </div>
				</div>
			<div class="info">
				<p>满￥99.00减￥20.00,满￥199.00减￥60.00</p>
			</div>
	</a>
</section>
<section class="detail book_detail">
	<a href="#"><div class="title"><div class="right"><span class="icon"></span></div>商品简介</div></a>
	<p><span>产&nbsp;&nbsp;&nbsp;&nbsp;品：</span>${descirption}</p>
	<p><span>净含量：</span>备注</p>
	<p><span>上市时间：</span>2013-06-18</p>
</section>

<!-- 配送结束 -->
<!-- 选项开始 -->
<!-- 数量开始 -->
<form action="<%=basePath%>store/orderConfirm">
	<section class="quantity">
		<h4>数量：</h4>
		<input type="button" value="-" onclick="decOne()" />
	    <input type="text" id="num" name="count" value="1" />
		<input type="button" value="+" onclick="addOne()" />
	</section>    
	<section class="quantity">
		<h4>总金額：</h4>
	  	<input type="text" id="sumPrice"  name="sumPrice" value="${price}" />
	</section> 
     <input id="price" type="hidden"  name="price" value="${price}" />
	<input id="input-companyId" type="hidden"  name="companyId" value="${companyId}" />
	<input id="input-salsId" type="hidden" name="salesId" value="${salesId}" />
	<input id="input-goodsId" type="hidden" name="goodsId" value="${id}" />
	<section class="quantity">
		<h4>折扣码：</h4>
	  	<input type="text" id="discountCode"  name="discountCode" value="" />
	  	 <input type="hidden"  id="discount"  name="discount" value="" />
	</section> 
	<section class="shopping_cart">
		<div class="btn_con">
	   <input type="submit" class="btn btn-info btn-block" id="btn-buyGoods" value="立即购买">
		</div>
	</section>
</form>   
   
   
<%-- <div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
			  <ul class="slides">
			  </br>	
			   <!--  <li data-thumb="images/si.jpg"> -->
			        <div class="thumb-image"> <img src="<%=basePath%>${path}" data-imagezoom="true" class="img-responsive"> </div>
			 <!--    </li> -->
		
			  </ul>
		</div>
	</div>	
<div class="col-md-7 single-top-in">
						<div class="single-para simpleCart_shelfItem">
							<h1>${name}</h1>
							<p>${descirption}</p>											
								<label  class="add-to item_price">${price}</label>
							<div class="clearfix"> </div>				
								<a href="<%=basePath%>store/orderConfirm?id=${id}" class="cart item_add">立即购买</a>
						</div>
					</div>
			<div class="clearfix"> </div>
</div> --%>
		<script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script>
	<script type="text/javascript" src="<%=basePath%>scripts/global/config.js"></script>
	<script type='text/javascript' src="<%=basePath%>jslib/atlant/plugins/noty/jquery.noty.js"></script>
<script type="text/javascript"
		src="<%=basePath%>scripts/store/goodsDetail.js"></script> 

</body>
</html>