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

<body>
	<table id="table">
		<!--  <thead>
    	<tr>
    		<th data-options="field:'user'">账号</th>
    		
    	</tr>
   	</thead>
   	<tbody>
   		<tr>
   			<td>蜡笔小新</td>
   		</tr>
   	</tbody> -->
	</table>
	<div id="menu" class="easyui-menu" style="width:120px;display:none;">
		<div onclick="" iconCls="icon-add">增加</div>
		<div onclick="" iconCls="icon-remove">删除</div>
		<div onclick="" iconCls="icon-edit">修改</div>
	</div>
	<div id="tb" style="padding:5px;height:auto">
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
			查询车次:<input class="textbox" name="trainNo" style="width:110px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="obj.search();">查询</a>
		</div>
	</div>
</body>
</html>