<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	<script type="text/javascript">
		function checkold(obj){
			var s = /^[A-Za-z0-9]{2,20}$/;
			var opwd=document.getElementById("opwd");
			var oldpwd=document.getElementById("oldpwd");
			if(s.test(obj)){
				opwd.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}else{
				opwd.innerHTML="您输入的密码不合法！";
				oldpwd.selected=true;
			}
		}
		function checknew(obj){
			var s = /^[A-Za-z0-9]{2,20}$/;
			var npwd=document.getElementById("npwd");
			var newpwd=document.getElementById("newpwd");
			if(s.test(obj)){
				npwd.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}else{
				npwd.innerHTML="您输入的密码不合法！";
				newpwd.selected=true;
			}
		}
		function recheck(obj) {
			var newpwd=document.getElementById("newpwd");
			var repwd=document.getElementById("repwd");
			var rpwd=document.getElementById("rpwd");
			if(obj==newpwd.value){
				rpwd.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}else{
				rpwd.innerHTML="两次输入的密码不一致！";
				repwd.selected=true;
			}
		}
	</script>

</head>
<body>
<form  action="PassWordServlet" method="post" class="form-inline definewidth m20">    
   <table>
		<tr>
			<td align="right">原密码:</td>
			<td><input name="oldpwd" id="oldpwd" onblur="checkold(this.value);" type="password"/></td>
			<td id="opwd" style="color: red" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td align="right">新密码:</td>
			<td><input name="newpwd" id="newpwd" onblur="checknew(this.value);" type="password"/></td>
			<td id="npwd" style="color: red" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			
		</tr>
		<tr>
			<td align="right">确认密码:</td>
			<td><input name="repwd" id="repwd" onblur="recheck(this.value);" type="password"/></td>
			<td id="rpwd" style="color: red" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br/>
				<input type="submit" value="保存" class="btn btn-primary"/>
			</td>
		</tr>
   </table>
</form>
</body>
</html>