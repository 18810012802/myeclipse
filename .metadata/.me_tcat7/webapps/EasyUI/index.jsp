<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="js/jquery-1.9.1.js"></script>
<script src="easyui\jquery.easyui.min.js"></script>
<script src="easyui\locale\easyui-lang-zh_CN.js"></script>
<script src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<style type="text/css">
.textbox {
	height: 20px, margin:0;
	padding: 0 2px;
	box-sizing: content-box;
}
</style>
</head>

<body>
	<ul id="box">
		
	</ul>
	<form id="myform">
		名字：<input type="text" name="name"/><span id='tip1'></span>
	</form>
	<table id="mytable" width="50%" align="center">
		<tr><td>id</td><td>name</td><td>telephone</td></tr>
	</table>
</body>
</html>
