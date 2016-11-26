<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>回复邮件</title>
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
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "index.html";
		});
	});
</script>
</head>
<body>
	<form action="SendEmailServlet" method="post"
		enctype="multipart/form-data" class="definewidth m20">
		<!-- 向serlet传递本人id与当前目录id -->
		<input type="hidden" name="suid" value="1" /> <input type="hidden"
			name="menuid" value="21" /> <input type="hidden" name="reStr"
			value="0" />
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td width="10%" class="tableleft">收件人<span style="color:red">*</span></td>
				<td><select name="ruid">
						<c:forEach items="${list }" var="list" varStatus="status">
							<option value="${list.id }"
								<c:if test="${userid>0&&userid==list.id }">
	selected
	</c:if>>${list.username
								}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="tableleft">标题<span style="color:red">*</span></td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td class="tableleft">内容</td>
				<td><textarea name="content" id=""
						class="control-row4 input-large" cols="8" rows="6"></textarea></td>
			</tr>
			<tr>
				<td class="tableleft">附件</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary">发送</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>