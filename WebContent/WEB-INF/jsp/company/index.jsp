<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
#framex {
	height:720px!important;
}
</style>
<html>
    <head>        
        <title>后台管理</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="stylesheet" type="text/css" id="theme" href="<%=basePath%>jslib/atlant/css/theme-default.css">
    </head>
    <body>
        <!-- START 主页面 -->
        <div class="page-container">
            
            <!-- 目录栏 -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="index.html">ATLANT</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="<%=basePath%>jslib/atlant/assets/images/users/avatar.jpg" alt="John Doe"/>
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="<%=basePath%>jslib/atlant/assets/images/users/avatar.jpg" alt="John Doe"/>
                            </div>
                            <div class="profile-data">
                                <div class="profile-data-name">${companyName}</div>
                                <!-- <div class="profile-data-title">Web Developer/Designer</div> -->
                            </div>
                            <!-- <div class="profile-controls">
                                <a href="pages-profile.html" class="profile-control-left"><span class="fa fa-info"></span></a>
                                <a href="pages-messages.html" class="profile-control-right"><span class="fa fa-envelope"></span></a>
                            </div> -->
                        </div>                                                                        
                    </li>
                    <!-- <li class="xn-title">Navigation</li> -->
                    <li class="active">
                        <a href="<%=basePath%>admin/dashboard"><span class="fa fa-desktop"></span> <span class="xn-text">工作台</span></a>                        
                    </li>                    
                    <li class="xn-title">模块管理</li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">销售员管理</span></a>                        
                        <ul>
                        	<%-- <li><a href="<%=basePath%>company/sales_applys" target="framex"><span class="fa fa-magic"></span>销售员申请列表</a></li> --%>
                        	<li><a href="<%=basePath%>company/sales" target="framex"><span class="fa fa-magic"></span>员工列表</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">收入管理</span></a>                        
                        <ul>
                        	<li><a href="<%=basePath%>admin/goods_list" target="framex"><span class="fa fa-magic"></span>佣金收入明细</a></li>
                        </ul>
                    </li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">客户管理</span></a>                        
                        <ul>
                        	<li><a href="ui-icons.html"><span class="fa fa-magic"></span>订单列表</a></li>
                        	<li><a href="ui-icons.html"><span class="fa fa-magic"></span>消费券列表</a></li>
                        </ul>
                    </li>                
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-pencil"></span> <span class="xn-text">Forms</span></a>
                        <ul>
                            <li class="xn-openable">
                                <a href="form-layouts-two-column.html"><span class="fa fa-tasks"></span> Form Layouts</a>                                
                                <ul>
                                    <li><a href="form-layouts-one-column.html"><span class="fa fa-align-justify"></span> One Column</a></li>
                                    <li><a href="form-layouts-two-column.html"><span class="fa fa-th-large"></span> Two Column</a></li>
                                    <li><a href="form-layouts-tabbed.html"><span class="fa fa-table"></span> Tabbed</a></li>
                                    <li><a href="form-layouts-separated.html"><span class="fa fa-th-list"></span> Separated Rows</a></li>
                                </ul> 
                            </li>
                        </ul>
                    </li>

                </ul>
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END 目录栏 -->
            
            <!-- 内容页 -->
            <div class="page-content">
                
                <!-- START 顶部栏 -->
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                    <!-- 目录栏收缩 -->
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>
                    <!-- END 目录栏收缩 -->
                    <!-- 顶栏搜索框 -->
                    <li class="xn-search">
                        <form role="form">
                            <input type="text" name="search" placeholder="Search..."/>
                        </form>
                    </li>   
                    <!-- END 顶栏搜索框 -->                    
                    <!-- 退出登录 -->
                    <li class="xn-icon-button pull-right last">
                        <a href="#"><span class="fa fa-power-off"></span></a>
                        <ul class="xn-drop-left animated zoomIn">
                            <li><a href="pages-lock-screen.html"><span class="fa fa-lock"></span> Lock Screen</a></li>
                            <li><a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span> Sign Out</a></li>
                        </ul>                        
                    </li> 
                    <!-- END 退出登录 -->                    
                    <!-- 消息提醒 -->
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-comments"></span></a>
                        <div class="informer informer-danger">4</div>
                        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                            <div class="panel-heading">
                                <h3 class="panel-title"><span class="fa fa-comments"></span> Messages</h3>                                
                                <div class="pull-right">
                                    <span class="label label-danger">4 new</span>
                                </div>
                            </div>
                            <div class="panel-body list-group list-group-contacts scroll" style="height: 200px;">
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-online"></div>
                                    <img src="<%=basePath%>jslib/atlant/assets/images/users/user2.jpg" class="pull-left" alt="John Doe"/>
                                    <span class="contacts-title">John Doe</span>
                                    <p>Praesent placerat tellus id augue condimentum</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-away"></div>
                                    <img src="<%=basePath%>jslib/atlant/assets/images/users/user.jpg" class="pull-left" alt="Dmitry Ivaniuk"/>
                                    <span class="contacts-title">Dmitry Ivaniuk</span>
                                    <p>Donec risus sapien, sagittis et magna quis</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-away"></div>
                                    <img src="<%=basePath%>jslib/atlant/assets/images/users/user3.jpg" class="pull-left" alt="Nadia Ali"/>
                                    <span class="contacts-title">Nadia Ali</span>
                                    <p>Mauris vel eros ut nunc rhoncus cursus sed</p>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-offline"></div>
                                    <img src="<%=basePath%>jslib/atlant/assets/images/users/user6.jpg" class="pull-left" alt="Darth Vader"/>
                                    <span class="contacts-title">Darth Vader</span>
                                    <p>I want my money back!</p>
                                </a>
                            </div>     
                            <div class="panel-footer text-center">
                                <a href="pages-messages.html">Show all messages</a>
                            </div>                            
                        </div>                        
                    </li>
                    <!-- END 消息提醒 -->
                </ul>
                <!-- END 顶部栏 -->                                       
                              
                <!-- 内容 -->
                <div class="page-content-wrap" style="height:100%;">
					<iframe id="framex" name="framex" src="<%=basePath%>admin/dashboard" frameborder="0" scrolling="none" style="width:100%;height:100%;"></iframe>
				</div>
				<!-- END 内容 -->           
            </div>            
            <!-- 内容页 结束 -->
        </div>
        <!-- END 主页面 -->

        <!-- START 推出登录对话框-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to log out?</p>                    
                        <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END 推出登录对话框-->

		<script type="text/javascript">
			/* function changeFrameHeight() {
				var ifm = document.getElementById("framex");
				ifm.height = document.documentElement.clientHeight;
			}
			window.onresize = function() {
				changeFrameHeight();
			} */
		</script>
		<%-- <script type="text/javascript" src="<%=basePath%>jslib/jquery/jquery-3.2.0.js"></script> --%>              

		<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap.min.js"></script>        
     
     	<script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-select.js"></script>
     
        <script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/icheck/icheck.min.js'></script>        
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/scrolltotop/scrolltopcontrol.js"></script>
        
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/morris/raphael-min.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/morris/morris.min.js"></script>       
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/rickshaw/d3.v3.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/rickshaw/rickshaw.min.js"></script>
        <script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
        <script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>                
        <script type='text/javascript' src='<%=basePath%>jslib/atlant/plugins/bootstrap/bootstrap-datepicker.js'></script>                
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/owl/owl.carousel.min.js"></script>                 
        
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/moment.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins/daterangepicker/daterangepicker.js"></script>

        <%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/settings.js"></script> --%>
        
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/plugins.js"></script>        
        <script type="text/javascript" src="<%=basePath%>jslib/atlant/actions.js"></script>
        
        <%-- <script type="text/javascript" src="<%=basePath%>jslib/atlant/demo_dashboard.js"></script> --%>
   
    </body>
</html>










