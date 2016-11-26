<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查看邮件</title>
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
<script type="text/javascript" src="Js/ckeditor/ckeditor.js"></script>


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
    $(function () {       
		$('#backid').click(function(){
		var tar=$('#tar').val();
		if(tar=="rece"){
			window.history.back();
		}else{
			window.history.back();
		}
		 });
    });
    </script>
</head>
<body>
	<form action="selectboxServlet" method="post" class="definewidth m20">
		<input type="hidden" id="tar" name="tar" value="${tar }" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">标题</td>
				<td>${box.title }</td>

			</tr>
			<tr>
				<td width="10%" class="tableleft">发件人/收件人</td>
				<td><c:forEach items="${rlist }" var="r">
						<c:if test="${box.receiveuserid==r.id }">
            		${r.username }
            	</c:if>
					</c:forEach></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">发送时间</td>
				<td>${box.senddate }</td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">内容</td>
				<td><textarea name="" readonly="readonly" id=""
						class="control-row4 input-large" cols="8" rows="6">
            
          ${box.content }
        </textarea></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">附件</td>
				<td><a href="DownLoadPic?picurl=${attach.path }">${attach.path
						}</a></td>
				<%-- <td>DownLoadPic?picurl=${attach.path }</td> --%>
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
