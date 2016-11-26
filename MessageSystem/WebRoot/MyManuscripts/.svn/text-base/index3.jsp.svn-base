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
    <title>理博软件--2016</title>
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
						window.location.href="daoChu?type=3&id="+id;
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
				window.location.href="daoChu?type=3&id="+id;
	}else{
		alert("请选中要操作的项");
	}
}
    </script>
</head>
<body>

<form action="MyFileMsgServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">文件名称：</td>
        <td><input type="text" name="title" value=""/></td>
        <td width="10%" class="tableleft">作者：</td>
        <td><input type="text" name="author" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所属刊物：</td>
        <td><input type="text" name="nam" value=""/></td>

        <td width="10%" class="tableleft">期号：</td>
        <td><input type="text" name="number" value=""/></td>
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
        <th>文件标题</th>
        <th>作者</th>
        <th>类型</th>
        <th>文体</th>
        <th>上报时间</th>

        <th>刊物名称</th>
        <th>期号</th>

        <th>审核状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${ms }" var="ms">
	   <tr >
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="${ms.id }"></td>
            <td style="vertical-align:middle;">${ms.title }</td>
            <td style="vertical-align:middle;">${ms.author }</td>
            <td style="vertical-align:middle;">${ms.type }</td>
            <td style="vertical-align:middle;">${ms.filetype }</td>
            <td style="vertical-align:middle;">${ms.sendDate}</td>  
            <td style="vertical-align:middle;">${ms.msgman.name }</td>  
            <td style="vertical-align:middle;">${ms.msgman.number }</td>  
            <td>
            <c:if test="${ms.state==0 }"> 
					审核中
				</c:if>
            <c:if test="${ms.state==1 }"> 
					审核通过
				</c:if>
			<c:if test="${ms.state==2 }"> 
					审核未通过
				</c:if>
			<c:if test="${ms.state==3 }"> 
					审核通过
				</c:if>
            </td>
	    <td style="vertical-align:middle;">
	    <c:if test="${ms.state==0 }"> 
	    <a href="MyFileMsgLookServlet?mid=${ms.id }&ptitle=${ms.msgman.name }&pid=${ms.msgman.id }">查看详情</a>
				</c:if>
		<c:if test="${ms.state==1 }"> 
	    <a href="MyFileMsgLookServlet?mid=${ms.id }&ptitle=${ms.msgman.name }&pid=${ms.msgman.id }">查看详情</a>
				</c:if>
		<c:if test="${ms.state==3 }"> 
	    <a href="MyFileMsgLookServlet?mid=${ms.id }&ptitle=${ms.msgman.name }&pid=${ms.msgman.id }">查看详情</a>
				</c:if>
		<c:if test="${ms.state==2 }"> 
		<a href="MyFileMsgLookServlet?mid=${ms.id }&ptitle=${ms.msgman.name }&pid=${ms.msgman.id }">查看详情</a>
	    <a href="MyFileUpdaServlet?chose=cho&mid=${ms.id }">再上报</a>
				</c:if>
	    </td>
        </tr>
        </c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
	 共${coun }条记录 每页显示2条 当前 ${currPage }/${pagecount } 页
          <a href="MyFileMsgServlet?current=1&name=${pname }&number=${pnum }&title=${ptitle }&author=${pauthor }">首页</a>&nbsp;&nbsp;&nbsp;
              <a 
				<c:if test="${currPage>1 }">
              href="MyFileMsgServlet?current=${currPage-1 }&name=${pname }&number=${pnum }&title=${ptitle }&author=${pauthor }" 
              </c:if>
              >上一页</a>
              &nbsp;&nbsp;&nbsp;
          			<a 
				<c:if test="${currPage<pagecount }">
          			href="MyFileMsgServlet?current=${currPage+1 }&name=${pname }&number=${pnum }&title=${ptitle }&author=${pauthor }"
          			</c:if>
          			>
				下一页</a>&nbsp;&nbsp;&nbsp;
          <a href="MyFileMsgServlet?current=${pagecount }&name=${pname }&number=${pnum }&title=${ptitle }&author=${pauthor }">尾页</a>&nbsp;&nbsp;&nbsp;

          </div>
		 <div>
         <button type="button" class="btn btn-success" onclick="daoChu()">导出Excel</button>
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
</html>
