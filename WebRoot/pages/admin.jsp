<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
<%
User userlogin=(User)(session.getAttribute("user"));
if (userlogin==null){
response.sendRedirect("login.jsp");
return;
}
else{

}
%>

		<base href="<%=basePath%>">
	  	<title>botwall管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="botwall管理">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		
		
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/carousel.css">
		<link rel="stylesheet" href="css/docs-5892f62386325d472ddefdaec9d29018.css"> 
		<link rel="stylesheet" type="text/css" media="screen" href="css/tabs.css" />
		<link rel="stylesheet" href="css/docs-5892f62386325d472ddefdaec9d29018.css"> 
		<link href="Flat-UI-master/css/flat-ui.css" rel="stylesheet">
    	<link rel="Flat-UI-master/shortcut icon" href="images/favicon.ico">
		<!-- <link href="Flat-UI-master/bootstrap/css/bootstrap.css" rel="stylesheet"> -->
		<link rel="stylesheet" type="text/css" media="screen" href="js/jqueryUI/css/jquery-ui-1.10.3.custom.css" />
	
		<link rel="stylesheet" type="text/css" media="screen" href="js/jqGrid/css/ui.jqgrid.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="js/jqueryUI/themes/redmond/jquery.ui.theme.css" />
		 
		<script src="js/jquery/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="js/jquery/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="js/jquery-validation-1.11.1/dist/jquery.validate.js"></script>
		
		<script src="bootstrap/js/bootstrap.js"></script>
		<script src="bootstrap/js/holder.min.js"></script>
		<script src="js/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
		<script src="js/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
	
		<script src="js/easytabs/jquery.hashchange.min.js" type="text/javascript"></script>
		<script src="js/easytabs/jquery.ba-hashchange.js" type="text/javascript"></script>
		<script src="js/easytabs/jquery.easing.1.3.js" type="text/javascript"></script>
		
		<script src="js/easytabs/jquery.easytabs.js" type="text/javascript"></script>
		<script src="js/easytabs/jquery.raptorize.1.0.js" type="text/javascript"></script>
		

	    <script src="Flat-UI-master/js/jquery-ui-1.10.3.custom.min.js"></script>
	    <script src="Flat-UI-master/js/jquery.ui.touch-punch.min.js"></script>
	    <script src="Flat-UI-master/js/bootstrap-select.js"></script>
	    <script src="Flat-UI-master/js/bootstrap-switch.js"></script>
	    <script src="Flat-UI-master/js/flatui-checkbox.js"></script>
	    <script src="Flat-UI-master/js/flatui-radio.js"></script>
	    <script src="Flat-UI-master/js/jquery.tagsinput.js"></script>
	    <script src="Flat-UI-master/js/jquery.placeholder.js"></script>
	    <script type="text/javascript" src="js/admin.js"></script>
	    
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
 
  <!-- <script type="text/javascript" src="//use.typekit.net/lnw7qyq.js"></script>-->
  <script type="text/javascript">try{Typekit.load();}catch(e){}</script>
	<style>
	 body{
	 font-family:'微软雅黑'
	 } 
	 label{
	 font-size:14px;
	 }
	 h2{
		font-size:20px;
		font-family:'微软雅黑'
	 }
	 table.gridtable {
		font-family: verdana,arial,sans-serif;
		font-size:14px;
		color:#333333;
		border-width: 1px;
		border-color: #666666;
		border-collapse: collapse;
		width:80%
	}
/* 	table.gridtable th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #dedede;
	} */
	table.gridtable td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #ffffff;
	}
	.span3{
		margin-left:12px
	}
	</style>

