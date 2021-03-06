<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>火车车次</title>
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/jquery-1.9.1.js"></script>
<script src="easyui\jquery.easyui.min.js"></script>
<script src="easyui\locale\easyui-lang-zh_CN.js"></script>
<script src="js/index.js"></script>
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

<body style="margin:0px auto;">
<center>
	<table id="table">
	<div id="tb" style="padding:5px;height:auto;margin-left:150px;left:50%;width:600px;">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="obj.add()">添加</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="obj.update()">修改</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="obj.del()">删除</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit" plain="true"
				onclick="obj.save()" style="display:none;" id="save">保存</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="obj.redo()" style="display:none;" id="redo">取消</a>
		</div>
		<div style="padding:0 0 0 7px">
			查询车次：<input class="textbox" name="trainNo" style="width:110px">
			列车类型：<input id="trainType" class="textbox" name="trainType" style="width:110px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="obj.search();">查询</a>
		</div>
	</div>
	</table>
	</center>
</body>
</html>
