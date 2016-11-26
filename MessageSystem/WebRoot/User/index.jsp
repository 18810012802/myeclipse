
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	
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
				window.location.href="AddOrg_EmployeeServlet_fan";
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
			var idss="-1";
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
					idss+=","+alls[i].value;
				}		
			}
			if(ids.length>0){
				if(confirm("确认?")){
				window.location.href="DeleteOrg_EmployeeServlet_fan?ids="+idss;
					
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
				window.location.href="daoChu_fan?type=1&id="+id;

			}else{
				alert("请选中要导出的项");
			}
		}
    </script>
</head>
<body>
<form class="form-inline definewidth m20" action="Org_EmployeeServlet_fan" method="post">    
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>用户账户</th>
        <th>真实姓名</th>
        <th>角色</th>
        <th  width="10%">操作</th>
    </tr>
    </thead>
    <c:forEach items="${list }" var="li" >
	     <tr>
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${li.id }"></td>
            <td>${li.loginname}</td>
            <td>${li.username}</td>
            <td>${li.orgrole.roleName}</td>
            <td>
                <a href="UpdateOrg_EmployeeServlet_fan?orgid=${li.id }">编辑</a>&nbsp;&nbsp;&nbsp;<a href="DeleteOrg_EmployeeServlet_fan?ids=${li.id }">删除</a>
            </td>
        </tr>	
	</c:forEach>
		
		
		
		

</table>
<table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
         共${count }条记录 每页显示5条 当前 ${pages }/${max } 页  <a href='?pageNum=1'>首页 </a>
                     <c:if test="${pages eq 1 }">
			         <span style="color: gray">上一页</span>
			         </c:if>
			          <c:if test="${pages ne 1 }">
			         <a href="Org_EmployeeServlet_fan?pageNum=${pages-1 }">上一页</a>
			         </c:if>
         	<c:forEach items="${nlist }" var="nlist" varStatus="i">
          	<c:if test="${pages eq  i.index+1 }">
          	<span class='current'>${pages }</span>
         	 </c:if>
           	<c:if test="${pages ne  i.index+1 }">
           	<a href="Org_EmployeeServlet_fan?pageNum=${i.index+1 }">${i.index+1}</a>
           	</c:if>
          	</c:forEach> 
         	<c:if test="${pages eq max }">
			         <span style="color: gray">下一页</span>
			         </c:if>
			        <c:if test="${pages ne max }">
			         <a href="Org_EmployeeServlet_fan?pageNum=${pages+1 }">下一页</a>
			         </c:if> 
			         <a href="Org_EmployeeServlet_fan?pageNum=${max }">末页</a>
			         </div>
		 <div><button type="button" class="btn btn-success" id="newNav">添加</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除</button>
		 <button type="button" class="btn btn-success" id="newNav" onClick="daoChu();">导出Excel</button>
		 </div></th></tr>
  </table>
</body>
</html>
