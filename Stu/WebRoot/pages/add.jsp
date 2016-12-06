<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	if (request.getParameter("page") == null) {
		request.setAttribute("page", 1);
	}
%>

<HTML>
<HEAD>
<TITLE>学生列表</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<script src="js/jquery-1.9.1.js"></script>
<script>
	$(function() {

		$.post("StuServlet", {
			type : 'classes'
		}, function(msg) {
			for ( var i = 0; i < msg.length; i++) {
				var ms = msg[i];
				$(":input[name='clsId']").append(
						"<option value=" + ms.id + ">" + ms.name
								+ "</option>);");
			}
		}, "json");
	});
</script>
</head>
<body>
	<h2>增加学生页面</h2>
	<form method="post" action="StuServlet?type=update">
		请输入学生姓名：<input type="text" name="stuName" /><br /> 请输入学生年龄：<input
			type="text" name="age" /><br /> 请选择所属班级：<select name="clsId">
		</select> <input type="submit" value="增加" />
	</form>
</body>
</html>
