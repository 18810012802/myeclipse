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
    <title>我的约稿-约稿信息</title>
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
				window.location.href="TyExportExelServlet";
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
			alert(ids);
			if(ids.length>0){
				if(confirm("确认操作?")){
					var dd=ids.join(",");
						var uu=<%=session.getAttribute("org_id") %>;
						window.location.href="ReceiveServlet?chan=cha&uid="+uu+"&fid="+dd;	
						alert(ids);
					
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}
		
		td=document.getElementById("td");
	//自己加的
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
						window.location.href="daoChu?type=1&id="+id;
			}else{
				alert("请选中要操作的项");
			}
	}
    </script>
</head>
<body>

<form action="MyFileMesServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">刊物名称：</td>
        <td><input type="text" name="pname" value=""/></td>
        <td width="10%" class="tableleft">期号：</td>
        <td><input type="text" name="pnum" value=""/></td>
    </tr>
    <tr>
		  <td colspan="6"><center>
            <button type="submit" class="btn btn-primary">查询</button> 
            <button type="submit" class="btn btn-primary">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>刊物名称</th>
        <th>期号</th>
		<th>内容</th>        
        <th>上报截止时间</th>
        <th>发布时间</th>
		<th>发布人</th>        
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${msg }" var="ms">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" id="m" value="${ms.id }"></td>
            <td style="vertical-align:middle;">${ms.name }</td>
			<td style="vertical-align:middle;">${ms.number }</td>            
            <td style="vertical-align:middle;">${ms.content }</td>
            <td style="vertical-align:middle;">${ms.endDate }</td>
            <td style="vertical-align:middle;">${ms.createDate }</td>
            <td style="vertical-align:middle;">${ms.ore.username }</td> 
            <td style="vertical-align:middle;"><a href="LookFileServlet?menid=3&fid=${ms.id }">查看详情</a>&nbsp;&nbsp;&nbsp;
            <a href="ReceiveServlet?chan=cha&fid=${ms.id }&uid=<%=session.getAttribute("org_id") %>">接收</a>&nbsp;&nbsp;&nbsp;
            <a href="ReceiveServlet?chan=chan&fid=${ms.id }&uid=<%=session.getAttribute("org_id") %>">拒收</a></td>
        </tr>
     </c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
		 共${coun }条记录 每页显示2条 当前 ${currPage }/${pagecount } 页
          <a href="MyFileMesServlet?current=1&pname=${pname }&pnum=${pnum }">首页</a>&nbsp;&nbsp;&nbsp;
          <a 
				<c:if test="${currPage>1 }">
						href="MyFileMesServlet?current=${currPage-1 }&pname=${pname }&pnum=${pnum }"
				</c:if>
				 >上一页</a>&nbsp;&nbsp;&nbsp;
          <a
				<c:if test="${currPage<pagecount }">
						 href="MyFileMesServlet?current=${currPage+1 }&pname=${pname }&pnum=${pnum }"
				 </c:if>
				 >下一页</a>&nbsp;&nbsp;&nbsp;
          <a href="MyFileMesServlet?current=${pagecount }&pname=${pname }&pnum=${pnum }">尾页</a>&nbsp;&nbsp;&nbsp;
				</div>
		 <div>
		 <button type="button" class="btn btn-success" id="delPro" onclick="delAll();">接受</button>
		 <button type="button" class="btn btn-success" name="newNav" onclick="daoChu()">导出Excel</button>         
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
</html>
