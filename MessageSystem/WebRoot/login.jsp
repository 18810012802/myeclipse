<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
   	<title>理博软件信息采编系统</title>
	<meta charset="UTF-8">
	<script src="Js/jquery.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="Css/register.css"/>
<script type="text/javascript">
window.onload=function(){
	var name=document.getElementById("signup_name");
	var img=document.getElementById("admin");
	name.onblur=function(){
		var ajax=new XMLHttpRequest();
		ajax.open("post","imgServlet_mc?name="+name.value);
		ajax.send();
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4&&ajax.status==200){
				var str=ajax.responseText;
				img.src=str;
			}
		}
	}
}
$(function(){

    $('.rem').click(function(){
        $(this).toggleClass('selected');
    });

    $('#signup_select').click(function(){
        $('.form_row ul').show();
        event.cancelBubble = true;
    });

    $('#d').click(function(){
        $('.form_row ul').toggle();
        event.cancelBubble = true;
    });

    $('body').click(function(){
        $('.form_row ul').hide();
    });

    $('.form_row li').click(function(){
        var v  = $(this).text();
        $('#signup_select').val(v);
        $('.form_row ul').hide();
    });

});
<%
	String name="";
	String pwd="";
Cookie [] cookies=request.getCookies();
if(cookies!=null){
for(int i=0;i<cookies.length;i++){
	if(cookies[i].getName().equals("username")){
		name=cookies[i].getValue();
	}
	if(cookies[i].getName().equals("userpwd")){
		pwd=cookies[i].getValue();
	}
}
}
%>
</script>
<script type="text/javascript">
	function login(){
		document.getElementById("hid").value=document.getElementById("liu").className;
		document.getElementById("signup_form").submit();
	}
</script>
  </head>
  
  <body>
    <div class='signup_container'>
	
    <h1 class='signup_title'>用户登陆</h1>
    <img src='images/people.png' width="200px" higth="200px" id='admin'/>
    <div id="signup_forms" class="signup_forms clearfix">
            <form class="signup_form_form" id="signup_form" method="post" action="loginServlet_mc">
            	<input type="hidden" id="hid" value="0" name="hid" />
                    <div class="form_row first_row">
                        <label for="signup_email">请输入用户名</label><div class='tip ok'></div>
                        <input type="text" name="user_name" placeholder="请输入用户名" id="signup_name" value="<%=name %>" data-required="required">
                    </div>
                    <div class="form_row">
                        <label for="signup_password">请输入密码</label><div class='tip error'></div>
                        <input type="password" name="user_pwd" placeholder="请输入密码" value="<%=pwd %>" id="signup_password"  data-required="required">
                    </div>
           </form>
    </div>

    <div class="login-btn-set"><div class='rem selected' id='liu'>记住我</div> <a href='javascript:void(0)' onclick="login()" class='login-btn'></a></div>
    <p class='copyright'>版权所有 北京理博软件科技有限公司</p>
</div>
  </body>
</html>
