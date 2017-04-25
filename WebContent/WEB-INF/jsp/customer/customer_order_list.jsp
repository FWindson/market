<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>styles/order.css" />
<link href="<%=basePath%>styles/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<title>ddddd</title>

    </head>
   <body>
   
<!--筛选导航栏-->
<nav class="ol_select_bar">
    <ul>
        <a href="" class="hover"><li>全部</li></a>
        <a href="" class=""><li>待付款</li></a>
        <a href="" class=""><li>待收货</li></a>
    </ul>
</nav>
<!--订单列表-->
<section class="content_order">
<!--<div class="warnning">-->
	<!--<span class="title">重要提醒：</span>-->
	<!--<span class="word">商城与商家均不会以<i>订单异常、系统升级</i>为由，要求您点击任何链接进行退款！商城提醒您：提高警惕，谨防受骗！</span>-->
<!--</div>-->
<div class="block">
    <div class="order_list">
        <!--非商城自营显示店铺入口-->
            <div class="shop_title">
                <!--合并支付选项-->
                                                <!--店铺名称-->
                <div class="fl">
                    中国美甲商城                </div>

            </div>
                <!--分包商品信息-->
        <a onclick="get_order(12254370245);">
            </a><div class="cart_item prd_ebook" id="ol_12254370245"><a onclick="get_order(12254370245);">
                <!--电子书加签-->
                                <!--包裹图片-->
                <img src="images/22804843-1_h.jpg" class="fl pro_pic">
                <!--包裹详情-->
                <div class="detail">
                    <!--包裹状态-->
                    <div class="fr prd_state">
                        <!--状态文字-->
                        <div class="prd_state_title" id="oltit_12254370245">
                             交易成功                        </div>
                    </div>
                <!--包裹名称显示，多件产品，显示包裹编号，一件产品显示产品名称-->
                                <p class="fl prd_tit">
                                    欧雅菲3色渐变指甲油套装包邮无味水性环保无毒糖果色裸色美甲                </p>
            </div>
    </a>
    <!--数量价格信息-->
    <div class="detail2">

        <span>　总价：</span><span class="order_price">￥94.80</span>
    </div>
    <!--操作按键-->
        <div class="detail3">
                                                 <a onclick="pop_tips(&#39;del&#39;,&#39;12254370245&#39;)">删除订单</a>            </div>
        </div>
    </div>
</div>
<div class="block">
    <div class="order_list">
        <!--非商城自营显示店铺入口-->
            <div class="shop_title">
                <!--合并支付选项-->
                                                <!--店铺名称-->
                <div class="fl">                    
                    美妆旗舰店                </div>
                                  
            </div>
                <!--分包商品信息-->        
        <a onclick="get_order(12041284525);">
            </a><div class="cart_item prd_ebook" id="ol_12041284525"><a onclick="get_order(12041284525);">  
                <!--电子书加签-->
                                <!--包裹图片-->
                <img src="images/23437206-1_h.jpg" class="fl pro_pic">
                <!--包裹详情-->
                <div class="detail">
                    <!--包裹状态-->
                    <div class="fr prd_state">
                        <!--状态文字-->
                        <div class="prd_state_title" id="oltit_12041284525">
                             交易成功                        </div>
                    </div>
                <!--包裹名称显示，多件产品，显示包裹编号，一件产品显示产品名称-->  
                                <p class="fl prd_tit">
                                    TEMIX迷你指甲油 5瓶套装包邮 法国进口原料 专业美甲 西班牙女郎                </p>
            </div> 
    </a>
    <!--数量价格信息-->
    <div class="detail2">

        <span>　总价：</span><span class="order_price">￥41.50</span>
    </div>
    <!--操作按键-->
        <div class="detail3">
                                                 <a onclick="pop_tips(&#39;del&#39;,&#39;12041284525&#39;)">删除订单</a>            </div>
        </div>
    </div>
</div>
<div class="block">
    <div class="order_list">
        <!--非商城自营显示店铺入口-->
            <div class="shop_title">
                <!--合并支付选项-->
                                                <!--店铺名称-->
                <div class="fl">                    
                    西安京都玉指                </div>
                                  
            </div>
                <!--分包商品信息-->        
        <a onclick="get_order(11294057465);">
            </a><div class="cart_item prd_ebook" id="ol_11294057465"><a onclick="get_order(11294057465);">  
                <!--电子书加签-->
                                <!--包裹图片-->
                <img src="images/23219923-1_h.jpg" class="fl pro_pic">
                <!--包裹详情-->
                <div class="detail">
                    <!--包裹状态-->
                    <div class="fr prd_state">
                        <!--状态文字-->
                        <div class="prd_state_title" id="oltit_11294057465">
                             交易成功                        </div>
                    </div>
                <!--包裹名称显示，多件产品，显示包裹编号，一件产品显示产品名称-->  
                                <p class="fl prd_tit">
                                    Candy Moyo Miss裸色糖果色渐变亮片果冻无毒显白美甲指甲油套装              </p>
            </div> 
    </a>
    <!--数量价格信息-->
    <div class="detail2">

        <span>　总价：</span><span class="order_price">￥171.70</span>
    </div>
    <!--操作按键-->
        <div class="detail3">
                                           <a onclick="pop_tips(&#39;del&#39;,&#39;11294057465&#39;)">删除订单</a>            </div>
        </div>
    </div>
</div>




 </section>   
 

   </body>

</html>