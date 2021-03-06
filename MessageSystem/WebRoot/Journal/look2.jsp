<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>查看--理博软件--2016</title>
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
    	function back(maId){ 
				window.location.href="PublishServlet?type=filelist&maId="+maId;
		 }
		 function review(id){
			 var ids=id.split(',');
		     $.ajax({
						type:"POST",
						url:"PublishServlet",
						data:"type=review&id="+ids[1],
						success:function(msg){
							alert(msg);
							window.location.href="PublishServlet?type=look2&maId="+ids[0]+"&id="+ids[1];
						}
					});
		 }
		 function unreview(id){
		 	 var ids=id.split(',');
		       $.ajax({
						type:"POST",
						url:"PublishServlet",
						data:"type=unreview&id="+ids[1],
						success:function(msg){
							alert(msg);
							window.location.href="PublishServlet?type=look2&maId="+ids[0]+"&id="+ids[1];
						}
					});
		 }
    	
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">写稿人</td>
         <td>${msg.author} </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">标题</td>
        <td>${msg.title}</td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">类别</td>
        <td>${msg.type}</td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">文体</td>
        <td>${msg.filetype}</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">约稿详细要求</td>
        <td> <textarea readonly="readonly" name="" id="" class="control-row4 input-large">
            ${msg.maContent}
            
        </textarea></td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">发稿日期</td>
        <td>${msg.maCreateTime}</td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
			<c:if test="${msg.state ne 3}">
				<button type="button" class="btn btn-success" name="review2" value="${maId},${msg.id}" onclick="review(this.value);" >录用</button>
             </c:if> 
             <c:if test="${msg.state ne 2}">  
                <button type="button" class="btn btn-success" name="unreview2" value="${maId},${msg.id}" onclick="unreview(this.value);" >不录用</button>
             </c:if>
                <button type="button" class="btn btn-success" name="backid2" value="${maId}" onclick="back(this.value)">返回</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>