</head>

  <body style="background-image:url(images/background.jpg);background-repeat:repeat-y ">
    <nav class="navbar" role="navigation">
	  <div class="container" style="background-image:url(images/background.jpg);">
	    <div class="row">	  
	      <div class="collapse navbar-collapse">
	      	<div>
	      	<ul style="margin-top:10px;margin-bottom:-80px;float:left">
	      		<img style="width:40%;margin-left:-100px;" alt="BotWall 管理系统" src="images/eagleeye-dark.png">
	      	 	<h4 style="color:#eee">BotWall管理系统</h4>
	      	</ul>
	        <ul class="nav navbar-nav navbar-right" style="margin-top:10px;margin-right:15px;float:left">
	          <li class="active" style="color:#eee;font-size:15px;">	 
	          	产品名称：BotWall专用网关</br>
	          	产品型号：BW-DFM-0001</br>
	          	版本号：Version 1.0	
	          </li>
	        </ul>
	        </div>
	      </div>
	    </div>
	</div>
	</nav>

    <div class="container content" style="margin-top:-30px;">
      <div class="row">
		  <div class="col-md-3 secondary-nav collapse navbar-collapse">
		    <div class="list-group docs-nav">
		      <h3 class="list-group-heading" style="color:white;font-style:bold;font-size:20px;font-family:微软雅黑">配置导航</h3>
		      
		      
		      <div id="tab-side-container" style="width:450%;height:130%;">
				 <ul style="background:#F1EAEA;height:auto">
				  <li style="width:200px;"><a href="#side-tab8">管理员配置</a></li>
				  <li style="width:200px;"><a href="#side-tab6">网络配置</a></li>
				  <li style="width:200px;"><a href="#side-tab7">白名单配置</a></li>
				  <li style="width:200px;"><a href="#side-tab2">蜜罐主机配置</a></li>
				  <li style="width:200px;"><a href="#side-tab0">控制主机配置</a></li> 
				  <li style="width:200px;"><a href="#side-tab3">数据库配置</a></li>
				  <li style="width:200px;"><a href="#side-tab1">License配置</a></li>
				  <li style="width:200px;"><a href="#side-tab4">FTP服务器配置</a></li>
				  <li style="width:200px;"><a href="#side-tab9">BotWall功能管理</a></li>
				  
				  <!--<li style="width:200px;"><a href="#side-tab5">协同行为分析参数配置</a></li> -->
				 </ul>
				    <div style="position:absolute;top:650px;">
					   <div class="span3" style="width:200px;margin-left:5px;" >
				          <a href=" javascript:void(0)" onclick="reloadAllConfig();" class="btn btn-large btn-block btn-primary">配置生效</a>
				        </div>
				        <div class="span3" style="width:200px;margin-top:10px;margin-left:5px;">
				          <a href="javascript:void(0)" onclick="logout()" class="btn btn-large btn-block btn-danger">退出系统登录</a>
				        </div>
			        </div>
				 <div class="panel-container"  >
				   <div id="side-tab8" style="margin-left:120px;">
			       <h2>管理员配置</h2>
				   <div>
				   		<div>	
							<!-- <input type="button" style="float:right" class="button" name="commit" value="添加管理员" onclick="$('#register_modal').modal()"/>	 -->
						</div>     
			     	 	<table id="UserList" class="table table-striped table-bordered table-hover datatable " ></table>
			      		<div style="border:3px dashed #336699;box-shadow:2px 2px 10px #333300;border-radius: 11px;width:800" >
			      			<div id="UserPager" ></div>
			      		</div>		  
			        </div>
				  </div>
				  <div id="side-tab1" style="margin-left:120px;">
			       <h2>License管理</h2>
				   <div>
				       <form id="updateLicenseForm" action="updateLicense.action" method="post"> 
				     	 	<table cellpadding="0" cellspacing="0" class="gridtable">	
				      			<tr>
				      				<td style="width:20%"><label>上传序列号：</label></td>
				      				<td align="center"><input id=licenseStr type="text"  class="span3" style="width:200px"  name="licenseStr" />
				      				<input name = licenseID id=licenseID TYPE="hidden">
				      				<em style="color:red">*</em></td>
				      			</tr>	
				      			<tr>
				      				<td style="width:20%"><label>到期时间：</label></td>
				      				<td align="center"><input  disabled=true id=licenseDate class="span3" style="width:200px"  name="licenseDate"/></td>
				      			</tr>	
				      			<tr>
				      				<td style="width:20%"><label>状态：</label></td>
				      				<td align="center"><input  disabled=true id=isvalid class="span3" style="width:200px"  name="isvalid"/></td>
				      			</tr>	      					      		
							</table>
						    <div class="modal-footer">
						        <button type="submit" class="btn btn-primary"  >保存</button>
						    </div>
					   </form> 
			        </div>
				 </div>
				 <div id="side-tab6" style="margin-left:120px;">
				 <div class="modal fade" id="loading" style="margin-top:200px;"> <div class="modal-dialog" >
		    		<div class="modal-content">网络配置以及重启需要一定时间，请耐心等待！</div></div></div>
				
				   <h2>网络配置</h2>
					<form id="updateNetConfForm" name="updateNetConfForm" action="updateNetConf.action" method="post">				
		     	 	<table cellpadding="0" cellspacing="0" class="gridtable" >		      		
		      			<tr>
		      				<td><label >管理IP：</label></td>
				            <td><div class=all_input>						  
						    <input name=netip1 id="netip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
						    name=netip2 id="netip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
						    name=netip3 id="netip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
						    name=netip4 id="netip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(ip3,ip4)>						
						  </div><label></label><input name = netipvalue id="netipvalue" TYPE="hidden"><input name = netID id=netID TYPE="hidden"></td>
		      			</tr>
	      				<tr>
		      				<td><label >管理掩码：</label></td>
				            <td><div class=all_input>						  
						    <input name=maskip1 id="maskip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
						    name=maskip2 id="maskip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
						    name=maskip3 id="maskip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
						    name=maskip4 id="maskip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(ip3,ip4)>						
						  </div><label></label><input name = maskipvalue id="maskipvalue" TYPE="hidden"></td>
		      			</tr>
		      			<tr>
		      				<td><label >默认网关：</label></td>
				            <td>
				            <div class=all_input>						  
						    <input name=gateip1 id="gateip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
						    name=gateip2 id="gateip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
						    name=gateip3 id="gateip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
						    name=gateip4 id="gateip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(ip3,ip4)>						
						  </div><label></label>
						  <input name = gateipvalue id="gateipvalue" TYPE="hidden"></td>
		      			</tr>
		      			<tr>
		      				<td><label >DNS服务器：</label></td>
				            <td><div class=all_input>						  
						    <input name=dns1ip1 id="dns1ip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(dns1ip1,dns1ip1,dns1ip2)>.<input
						    name=dns1ip2 id="dns1ip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(dns1ip1,dns1ip2,dns1ip3)>.<input
						    name=dns1ip3 id="dns1ip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(dns1ip2,dns1ip3,dns1ip4)>.<input
						    name=dns1ip4 id="dns1ip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(dns1ip3,dns1ip4)>						
						  </div><label></label><input name = dns1ipvalue id="dns1ipvalue" TYPE="hidden">
						  <div class=all_input>						  
						    <input name=dns2ip1 id="dns2ip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(dns2ip1,dns2ip1,dns2ip2)>.<input
						    name=dns2ip2 id="dns2ip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(dns2ip1,dns2ip2,dns2ip3)>.<input
						    name=dns2ip3 id="dns2ip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(dns2ip2,dns2ip3,dns2ip4)>.<input
						    name=dns2ip4 id="dns2ip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(dns2ip3,dns2ip4)>						
						  </div><label></label><input name = dns2ipvalue id="dns2ipvalue" TYPE="hidden">
						  </td>
		      			</tr>
					   </table>
					   <div class="modal-footer">
					        <button id="netsubmit" name="netsubmit" type="submit" class="btn btn-primary" >保存</button>
					   </div>
				   </form>  
				  </div>
				  <div id="side-tab7" style="margin-left:120px;">
					<h2>白名单管理</h2>
					
								<div  id="panel-1" style="margin-bottom:50px;">		
									<table id="WhiteIpList" class="table table-striped table-bordered table-hover datatable " ></table>
						      		<div style="border:3px dashed #336699;box-shadow:2px 2px 10px #333300;border-radius: 11px;width:800" >
						      			<div id="WhiteIpPager" ></div>
						      		</div>	       		
								</div>
							
								<div id="panel-2">							
						      		<table id="WhiteDomainList" class="table table-striped table-bordered table-hover datatable " ></table>
						      		<div style="border:3px dashed #336699;box-shadow:2px 2px 10px #333300;border-radius: 11px;width:800" >
						      			<div id="WhiteDomainPager" ></div>
						      		</div>	      		
								</div>								 		
					
				  </div>
				  <div id="side-tab2" style="margin-left:120px;">
					<h2>蜜罐管理</h2>
					<table id="HoneyHostList" class="table table-striped table-bordered table-hover datatable " ></table>
		      		<div style="border:3px dashed #336699;box-shadow:2px 2px 10px #333300;border-radius: 11px;width:800" >
		      			<div id="HoneyHostPager" ></div>
		      		</div>	      		
					
				  </div>
				  <div id="side-tab0" style="margin-left:120px;">
					<h2>控制主机管理</h2>
					<table id="ControlIpList" class="table table-striped table-bordered table-hover datatable " ></table>
		      		<div style="border:3px dashed #336699;box-shadow:2px 2px 10px #333300;border-radius: 11px;width:800" >
		      			<div id="ControlIpPager" ></div>
		      		</div>	      						
				  </div> 
				  <div id="side-tab3" style="margin-left:100px;">
				   <h2>数据库配置</h2>
				   <form id="updateDBForm" action="updateDB.action" method="post"> 
		     	 	<table cellpadding="0" cellspacing="0" class="gridtable">
		      		
		      			<tr>
		      				<td><label >IP地址：</label></td>
				            <td><div class=all_input>						  
						    <input name=ip1 id="ip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
						    name=ip2 id="ip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
						    name=ip3 id="ip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
						    name=ip4 id="ip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(ip3,ip4)>						
						  </div><label></label><input name = ipvalue id="ipvalue" TYPE="hidden"><input name = dbID id=dbID TYPE="hidden"></td>
		      			</tr>
		      			<tr>
		      				<td><label>端口：</label></td>
		      				<td><input id=dbport type="text"  class="span3"style="width:100px"  name="dbport" /><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label >数据库名：</label></td>
		      				<td><input id="dbname" type="text" class="span3" style="width:100px" name="dbname" /><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td style="width:20%"><label >用户名：</label></td>
		      				<td><input id="dbuser" type="text" class="span3" style="width:100px" name="dbuser" /><em style="color:red">*</em></td>
		      			</tr>	
		      			<tr>
		      				<td><label>密码：</label></td>
		      				<td><input id="dbpasswd" type="password" class="span3" style="width:100px" name="dbpasswd"  /><em style="color:red">*</em></td>
		      			</tr>			      		
					   </table>
					   <div class="modal-footer">
					        <button type="submit" class="btn btn-primary"  >保存</button>
					   </div>
				   </form> 
				  </div>
				  
				  <div id="side-tab9" style="margin-left:120px;">
				  	<%@ include file="function.jsp" %>
				  	
				  </div>
			 	  <div id="side-tab4" style="margin-left:120px;">
				   <h2>FTP服务器配置</h2>
				   <form id="updateFTPForm" action="updateFTP.action" method="post"> 
		     	 	<table cellpadding="0" cellspacing="0" class="gridtable">
		      		
		      			<tr>
		      				<td><label >IP地址：</label></td>
				            <td><div class=all_input>						  
						    <input name=ftpip1 id="ftpip1" class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ftpip1,ftpip1,ftpip2)>.<input
						    name=ftpip2 id="ftpip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(ftpip1,ftpip2,ftpip3)>.<input
						    name=ftpip3 id="ftpip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(ftpip2,ftpip3,ftpip4)>.<input
						    name=ftpip4 id="ftpip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(ftpip3,ftpip4)>						
						  </div><input name = ftpipvalue id="ftpipvalue" TYPE="hidden"><input name = ftpID id=ftpID TYPE="hidden"></td>
		      			</tr>
		      			<tr>
		      				<td><label>端口：</label></td>
		      				<td><input id=ftpport type="text"  class="span3"style="width:100px"  name="ftpport" maxlength="10"/><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td style="width:20%"><label >用户名：</label></td>
		      				<td><input id="ftpuser" type="text" class="span3" style="width:100px" name="ftpuser" maxlength="30" /><em style="color:red">*</em></td>
		      			</tr>	
		      			<tr>
		      				<td><label >密码：</label></td>
		      				<td><input id="ftppasswd" type="password" class="span3" style="width:100px" name="ftppasswd" maxlength="30" /><em style="color:red">*</em></td>
		      			</tr>			      		
					   </table>
					   <div class="modal-footer">
					        <button type="submit" class="btn btn-primary"  >保存</button>
					   </div>
				   </form>
				  </div> 
				  
			<!-- 	  <div id="side-tab5" style="margin-left:120px;">
				   <h2>协同行为分析参数配置</h2 >
				    <form id="updateClusterForm" action="updateClusterParameter.action" method="post"> 
		     	 	<table cellpadding="0" cellspacing="0" class="gridtable">
		      			<tr>
		      				<td style="width:20%"><label>聚类窗口：</label></td>
		      				<td><input id=interval type="text"  class="span3" style="width:100px"  name="dbport" />
		      				<input name = clusterID id=clusterID TYPE="hidden">
		      				<em style="color:red">*</em></td>
		      			</tr>		      					      		
					   </table>
					   <div class="modal-footer">
					        <button type="submit" class="btn btn-primary"  >保存</button>
					   </div>
				   </form> 
				  </div> -->
				 </div>
			</div>
			
			
		     
		    </div>
		  </div>
	
		</div>
    </div>
  <!--   <footer style="margin-top:500px;color: #999999;padding: 40px;text-align: center;color:white;background-color:rgba(149, 187, 224, 0.33)">
  		<span id="copyright">&copy; 2014 </span> 
	</footer> -->

		
			<!-- 添加IP白名单的模态框 -->   	
		<div class="modal fade" id="add_whiteip_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加IP白名单</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addWhiteIpForm">					 
					  <table width="100%" cellpadding="0" cellspacing="0" class="post_table">		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >IP：</label></td>
				            <td>
				            <div class=all_input>						  
						    <input id="whiteip1" name=whiteip1 class=ip_input maxlength=3
							onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(whiteip1,whiteip1,whiteip2)>.<input
							     id="whiteip2" name=whiteip2 class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
							onkeyup=keyUpEvent(whiteip1,whiteip2,whiteip3)>.<input
							    id="whiteip3" name=whiteip3 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEvent(whiteip2,whiteip3,whiteip4)>.<input
							    id="whiteip4" name=whiteip4 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEventForIp4(whiteip3,whiteip4)>
						    <input name = whiteipvalue TYPE="hidden">						
						  	</div><label></label>
				            <em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >备注：</label></td>
		      				<td><input id="whiteipremark" type="text" class="input2" name="whiteipremark"/></td>
		      			</tr>
		      		<!-- 	<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;">是否运行：</label></td>
		      				<td><input id="ifrunning" type="text" class="input2" style="width:100px" name="ifrunning" maxlength="30" /></td>
		      			</tr> -->
		      						      		
					   </table>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<!-- 添加域名白名单的模态框 -->   	
		<div class="modal fade" id="add_whitedomain_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加域名白名单</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addWhiteDomainForm">					 
					  <table width="100%" cellpadding="0" cellspacing="0" class="post_table">		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >域名：</label></td>
				         	<td><input id="whitedomain" type="text" class="input2" name="whitedomain" /><em style="color:red">*</em></td>		      		
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >备注：</label></td>
		      				<td><input id="whitedomainremark" type="text" class="input2" name="whitedomainremark"/></td>
		      			</tr>		      			      						      		
					   </table>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
			<!-- 添加蜜罐的模态框 -->   	
		<div class="modal fade" id="add_pot_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加蜜罐</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addPotForm">
						  <div class=all_input>						  
						    <input id="potip1" name=potip1 class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(potip1,potip1,potip2)>.<input
						    id="potip2" name=potip2 class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(potip1,potip2,potip3)>.<input
						    id="potip3" name=potip3 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(potip2,potip3,potip4)>.<input
						    id="potip4" name=potip4 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(potip3,potip4)>
						    <input id="potipvalue" name = potipvalue TYPE="hidden">
						
						  </div>
						  <label></label>
