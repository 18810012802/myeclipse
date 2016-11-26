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
    
    <title>发件箱</title>
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
				window.location.href="ExcelSendEmailServlet";
				
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
			/* var ids=new Array(); */
			var arr="";
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
				arr+=alls[i].value+",";
				}		
			}
			location.href='DeleteEmailByIdServlet?ids='+arr;
			/*for(var i=0;i<alls.length;i++){
			 alert(alls[i].checked);
				if(alls[i].checked){
				location.href='deletemailbox?id='+alls[i].value;
					ids.push(alls[i].value);
				}		
			} */
			/* if(ids.length>0){
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			} */
		}
    </script>
</head>
<body>

<form action="ShowEmailsByLikeServlet" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
 
    <tr>
        <td width="10%" class="tableleft">搜索条件：</td>
        <td> <select name="tiao" id="tiao">
        <option value="title"
        <c:if test="${tiao=='title' }">
        selected
        </c:if>
        >标题</option>
        <option value="content"
        <c:if test="${tiao=='content' }">
        selected
        </c:if>
        >内容</option>
        <option value="receiveuserid"
        <c:if test="${tiao=='receiveuserid' }">
        selected
        </c:if>
        >收件人</option>
       <%-- <c:forEach items="${list }" var="list" varStatus="status">
            <option value="">${list.title }</option>
        </c:forEach> --%>
            </select>
        </td>
        <td width="10%" class="tableleft">关键字：</td>
        <td><input type="text" name="pname" value="${pname }"/></td>
		
        <td width="10%" class="tableleft">排序：</td>
        <td>
             <select name="order" id="order">           
             <option value="id"
        <c:if test="${order=='id' }">
        selected
        </c:if>
        >序号</option> 
        	<option value="title"
        <c:if test="${order=='title' }">
        selected
        </c:if>
        >标题</option>
             <option value="senddate"
        <c:if test="${order=='senddate' }">
        selected
        </c:if>
        >发送时间</option>   
      <%--  <c:forEach items="${list }" var="list" varStatus="status">
            <option value="">${list.senddate }</option>
            </c:forEach> --%>
            </select>
        </td>
        
    </tr>
    <tr>
		  <td colspan="6"><center>
		  	
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="reset" class="btn btn-primary" type="button">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>序号</th>
        <th>标题</th>
        <th>内容</th>
        <th>收件人</th>
        <th>发送时间</th>
        <th>操作</th>
    </tr>
    </thead>
	     <c:forEach items="${list }" var="list"  varStatus="status">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${list.id }" ></td>
            <td style="vertical-align:middle;">${status.count+10*(currentpage-1) }</td>
            <td style="vertical-align:middle;">${list.title }</td>
            <td style="vertical-align:middle;">${list.content }</td>
            <td style="vertical-align:middle;"><c:forEach items="${rlist }" var="r">
            	<c:if test="${list.receiveuserid==r.id }">
            		${r.username }
            	</c:if>
            </c:forEach></td>
            <td>${list.senddate }</td>
            <td style="vertical-align:middle;"><a href="ShowEmailInfoServlet?type=look&tar=give&id=${list.id }">详情>>></a>&nbsp;&nbsp;&nbsp;<a href="DeleteEmailByIdServlet?id=${list.id }">删除</a></td>
        </tr>
            </c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<%-- <tr><th colspan="5">  
  		<div class="inline pull-right page">
          <a href='#' >第一页</a> <a href='#'>上一页</a>  <span class='current'>1</span><a href='#'>2</a><a href='/chinapost/index.php?m=Label&a=index&p=3'>3</a><a href='#'>4</a><a href='#'>5</a>  <a href='#' >下一页</a> <a href='#' >最后一页</a>
		  &nbsp;&nbsp;&nbsp;共<span class='current'>${count }</span>条记录<span class='current'> 1/33 </span>页
		  </div>
		 <!--  <div><input type="button" class="btn btn-success" onclick="delAll()" id="newNav" value="删除"> -->
		 <div><button type="button" class="btn btn-success" onclick="delAll()" id="newNav">删除</button> 
		 <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
		 </div>
		 
		 </th></tr> --%>
		 <tr><th colspan="5">  <div class="inline pull-right page">
                       共${count }条记录 每页显示${pagesize }条 当前 ${currentpage }/${totalpage }页  
         <a href='ShowEmailsByLikeServlet?currentpage=1&tiao=${tiao }&pname=${pname }&order=${order }'>首页</a>
         	<c:if test="${currentpage>1 }">
         
         <a 
         href='ShowEmailsByLikeServlet?currentpage=${currentpage-1 }&tiao=${tiao }&pname=${pname }&order=${order }'
         >上一页</a>
           </c:if>
         <c:if test="${currentpage>3&&totalpage>5 }">
         		...
         </c:if>
         <c:if test="${currentpage<=3 }">
         	<c:if test="${currentpage==1 }">
         	<span class='current'>1</span>
         	</c:if>
         	<c:if test="${totalpage>=1&&currentpage!=1 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=1&'>1</a>
         	</c:if>
         	<c:if test="${currentpage==2 }">
         	<span class='current'>2</span>
         	</c:if>
         	<c:if test="${totalpage>=2&&currentpage!=2 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=2&'>2</a>
         	</c:if>
         	<c:if test="${currentpage==3 }">
         	<span class='current'>3</span>
         	</c:if>         	
         	<c:if test="${totalpage>=3&&currentpage!=3 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=3&'>3</a>
         	</c:if>
         	<c:if test="${totalpage>=4 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=4&'>4</a>
         	</c:if>
         	<c:if test="${totalpage>=5 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=5&'>5</a>
         	</c:if>
         </c:if>
         <c:if test="${currentpage>3&&(totalpage-currentpage)>=2 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-2 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-2 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-1 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-1 }</a>
         	<span class='current'>${currentpage}</span>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage+1 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage+1 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage+2 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage+2 }</a>
         </c:if>         
         <c:if test="${currentpage>3&&(totalpage-currentpage)==1 }">
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-3 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-3 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-2 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-2 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-1 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-1 }</a>
         	<span class='current'>${currentpage}</span>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage+1 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage+1 }</a>
         </c:if>         
         <c:if test="${currentpage>3&&totalpage==currentpage }">
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-3 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-3 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-2 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-2 }</a>
         	<a href='ShowEmailsByLikeServlet?currentpage=${currentpage-1 }&tiao=${tiao }&pname=${pname }&order=${order }'>${currentpage-1 }</a>
         	<span class='current'>${currentpage}</span>
         </c:if>
         <c:if test="${totalpage>5&&(totalpage-currentpage)>2 }">
         		...
         </c:if> 
         	<c:if test="${currentpage<totalpage}">
         <a 
        		 href='ShowEmailsByLikeServlet?currentpage=${currentpage+1 }&tiao=${tiao }&pname=${pname }&order=${order }' 
         >下一页</a> 
         	</c:if>
         <a href='ShowEmailsByLikeServlet?currentpage=${totalpage}&tiao=${tiao }&pname=${pname }&order=${order }'>尾页</a></div>
		 <div><button type="button" class="btn btn-success" id="delPro" onclick="delAll();">删除</button>
		 <button type="button" class="btn btn-success" id="newNav">导出Excel</button>
		 </div></th></tr>
  </table>
  
</body>
</html>
