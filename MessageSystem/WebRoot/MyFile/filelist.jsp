<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>门诊医生--理博软件--2016</title>
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
			var value=document.getElementById("id").value;
				window.location.href="UpdaFileServlet?id=value";
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
function daoChu(){
			
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
					var id=ids.join(",");
						window.location.href="daoChu?type=4&id="+id;
			}else{
				alert("请选中要操作的项");
			}
	}
    </script>
</head>
<body>

<form action="FilelistServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">标题</td>
        <td><input type="text" name="title" value="${title }"/></td>

        <td width="10%" class="tableleft">类型</td>
        <td><input type="text" name="type" value="${type }"/></td>

        <td width="10%" class="tableleft">文体</td>
        <td><input type="text" name="filety" value="${wordType }"/></td>
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
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>标题</th>
        <th>类别</th>
        <th>文体</th>
	<th>作者</th>	
        <th>来源</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${file }" var="file">
	 <tr >

            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="${file.id }"></td>
            <td style="vertical-align:middle;">${file.title }</td>
            <td style="vertical-align:middle;">${file.type }</td>
            <td style="vertical-align:middle;">${file.filetype }</td>
            <td style="vertical-align:middle;">${file.author }</td>
            <td style="vertical-align:middle;">${file.from }</td>
            <td style="vertical-align:middle;">
	<a href="UpdateFileServlet?midd=${file.id }">编辑</a><a href="DelMsgFileServlet?delid=${file.id }">删除</a>
		</td>
        </tr>
</c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
          共${coun }条记录 每页显示2条 当前 ${currPage }/${pagecount } 页
          <a href="FilelistServlet?current=1&title=${title }&typt=${type }&wordType=${wordType }">首页</a>&nbsp;&nbsp;&nbsp;
          <a 
				<c:if test="${currPage>1 }">
						href="FilelistServlet?current=${currPage-1 }&title=${title }&typt=${type }&wordType=${wordType }"
				</c:if>
				 >上一页</a>&nbsp;&nbsp;&nbsp;
          <!-- <span class='current'>1</span> -->
          <c:forEach items="" step="${pagecount }" varStatus="abc">
          <a href='FilelistServlet?current=2&title=${title }&typt=${type }&wordType=${wordType }'>${abc.count }</a>
          </c:forEach>
          
          <a
				<c:if test="${currPage<pagecount }">
						 href="FilelistServlet?current=${currPage+1 }&title=${title }&typt=${type }&wordType=${wordType }"
				 </c:if>
				 >下一页</a>&nbsp;&nbsp;&nbsp;
          <a href="FilelistServlet?current=${pagecount }&title=${title }&typt=${type }&wordType=${wordType }">尾页</a>&nbsp;&nbsp;&nbsp;
         </div> <a href="AddFileoneServlet"><div><button type="button" class="btn btn-success" id="newNav">新增</button></a>
         <button type="button" class="btn btn-success" onclick="daoChu()" id="delPro">导出Excel</button>
         </div>
		 </th></tr>
  </table>
  
</body>
</html>