<!-- 						<div class="span3 " style="width:150px;margin-top:10px;"> -->
<!-- 						  	 <INPUT class="btn btn-large btn-block btn-primary" TYPE="button" value = "添加" onmouseup=getipvalue(ip1,ip2,ip3,ip4,ipvalue)> -->
<!-- 					    </div> -->
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
				<!-- 	   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" onmouseup=getipvalue(ip1,ip2,ip3,ip4,ipvalue) >保存</button>
					   </div> -->
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
			<!-- 添加控制主机的模态框 -->   	
		<div class="modal fade" id="add_controlip_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加控制主机</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addControlIpForm">					 
					  <table width="100%" cellpadding="0" cellspacing="0" class="post_table">		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >IP：</label></td>
				            <td>
				            <div class=all_input>						  
						    <input id="controlip1" name=controlip1 class=ip_input maxlength=3
							onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(controlip1,controlip1,controlip2)>.<input
							     id="controlip2" name=controlip2 class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
							onkeyup=keyUpEvent(controlip1,controlip2,controlip3)>.<input
							    id="controlip3" name=controlip3 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEvent(controlip2,controlip3,controlip4)>.<input
							    id="controlip4" name=controlip4 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEventForIp4(controlip3,controlip4)>
						    <input name = controlipvalue TYPE="hidden">						
						  	</div><label></label>
				            <em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >备注：</label></td>
		      				<td><input id="controlipremark" type="text" class="input2" name="controlipremark"/></td>
		      			</tr>			      		
					   </table>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		
		<!-- 注册模态框 -->   	
		<div class="modal fade" id="register_modal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" style="font-weight:bold;font-family:幼圆">添加用户</h4>
		      </div>
		      <div class="modal-body">
		     	 <form id="registerForm" action="register.action" method="post" style="margin-top:-10px;"> 
		     	 	<table width="100%" cellpadding="0" cellspacing="0" class="post_table" >
		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >用户名：</label></td>
				            <td><input id="username" type="text" class="input2" name="username"/><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >密码：</label></td>
		      				<td><input id="reg_password" type="password" class="input2" name="reg_password" /><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >密码确认：</label></td>
		      				<td><input id="conpassword" type="password" class="input2" name="conpassword"/><em style="color:red">*</em></td>
		      			</tr>
		      			<!--
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;">角色：</label></td>
		      				<td>
      							<select id="role" name="role">		                  
			                	</select>
		      					<em style="color:red">*</em>
		      				</td>
		      			</tr> 
		      			 -->		    				
				   </table>
				   <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-primary"  >提交</button>
				   </div>
				 </form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		
  </body>
  
	<style type="text/css">
		.ip_input  { width:30px; height:22px;
		font:normal 12px 宋体; color:#000000; border:0px; text-align:center; position:relative; top:1px; }
		.all_input  { width:150; height:27px;
		font:normal 8px 宋体; color:#000000; border:1px solid #000000; text-align:center; }
	</style>
	
	<script language=javascript>
		$(document).ready(function(){
		    $('#add_whitedomain_modal').on('hide.bs.modal', function () {
		       $(this).removeData("bs.modal");
		       // $("#add_whitedomain_modal").removeData("bs.modal");
		        //$("#whitedomain").removeData();
		       // $(this).empty();
		    })
		});
		$("footer").css({
			"margin-top":200
		});
		$(".gridtable td:first-child").css({
			'background-color':'#F5FFFA',			
		});
	
		$('.modal-dialog').css({
			
			 'margin-top': function () {
			            return ($(window).height()-700)/2;
			        },
			 'margin-right':function () {
			            return ($(window).width()-300 );
			        },
		});
		
		$('#tab-side-container').easytabs({
		  animate: false,
		  tabActiveClass: "selected-tab",
		  panelActiveClass: "displayed"
		});
		
		function logout(){
			if (window.confirm("您真的确定要退出吗? 请确认！")) {
				$.ajax({
					url:'logout.action',
					type:'post',
					dataType:'json',
					success:function(data){		
						if(data.flag=="true"){				
							window.location.reload();
						}else{
							alert("登出失败！");
						}
					}
				});
		
			} else {
				//window.location.reload();
			}
				
		}

		function reloadAllConfig(){
			if (window.confirm("您真的确定要重启配置吗? 请确认！")) {
				$.ajax({
					type:"post",
					url:"reloadAllConfig.action",
					dataType:"json",
					success : function(data) {
						if(data.re=="success"){
							alert("配置已生效！");
						}else{
							alert("配置失败！");
						}
						
					}
				});
			}else{
			}
		}
	
			function getPos(obj)
		{
			obj.focus();
			var workRange=document.selection.createRange();
			obj.select();
			var allRange=document.selection.createRange();
			workRange.setEndPoint("StartToStart",allRange);
			var len=workRange.text.length;
			workRange.collapse(false);
			workRange.select();
			return len;
		}
		
		
		function setCursor(obj,num)
		{
			range=obj.createTextRange();
			range.collapse(true);
			range.moveStart('character',num);
			range.select();
		}
		
		function keyDownEvent(obj)
		{
		    code=event.keyCode;
		    if(!((code>=48&&code<=57)||(code>=96&&code<=105)||code==190||code==110||
		code==13||code==9||code==39||code==8||code==46||code==99||code==37))
		        event.returnValue=false;
		    if(code==13)
		        event.keyCode=9;
		    if(code==110||code==190)
		        if(obj.value)
		            event.keyCode=9;
		        else
		            event.returnValue=false;
		}
		
		function keyUpEvent(obj0,obj1,obj2)
		{
		    if (obj1.value > 255)
		    {
		        alert("填写范围必须在 0 - 255间");
		        obj1.value = obj1.value.substring(0, obj1.value.length - 1);
		        return;
		    }
		    code=event.keyCode
		
		    if(obj1.value.length>=3&&code!=37&&code!=
		39&&code!=16&&code!=9&&code!=13)
		        obj2.focus();
		
		    if(code == 32)
		        obj2.focus();
		
		    if(code == 8 && obj1.value.length == 0)
		    {
		        obj0.focus();
		        setCursor(obj0,obj0.value.length);
		    }
		
		    if (code == 37 && (getPos(obj1) == 0))
		    {
		        obj0.focus();
		        setCursor(obj0,obj0.value.length);ilzsy
		        
		    }
		    if (code == 39 && (getPos(obj1) == obj1.value.length))
		    {
		        obj2.focus();
		    }
		}
		function keyUpEventForIp4(obj0,obj)
		{
		    if (obj.value > 255)
		    {
		        alert("填写范围必须在 0 - 255间");
		        obj.value = obj.value.substring(0, obj.value.length - 1);
		        return;
		    }
		    if(code == 8 && obj.value.length == 0)
		    {
		        obj0.focus();
		        setCursor(obj0,obj0.value.length);
		    }
		    if (code == 37 && (getPos(obj) == 0))
		    {
		        obj0.focus();
		        setCursor(obj0,obj0.value.length);
		    }
		
		}
		function getipvalue(obj1,obj2,obj3,obj4,obj)
		{
		  obj.value = obj1.value + "." + obj2.value + "."
		+ obj3.value + "." + obj4.value;		    
		    $.ajax({
				type : 'POST',
				url : 'addHoneyPot.action',
				data : {
					ip:obj.value
				},
				dataType:'json',
				success : function(msg) {
					alert("添加成功！");
					$('#add_pot_modal').modal('hide');
					$("#HoneyHostList").trigger("reloadGrid");
				},
				error:function(msg){
					alter(msg);
					$('#add_pot_modal').modal('hide');
					$("#HoneyHostList").trigger("reloadGrid");
				}
			});
		
		}
		/*注册用户
		*/
		$("#conpassword").blur(function() {
	       var reg_password = $("#reg_password").val();
	       if (reg_password != $("#conpassword").val()) {
	           alert("确认密码与密码不一致.");
	           return;
	       } else {
	           //$(this).next("span").html(img_rigth);
	       }
   	 	});
   	 	
		$("#registerForm").validate({
			debug:true,
			onsubmit:true,
			onfocusout:false,
			onkeyup:true,
			rules:{
				username:{
					required:true
				},
				reg_password:{
					required:true
				},
				conpassword:{
					required:true
				}	
			},
			messages:{
				username:{
					required:"用户名不能为空！",
				},
				reg_password:{
					required:"密码不能为空！"
				},
				conpassword:{
					required:"请输入确认密码！"
				}
			},
			submitHandler:function(){
				
				register();
			}
		});
			
	function register(){
		//confirmPassword();
		$.ajax({
			type : 'POST',
			url : 'register.action',
			data : {
				username:$("#username").val(),
				//email:$("#email").val(),
				regpassword:$("#reg_password").val(),
				conpassword:$("#conpassword").val()
			},
			dataType:'json',
			success : function(data) {
				if(data.success==true){
					alert("添加用户成功！");
					window.location.reload();
					//location.href="pages/data.jsp";
				}else{
					alert("添加用户失败！"+data.errorMessage);
					//$('#register_modal').modal('hide');
				}
			},
			error:function(msg){
				alert("通信失败！");
				//$('#register_modal').modal('hide');				
			}
		});
	}
	
	function confirmPassword(){
       var reg_password = $("#reg_password").val();
       if (reg_password != $(this).val()) {
           alert("确认密码与密码不一致.");
           return;
       } else {
	           //$(this).next("span").html(img_rigth);
       }
	}
		

	</script>
	
</html>

	