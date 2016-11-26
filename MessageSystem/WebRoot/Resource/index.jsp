<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title></title>
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
				window.location.href="Resource/add.jsp";
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
				if(confirm("确认删除?")){
					var id=ids.join(",");
					window.location.href="deletServlet_mc?id="+id;
					alert("删除成功!");
				}
			}else{
				alert("请选中要删除的项");
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
				window.location.href="daoChuServlet?id="+id;
			}else{
				alert('请选择要导出的项');
			}
		}

	
    </script>
</head>
<body>
<form class="form-inline definewidth m20" action="menuServlet_mc" method="post">    
    资源(菜单)名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="${username }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary" >查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>资源名称</th>
        <th>路径Url</th>
        <th>是否有效</th>
        <th  width="10%">操作</th>
    </tr>
    </thead>
	     	<c:forEach items="${list}" var="list">
	     <tr>
         	<td style="vertical-align:middle;">
         	<input type="checkbox" name="check" value="${list.id }"></td>
            <td>${list.menuName }</td>
            <td>${list.url }</td>
            <td>${list.state }</td>
            <td>
                <a href="editServlet_mc?name=${list.menuName}&url=${list.url}&state=${list.state}&id=${list.id}">编辑</a>&nbsp;&nbsp;&nbsp;<a href="editDelet?id=${list.id}">删除</a>             
            </td>
        </tr>	
           </c:forEach>
</table>
   <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
         共${pagelon }条记录 每页显示${pageSize }条 当前 ${current }/${pagelon } 页  <a href='menuServlet_mc?current=1&username=${username}'>首页</a>
         <a 
         	<c:if test="${current>1 }">
         href='menuServlet_mc?current=${current-1 }&username=${username }'
         	</c:if>
         >上一页</a>
         <span class='current'><a href='menuServlet_mc?current=1&username=${username}'>1</a></span><a href='menuServlet_mc?current=2&username=${username}'>2</a>
         <a href='menuServlet_mc?current=3&username=${username}'>3</a>
         <a href='menuServlet_mc?current=4&username=${username}'>4</a><a href='menuServlet_mc?current=5'>5</a>  
         <a
         	<c:if test="${current<pagelon }">
         href='menuServlet_mc?current=${current+1}&username=${username}' 
        	</c:if> 
         >下一页</a> 
         <a href='menuServlet_mc?current=${pagelon}&username=${username}' >尾页</a></div>
		 <div><button type="button" class="btn btn-success" id="newNav">添加</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除</button>
		 <button type="button" class="btn btn-success" id="newNav" onClick="daoChu();">导出Excel</button>
		 </div></th></tr>
  </table> 
</body>
</html>
