
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<form action="QueryWaitInfoServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">刊物名称</td>
        <td><input type="text" name="name" value=""/></td>

        <td width="10%" class="tableleft">期号</td>
        <td><input type="text" name="number" value=""/></td>

        <td width="10%" class="tableleft">文件标题</td>
        <td><input type="text" name="title" value=""/></td>
    </tr>
    <tr>
		  <td colspan="6"><center>
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
		<th>刊物名称</th>
		<th>期号</th>        
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach items="${fil }" var="fi">
	     <tr >
         	<td style="vertical-align:middle;">${fi.id }</td>
		    <td style="vertical-align:middle;">${fi.title }</td>
			<td style="vertical-align:middle;">${fi.orgem.username }</td>
            <td style="vertical-align:middle;">${fi.sendDate }</td>			
            <td style="vertical-align:middle;">${fi.type }</td>
            <td style="vertical-align:middle;">${fi.filetype }</td>
			<td  style="vertical-align:middle;">${fi.msgman.name }</td>
			<td  style="vertical-align:middle;">${fi.number}</td>		                
            <td style="vertical-align:middle;"><a href="SelectWaitInfoServlet?id=${fi.id }">审核</a></td>
        </tr>
		</c:forEach>
		
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
        共${waitInfoCount }条记录 每页显示5条 当前 ${currentPage }/${pageCount } 页  
        <a href='QueryWaitInfoServlet?current=1&name=${name }&number=${number }&title=${title }'>首页</a>
        
        <a 
        	<c:if test="${currentPage>1}">
        	href='QueryWaitInfoServlet?current=${currentPage-1 }&name=${name }&number=${number }&title=${title }'
        	</c:if>
        >上一页</a>
        <span class='current'>1</span>
         <c:if test="${pageCount >=2}">
        	<a href='QueryWaitInfoServlet?current=2&name=${name }&number=${number }&title=${title }'>2</a>
         </c:if>	
         <c:if test="${pageCount >=3}">
        <a href='QueryWaitInfoServlet?current=3&name=${name }&number=${number }&title=${title }'>3</a>
         </c:if>
         <c:if test="${pageCount >=4}">
        <a href='QueryWaitInfoServlet?current=4&name=${name }&number=${number }&title=${title }'>4</a>
         </c:if>
         <c:if test="${pageCount >=5}">
        <a href='QueryWaitInfoServlet?current=5&name=${name }&number=${number }&title=${title }'>5</a> 
         </c:if>
        <a 
        	<c:if test="${currentPage<pageCount }">
       	 		href='QueryWaitInfoServlet?current=${currentPage+1 }&name=${name }&number=${number }&title=${title }' 
       	 	</c:if>	
       	 >下一页</a> 
        <a href='QueryWaitInfoServlet?current=${pageCount }&name=${name }&number=${number }&title=${title }' >尾页</a></div>
		  </div>
		 </th></tr>
  </table>
  
</body>
</html>
