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
    <title>理博软件2016</title>
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
				window.location.href="AddInfoJspServlet?oid=<%=session.getAttribute("org_id")%>";
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
			var qid=ids.join();
			if(ids.length>0){
				if(confirm("确认操作?")){
						window.location.href="DelInfosServlet?qid="+qid;
					}
					alert("成功!");			
			}else{
				alert("请选中要操作的稿件");
			}
		}
		function issue(){
			window.location.href="IssueExportExcelServlet";
		}
    </script>
</head>
<body>

<form action="ShowServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">刊物名称：</td>
        <td><input type="text" name="name" value=""/></td>
        <td width="10%" class="tableleft">刊物编号：</td>
        <td><input type="text" name="number" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">发布开始时间：</td>
        <td><input type="text" name="newDate" value=""/></td>

        <td width="10%" class="tableleft">发布结束时间：</td>
        <td><input type="text" name="endDate" value=""/></td>
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
        <th>期号</th>
        <th>刊物名称</th>
        <th>约稿信息</th>
        <th>约稿发布时间</th>
        <th>约稿截止时间</th>
        <th>约稿状态</th>
        <th>操作</th>
    </tr>
    </thead>
	    <c:forEach items="${msg }" var="ms" >
		<tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${ms.id }"></td>
            <td style="vertical-align:middle;">${ms.number }</td>
            <td style="vertical-align:middle;">${ms.name}</td>
            <td style="vertical-align:middle;">${ms.content}</td>
            <td style="vertical-align:middle;">${ms.createDate}</td>
            <td style="vertical-align:middle;">${ms.endDate}</td>
            <td style="vertical-align:middle;">
            <c:if test="${ms.state==0 }">
          		  未发布  
            </c:if>
            <c:if test="${ms.state==1 }">
          		  已发布
            </c:if>  	                
            </td>
            <td style="vertical-align:middle;">
            	<c:if test="${ms.state==0 }">
					<a href="SelectInfoServlet?id=${ms.id }&oid=${ms.sendUserId }">修改</a>&nbsp;|&nbsp;
					<a href="DelInfoServlet?id=${ms.id } ">删除</a>
					<a href="QueryInfoServilet?id=${ms.id }&uid=${ms.sendUserId }">查看详情</a>&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${ms.state==1 }">
					<a href="QueryInfoServilet?id=${ms.id }&uid=${ms.sendUserId }">查看详情</a>&nbsp;&nbsp;&nbsp;	
				</c:if>				
			</td>
        </tr>
		</c:forEach>	
  </table>
  
   <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
         共${infoCount }条记录 每页显示5条 当前 ${currentPage }/${pageCount } 页  
         <a href='ShowServlet?current=1'>首页</a>
         
         <a 
        	<c:if test="${currentPage>1}">
         		href='ShowServlet?current=${currentPage-1 }&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'
         	</c:if>
         >上一页</a>
         <span class='current'>1</span>
         	<c:if test="${pageCount >=2}">
         		<a href='ShowServlet?current=2&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'>2</a>
        	</c:if>
         	<c:if test="${pageCount >=3}">
         		<a href='ShowServlet?current=3&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'>3</a>
         	</c:if>
         	<c:if test="${pageCount >=4}">
        		 <a href='ShowServlet?current=4&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'>4</a>
         	</c:if>
            <c:if test="${pageCount >=5}">
        		 <a href='ShowServlet?current=5&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'>5</a> 
      		</c:if>
         <a 
         	<c:if test="${currentPage<pageCount }">
         		href='ShowServlet?current=${currentPage+1 }&name=${name}&number=${number }&newDate=${newDate}&endDate=${endDate }'
         	</c:if> 
         >下一页</a>
         <a href='ShowServlet?current=${pageCount }' >尾页</a></div>
		 <div><button type="button" class="btn btn-success" id="newNav">添加</button>
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除</button>
		 <button type="button" class="btn btn-success" id="excel"  onClick="issue();";>导出Excel</button>
		 </div></th></tr>
  </table> 
  
</body>
</html>
