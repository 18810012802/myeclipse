<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
		function reload(value){
			value.src='ImgServlet?time='+new Date().getTime();
		}
		function checkCode(value){
			var ajax=new XMLHttpRequest();
			ajax.open('post','CheckCodeServlet?code='+value);
			ajax.send();
			ajax.onreadystatechange=function(){
				if(ajax.readyState==4&&ajax.status==200){
					document.getElementById("sp").innerHTML=ajax.responseText;
				}
			}
		}
	</script>
  </head>
  
  <body>
    
   <from action="IndexServlet" method="post">
   	<p>验证码：<input type="text" onblur="checkCode(this.value);" name="code"/><img src="ImgServlet" onclick="reload(this);"><span id="sp"></span></p>
   	<p><input type="submit" value="验证" /> </p>
   </from>
  </body>
</html>
