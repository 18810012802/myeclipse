<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	Object object=session.getAttribute("org_id");
	if(object==null){
		response.getWriter().write("<script>alert('呵呵~_~');location.href='login.jsp'</script>");
	}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>理博软件信息采编系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
	<script type="text/javascript" src="assets/js/bui.js"></script>
	<script type="text/javascript" src="assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
    <script>
		var iii;
	window.onload=function(){
		var oid=<%=session.getAttribute("org_id")%>;
        var ajax=new XMLHttpRequest();
         ajax.open('post','selectServlet_mc?oid='+oid);
         ajax.send();
         ajax.onreadystatechange=function(){
        	 if(ajax.readyState==4&&ajax.status==200){
        		iii=ajax.responseText;
        		 BUI.use('common/main',function(){
        			 
        		       var config=eval(iii);
        		       console.log(config);
        		        new PageUtil.MainPage({
        		            modulesConfig : config
        		        });
        		    });
        	 }
         }
	
   
	}
	function show(){
		var time=new Date();
		var year=time.getFullYear();//年
		var month=time.getMonth()+1;
		var date=time.getDate();
		var hours=time.getHours();
		if(hours>=1&&hours<12){
			var sey='AM';
		}else if(hours>=12&&hours<24){
			var sey='PM';
		}
		var minite=time.getMinutes();
		if(minite<10){
			minite="0"+minite;	
		}
		var second=time.getSeconds();
		if(second<10){
			second="0"+second;}
		var div=document.getElementById("time");
		div.innerHTML=year+"/"+month+"/"+date+"&nbsp;"+hours+":"+minite+":"+second+"&nbsp;"+sey;
	}
	setInterval("show()",1000);

	
	</script>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${org_name }</span><a href="LoginOutServlet?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    <span id="time"></span>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">信息采编系统</div></li>

		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
</body>
</html>
