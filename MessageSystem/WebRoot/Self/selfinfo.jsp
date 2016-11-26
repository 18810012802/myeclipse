<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form action="index.html" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td width="10%" clospan=2><img src="${photo }"
					style="width:120px;height: 120px;"></td>

			</tr>

			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td>${oe.loginname }</td>
			</tr>

			<tr>
				<td class="tableleft">真实姓名</td>
				<td>${oe.username }</td>
			</tr>
			<tr>
				<td class="tableleft">性别</td>
				<td><c:if test="${oe.sex==1 }">
			   男
            </c:if> <c:if test="${oe.sex==0 }">
			  女
            </c:if></td>
			</tr>

			<tr>
				<td class="tableleft">邮箱</td>
				<td>${oe.email }</td>
			</tr>

			<tr>
				<td class="tableleft">电话</td>
				<td>${oe.telphone }</td>
			</tr>

			<tr>
				<td class="tableleft">身份证号</td>
				<td>${oe.idcaid }</td>
			</tr>




			<tr>
				<td class="tableleft">状态</td>
				<td><c:if test="${oe.state==0 }">
                                                   启用
            </c:if> <c:if test="${oe.state==1 }">
                                                   禁用
            </c:if></td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td>${roleid }</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "index.html";
		});
	});
</script>