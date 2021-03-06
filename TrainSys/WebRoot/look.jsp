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
<title>火车车次详情</title>
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
	function downloadFile() {
		var path = $("#downpath").val();
		$.ajax({
			type : "POST",
			url : "PublishServlet",
			data : "type=download&path=" + path,
			success : function(msg) {
				alert(msg);
				//jAlert(msg,"确定");
			}
		});
	}
	$(function() {
		$('#backid').click(function() {
			window.location.href = "trainList.jsp";
		});
	});
</script>
</head>
<body>
	<form action="index.jsp" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="25%" colspan="2" align="center" class="tableleft"><center>车次详情</center></td>
			</tr>
			<tr>
				<td width="25%" class="tableleft">车次</td>
				<td>${msg.train_no }</td>
			</tr>
			<tr>
				<td width="25%" class="tableleft">发车--到达</td>
				<td>${msg.station }</td>
			</tr>
			<tr>
				<td id="td" width="10%" class="tableleft">发时--到时</td>
				<td>${msg.time }</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">车型</td>
				<td>${msg.type}</td>
			</tr>

			<tr>
				<td width="10%" class="tableleft">运行时间（小时）</td>
				<td>${msg.runtime }</td>
			</tr>


			<tr>
				<td width="10%" class="tableleft">里程（公里）</td>
				<td>${msg.mile }</td>
			</tr>

			<tr>
				<td colspan="2">
					<center>
						<button type="button" class="btn btn-success" name="backid"
							id="backid">返回列表</button>
					</center>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
