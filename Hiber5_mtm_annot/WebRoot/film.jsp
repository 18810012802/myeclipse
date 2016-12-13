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
	<script src="js/jquery-1.9.1.js"></script>
<script src="js/film.js"></script>
  </head>
  <body>
   <form action="FilmServlet" method="post">
  	<input type="hidden" value="query" name="type"/>
  	<table align="center" width="50%">
  		<tr>
  		<td>
  		电影名称：
  		</td>
  		<td>
  		<input type="text" name="filmName"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		电影类型：
  		</td>
  		<td>
  		<select id="filmType1" name="filmType">
  		<option value="0">所有
  		</option>
  		</select>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		主演：
  		</td>
  		<td>
  		<input type="text" name="actor"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		导演：
  		</td>
  		<td>
  		<input type="text" name="director"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		价格：
  		</td>
  		<td>
  		<input type="text" name="minticketPrice"/>至
  		<input type="text" name="maxticketPrice"/>
  		</td>
  		</tr>
  		<tr>
  		<td colspan="2">
  		<input type="submit" value="查询"/>
  		</td>
  		</tr>
  	</table>
  </form>
  <table width="400" align="center">
  <tr>
  	<td>电影名称</td><td>类型</td>
  	<td>主演</td><td>导演</td><td>票价</td>
  	
  </tr>
 <c:forEach items="${msgs }" var="msg">
 	<tr>
 	<td>${msg.filmname }</td>
 	<td>${msg.filmtype.typename }</td>
 	<td>${msg.actor }</td>
 	<td>${msg.director }</td>
 	<td>${msg.ticketprice }</td>
 	<td>
 	</td>
 	</tr>
 </c:forEach>
  </table>
  <form action="FilmServlet" method="post">
  	<input type="hidden" value="add" name="type"/>
  	<table align="center" width="50%">
  		<tr>
  		<td>
  		电影名称：
  		</td>
  		<td>
  		<input type="text" name="filmName"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		电影类型：
  		</td>
  		<td>
  		<select id="filmType" name="filmType">
  		<option value="0">所有
  		</option>
  		</select>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		主演：
  		</td>
  		<td>
  		<input type="text" name="actor"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		导演：
  		</td>
  		<td>
  		<input type="text" name="director"/>
  		</td>
  		</tr>
  		<tr>
  		<td>
  		价格：
  		</td>
  		<td>
  		<input type="text" name="ticketPrice"/>
  		</td>
  		</tr>
  		<tr>
  		<td colspan="2">
  		<input type="submit" value="发布"/>
  		</td>
  		</tr>
  	</table>
  </form>
  </body>
</html>
