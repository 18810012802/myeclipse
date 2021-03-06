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
</head>
<body>
	<table width="400px">
		<tr>
			<td colspan=7><a href="StuServlet?type=toAdd&stuId=${ms.stuId }">增加学生</a></td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>班级</td>
			<td>删除</td>
			<td>修改</td>
			<td>详情</td>
		</tr>
		<tbody>

			<c:forEach items="${msg }" var="ms">
				<tr>
					<td>${ms.stuId }</td>
					<td>${ms.stuName}</td>
					<td>${ms.age }</td>
					<td>${ms.classes.clsName }</td>
					<td><a href="StuServlet?type=delete&stuId=${ms.stuId }">删除</a></td>
					<td><a href="StuServlet?type=toUpdate&stuId=${ms.stuId }">修改</a></td>
					<td><a href="StuServlet?type=detail&stuId=${ms.stuId }">详情</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
