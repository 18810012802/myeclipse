<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="Org_EmployeeServlet_fan";
		 });
    });
		var username=null;
		var save=null;
		var password=null;
		var realname=null;
		var email=null;
		var tel=null;
		var idcard=null;
		
		var usernames=null;
		var passwords= null;
		var realnames = null;
	    var emails = null;
		var tels = null;
		var idcards = null;
		//登录名正则表达式
		var zeuser=/^[a-zA-Z][0-9a-zA-Z_]{4,22}$/;
		//密码正则表达式
	    var zepass = null;
	    //真实姓名正则表达式
	    var zerename = null;
	    //email正则表达式
	    var zeemail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/ ;
	    //电话正则表达式
	    var zetel = /^1[3|4|5|8][0-9]\d{4,8}$/;
	    //身份证正则表达式
	    var zeidcard =/^\d{18}$/;
	    window.onload=function (){
	         username = document.getElementsByName("username")[0];
	         password = document.getElementsByName("password")[0];
	         realname = document.getElementsByName("realname")[0];
	         email = document.getElementsByName("email")[0];
	         tel = document.getElementsByName("tel")[0];
	         idcard = document.getElementsByName("idcard")[0];
	         save = document.getElementById("save");
	         //获取显示提示的标签对象
	         usernames = document.getElementById("usernames");
	         emails = document.getElementById("emails");
	         tels = document.getElementById("tels");
	         idcards = document.getElementById("idcards");
	        
	        //創建計時器
	        var intervaltd = setInterval(function(){
	        if(username.value==null||username.value==""||password.value==null||password.value==""
	         ||realname.value==null||realname.value==""||email.value==null||email.value==""||
	         tel.value==null||tel.value==""||idcard.value==null||idcard.value==""){
	         save.disabled=true;
	         username.onmouseout = function(){
	         if(!zeuser.test(username.value)){
	         	usernames.innerHTML="必须字母开头，5个字符到21个字符之间";
	         }else{
	            usernames.innerHTML="格式符合要求";
	         }
	         };
	         email.onmouseout = function(){
	         if(!zeemail.test(email.value)){
	         	emails.innerHTML="邮箱格式必须为：mail@163.com类型的";
	         }else{
	            emails.innerHTML="格式符合要求";
	         }
	         };
	         tel.onmouseout = function(){
	         if(!zetel.test(tel.value)){
	         	tels.innerHTML="不是正确的11位手机号";
	         }else{
	            tels.innerHTML="格式符合要求";
	         }
	         };
	         idcard.onmouseout = function(){
	         if(!zeidcard.test(idcard.value)){
	         	idcards.innerHTML="身份证号由18位数字组成";
	         }else{
	            idcards.innerHTML="格式符合要求";
	         }
	         };
	         }else{
	         if(zeuser.test(username.value)&&zeemail.test(email.value)&&zetel.test(tel.value)&&zeidcard.test(idcard.value)){
	         save.disabled=false;
	         };
	        
	        };
	        },1000);
	       
	        
	    };
</script>
</head>
<body>
<form action="AddOrg_EmployeeServlet_fan" enctype="multipart/form-data" method="post" class="definewidth m20">
<input type="hidden" name="id" value="{$user.id}" />
<span style="color:red">注意：带*号栏的都为必填项目，不能为空，为空则不能保存！</span>
    <table class="table table-bordered table-hover definewidth m10">

        <tr>
            <td width="10%" class="tableleft">登陆账号<span style="color:red">*</span></td>
            <td><input type="text" name="username"/><span style="color:red" id="usernames"></span></td>
        </tr>
        <tr>
            <td class="tableleft">密码<span style="color:red">*</span></td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td class="tableleft">姓名<span style="color:red">*</span></td>
            <td><input type="text" name="realname"/></td>
        </tr>
	     <tr>
            <td class="tableleft">性别 <span style="color:red">*</span></td>
            <td>
			   <input type="radio" name="sex" value="1" checked/> 男
              <input type="radio" name="sex" value="2" />女
			</td>
        </tr>

        <tr>
            <td class="tableleft">邮箱 <span style="color:red">*</span></td>
            <td><input type="text" name="email"/> <span style="color:red" id="emails"></span></td>
        </tr>
		
		<tr>
            <td class="tableleft">电话 <span style="color:red">*</span></td>
            <td><input type="text" name="tel"/><span style="color:red" id="tels"></span></td>
        </tr>
		
	     <tr>
            <td class="tableleft">身份证号 <span style="color:red">*</span></td>
            <td><input type="text" name="idcard"/><span style="color:red" id="idcards"></span></td>
        </tr>
		
		<tr>
            <td class="tableleft">地址 </td>
            <td><input type="text" name="address"/></td>
        </tr>
		
		
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="status" value="0" checked/> 启用
              <input type="radio" name="status" value="1" /> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色<span style="color:red">*</span></td>
            <td>
            	<select name="role">
        			<option value="">--请选择--</option>
        			<c:forEach items="${list }" var="list" varStatus="i">
        			<option value="${list.id }">${list.roleName }</option>
            		</c:forEach>
       			 </select>
        	</td>
        </tr>
		<tr>
            <td class="tableleft">头像</td>
            <td>
				<input type="file" name="nfile" />
        	</td>
        </tr>
		
		
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button" id="save">保存</button>&nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
            </td>
        </tr>
    </table></form>
</body>
</html>
