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
    <title>上报稿件</title>
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
    $(function () {       
		$('#backid').click(function(){
				window.location.href="MyFileMsgServlet";
		 });
    });
    </script>
</head>
<body>
<c:forEach items="${msg }" var="ms">
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
  <tr>
        <td width="10%" class="tableleft">所属期刊</td>
        <td>
			<select>
				<option>${pmtitle }</option>
			</select>
		</td>
    </tr>   

   <tr>
        <td width="10%" class="tableleft">上报人</td>
        <td><input type="text" value="${ms.orgem.username }"  readonly /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">标题</td>
        <td><input type="text" value="${ms.title }" /></td>
    </tr>
	
	<tr>
        <td width="10%" class="tableleft">作者</td>
        <td><input type="text" value="${ms.author }" /></td>
    </tr>
	
    <tr>
        <td width="10%" class="tableleft">类别</td>
        <td>
		<select name="type" value="${ms.type }">
			<option>文学</option>
			<option>奇幻</option>
			<option>军旅</option>
			<option>历史</option>			
			<option>言情</option>
			<option>玄幻</option>
			<option>其它</option>
			
		</select>
		</td>
    </tr>
    
	<tr>
        <td width="10%" class="tableleft">文体</td>
        <td><select name="filetype" value="${ms.filetype }">
			<option>记述文 </option>
			<option>说明文 </option>
			<option>议论文 </option>
			<option>应用文 </option>
			<option>诗歌 </option>
			<option>赋</option>			
			<option>词 </option>
			<option>小说 </option>
			<option>散文 </option>
			<option>其它</option>
		</select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">内容</td>
        <td> <textarea  name="" id="" class="control-row4 input-large">
            ${ms.content }
        </textarea></td>
    </tr>
	
	<tr>
        <td width="10%" class="tableleft">附件</td>
        <td> 
            <c:if test="${name==null }">
     			       没有上传文件
            </c:if>
            <c:if test="${name!=null }">
            <a href="">${name }</a>
            </c:if>
			</td>
    </tr>
	
   <tr>
        <td width="10%" class="tableleft">上报日期</td>
        <td>${ms.sendDate }</td>
    </tr>
    <tr>
        <td colspan="2">
			<center>	
                <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
			</center>
		</td>
    </tr>
</table>
</form>
</c:forEach>
</body>
</html>
