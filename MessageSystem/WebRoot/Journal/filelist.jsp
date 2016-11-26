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
    <title>稿件审核</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
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
		$('#newNav').click(function(){
				window.location.href="add.jsp";
		 });
    });
	
    	function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}
    </script>
</head>
<body>

<form action="PublishServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
    	
        <td width="10%" class="tableleft">文件标题</td>
        <td><input type="hidden" name="type" value="filelist"/><input type="text" name="title" value=""/></td>
		
        <td width="10%" class="tableleft">上报人</td>
        <td><input type="hidden" name="maId" value="${maId}"/><input type="text" name="sendUser" value=""/></td>

    </tr>
    <tr>
		  <td colspan="4"><center>
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="submit" class="btn btn-primary" type="button">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th>序号</th>				
		<th>标题</th>
		<th>上报人</th>
        <th>上报日期</th>
		<th>类别</th>
        <th>文体</th>       
		<th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${msg }" var="ms" varStatus="status">
	     <tr >
         	<td style="vertical-align:middle;">${status.count }</td>
		    <td style="vertical-align:middle;">${ms.title }</td>
			<td style="vertical-align:middle;">${ms.sendUser }</td>
            <td style="vertical-align:middle;">${ms.sendDate }</td>			
            <td style="vertical-align:middle;">${ms.type }</td>
            <td style="vertical-align:middle;">${ms.filetype }</td>
			<td style="vertical-align:middle;"><a href="PublishServlet?type=look2&maId=${maId}&id=${ms.id}">查看详情</a></td>
        </tr>	
        </c:forEach>	
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
        共${count }条记录 每页显示${pageSize}条 当前第 ${page }页 
 <a href='PublishServlet?maId=${maId}&type=filelist&page=1&title=${title}&sendUser=${sendUser}'>首页</a>
           
          <a href='PublishServlet?maId=${maId}&type=filelist&page=${(page>0)?page-1:page}&title=${title}&sendUser=${sendUser}'>
          	<c:if test="${page ne 1}">
          	上一页
          	</c:if>
          </a>
          
          <c:forEach var="x" begin="1"end="${pageCount}" step="1"> 
          <a href='PublishServlet?maId=${maId}&type=filelist&page=${x }&title=${title}&sendUser=${sendUser}'>${x }</a> 
          </c:forEach> 
          
          <a href='PublishServlet?maId=${maId}&type=filelist&page=${(pageCount>page)?page+1:pageCount}&title=${title}&sendUser=${sendUser}' >
          <c:if test="${page ne pageCount}">下一页</c:if></a> <a href='PublishServlet?maId=${maId}&type=filelist&page=${pageCount}&title=${title}&sendUser=${sendUser}' >尾页</a>
       </div>
		  
		 </th></tr>
  </table>
  
</body>
</html>
