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
<TITLE>学生明细</TITLE>
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
	<form method="post" action="###">
		学生编号：<input type="text" name="stuId" value="${msg.stuId }" readonly/><br />
		学生名称：<input type="text" name="stuName" value="${msg.stuName } " readonly/><br />
		学生年龄：<input type="text" name="age" value="${msg.age }" readonly/><br /> <input
			type="hidden" name="clsId_hide" value="${msg.classes.clsId } " readonly/><br />
		所属班级：<select name="clsId">
		</select> <br/>
		<a href="StuServlet"><font color="pink">返回</font></a>
	</form>
</body>
</html>
