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
		var clsId = $(":input[name='clsId_hide']").val().trim();

		$.post("StuServlet", {
			type : 'classes'
		}, function(msg) {
			for ( var i = 0; i < msg.length; i++) {
				var ms = msg[i];
				$(":input[name='clsId']").append(
						"<option value=" + ms.id + ">" + ms.name
								+ "</option>);");
			}
			$(":input[name='clsId']").val(clsId);

		}, "json");
	});
</script>
</head>
<body>
	<h2>修改学生页面</h2>
	<form method="post" action="StuServlet?type=update">
		学生编号：<input type="text" name="stuId" value="${msg.stuId }" /><br />
		学生名称：<input type="text" name="stuName" value="${msg.stuName }" /><br />
		学生年龄：<input type="text" name="age" value="${msg.age }" /><br /> <input
			type="hidden" name="clsId_hide" value="${msg.classes.clsId }" /><br />
		所属班级：<select name="clsId">
		</select> <input type="submit" value="更新" />
	</form>
</body>
</html>
