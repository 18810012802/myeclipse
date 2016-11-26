<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lib.service.t.Add_bookService"%>
<%@ page import="com.lib.serviceImpl.Add_bookServiceImpl"%>
<%@ page import="com.libo.entity.Add_book"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>通讯录--理博软件--2016</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
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
<script type="text/javascript">
	$(function() {
		$('#newNav').click(function() {
			window.location.href = "innerServlet";
		});
	});

	function checkall() {
		var alls = document.getElementsByName("check");
		var ch = document.getElementById("checkall");
		if (ch.checked) {
			for ( var i = 0; i < alls.length; i++) {
				alls[i].checked = true;
			}
		} else {
			for ( var i = 0; i < alls.length; i++) {
				alls[i].checked = false;
			}
		}
	}
	function delAll() {
		var alls = document.getElementsByName("check");
		var ids = new Array();
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				ids.push(alls[i].value);
			}
		}
		if (ids.length > 0) {
			if (confirm("确认操作?")) {
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
	
</script>
</head>
<body>

	<form action="innerServlet?type=personal" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">姓名：</td>
				<td><input type="text" name="pname" value="" /></td>

				<td width="10%" class="tableleft">电话号码：</td>
				<td><input type="text" name="pname" value="" /></td>
			</tr>
			<tr>
				<td colspan="6"><center>
						<button  class="btn btn-primary" id="">查询</button>
						<button  class="btn btn-primary" id="">清空</button>
					</center></td>
			</tr>
		</table>
	</form>

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>电话</th>
				<th>地址</th>
				<th>Email</th>
			</tr>
		</thead>
		<c:forEach items="${msg }" var="bo" >
		<tr>
			<td style="vertical-align:middle;"><input type="checkbox"
				name="check" value="1"></td>
			<td style="vertical-align:middle;">${bo.name }</td>
			<td style="vertical-align:middle;">${bo.sex }</td>
			<td style="vertical-align:middle;">${bo.birthday }</td>
			<td style="vertical-align:middle;">${bo.telphone }</td>
			<td style="vertical-align:middle;">${bo.address }</td>
			<td style="vertical-align:middle;">${bo.email }</td>
		</tr>
		</c:forEach>
	</table>

	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<th colspan="5">
				<div class="inline pull-right page">
					<a href='innerServlet?current=1'>第一页</a> 
					<a 
					<c:if test="${page>1 }">
					href='innerServlet?current=${page-1 }'
					</c:if>
					>上一页</a> <span class='current'>1</span>
					<c:if test="${pageCount>=2}"><a href='innerServlet?current=2'>2</a></c:if>
					<c:if test="${pageCount>=3}"><a href='innerServlet?current=3'>3</a></c:if>
					<c:if test="${pageCount>=4}"><a href='innerServlet?current=4'>4</a></c:if>
					<c:if test="${pageCount>=5}"><a href='innerServlet?current=5'>5</a></c:if> 
					<a 
					<c:if test="${page<pageCount }">
					href='innerServlet?current=${page+1 }'
					</c:if>
					>下一页</a> 
					<a href='innerServlet?current=1'>最后一页</a>
					&nbsp;&nbsp;&nbsp;
					共<span class='current'>${pageCount }</span>条记录
					<span class='current'> ${page }/${pageCount } </span>页
				</div>
				<button action="innerSerlvet?type=delPro" type="button" class="btn btn-success" id="delPro">导出Excel</button>
				</div>

			</th>
		</tr>
	</table>

</body>
</html>
