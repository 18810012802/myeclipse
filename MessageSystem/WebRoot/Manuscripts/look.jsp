<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>约稿信息查看</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
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
				window.location.href="ShowServlet";
		 });
    });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<c:forEach items="${msg }" var="ms" >
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">刊物名称</td>
        <td>${ms.name}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">期号</td>
        <td>${ms.number }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">内容</td>
        <td>
		<pre>
			${ms.content}         
		</pre>
		</td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">约稿状态</td>
         <c:if test="${ms.state==0 }">
          		  <td>未发布</td>
            </c:if>
            <c:if test="${ms.state==1 }">
          		  <td>已发布</td>
            </c:if>  	    
        
    </tr>
	
    <tr>
        <td width="10%" class="tableleft">上报截止时间</td>
        <td>${ms.endDate}</td>
    </tr>
	

	<tr>
        <td width="10%" class="tableleft">附件</td>
        <td>
		<c:choose>
			<c:when test="${fname!=null }">
			${fname }
			</c:when>
			<c:otherwise>
				该约稿信息没有上传附件！
			</c:otherwise>
		</c:choose>
			
		</td>
    </tr>
	
	<tr>
       <td width="10%" class="tableleft">发布时间</td>
        <td>${ms.createDate}</td>
	</tr>
	</c:forEach>
	<tr>
       <td width="10%" class="tableleft">发布人</td>
        <td>${uname }</td>
	</tr>
	
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>
