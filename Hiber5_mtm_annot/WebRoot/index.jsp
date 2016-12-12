<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <table width="400" align="center">
  <tr>
  	<td>老师ID</td><td>老师姓名</td>
  	<td>学生</td>
  	
  </tr>
 <c:forEach items="${msgs }" var="msg">
 	<tr>
 	<td>${msg.tid }</td>
 	<td>${msg.tname }</td>
 	<td>
 	<table width="50%" align="center">
 	<c:forEach items="${msg.students }" var="m">
 	<tr><td>
 	${m.sname }
 	</td></tr>
 	</c:forEach>
 	</table>
 	</td>
 	
 	</tr>
 </c:forEach>
  </table>
  <form action="STServlet" method="post">
  	<input type="hidden" value="add" name="type"/>
  	<table align="center" width="50%">
  		<tr>
  		<td>
  		请输入老师姓名：
  		</td>
  		<td>
  		<input type="text" name="tname"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		请输入学生姓名：
  		</td>
  		<td>
  		<input type="text" name="sname"/>
  		</td>
  		</tr>
  		<tr>
  		<td colspan="2">
  		<input type="submit" value="添加"/>
  		</td>
  		</tr>
  	</table>
  </form>
  </body>
</html>
