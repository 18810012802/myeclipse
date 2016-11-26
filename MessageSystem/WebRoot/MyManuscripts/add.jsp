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
				window.location.href="MyFileMesTwoServlet";
		 });
    });

    </script>
</head>
<body>
        <c:forEach items="${msg }" var="ms">
<form action="MyFileUpServlet?chose=chose&mid=${ms.id }&userid=<%=session.getAttribute("org_id") %>" method="post" enctype="multipart/form-data" class="definewidth m20" >
<table class="table table-bordered table-hover definewidth m10">
  <tr>
        <td width="10%" class="tableleft">所属期刊</td>
        <td>
			<select name="namenu" value="${ms.number }">
				<option value="${ms.number }">${ms.name }${ms.number }期</option>
			</select>
		</td>
    </tr>   
   <tr>
   <c:forEach items="${ore }" var="o">
        <td width="10%" class="tableleft">上报人</td>
        <td><input type="text" name="username" value="${o.loginname }"  readonly /></td>
       </c:forEach>
    </tr>
    <tr>
        <td width="10%" class="tableleft">标题</td>
        <td><input type="text" name="title" value=".." /></td>
    </tr>
	
	<tr>
	<c:forEach items="${ore }" var="o">
        <td width="10%" class="tableleft">作者</td>
        <td><input type="text" name="author" value="${o.username }" /></td>
        </c:forEach>
    </tr>
	<tr>
        <td width="10%" class="tableleft">来源</td>
        <td><input type="text" name="from" value=".." /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">类别</td>
        <td>
		<select name="type">
			<option value="文学">文学</option>
			<option value="奇幻">奇幻</option>
			<option value="军旅">军旅</option>
			<option value="历史">历史</option>			
			<option value="言情">言情</option>
			<option value="玄幻">玄幻</option>
			<option value="其它">其它</option>
		</select>
		</td>
    </tr>
    
	<tr>
        <td width="10%" class="tableleft">文体</td>
        <td><select name="filetype">
			<option value="记述文">记述文 </option>
			<option value="说明文">说明文 </option>
			<option value="议论文">议论文 </option>
			<option value="应用文">应用文 </option>
			<option value="诗歌">诗歌 </option>
			<option value="赋"> 赋</option>			
			<option value="词">词 </option>
			<option value="小说">小说 </option>
			<option value="散文">散文 </option>
			<option value="其它">其它</option>
		</select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">内容</td>
        <td> <textarea  name="content" id="" class="control-row4 input-large">
            文件内容详见附件
        </textarea></td>
    </tr>
	
	<tr>
        <td width="10%" class="tableleft">附件</td>
        <td> 
            <input type="file" name="file" />
			</td>
    </tr>
	
   <tr>
        <td width="10%" class="tableleft">上报日期</td>
        <td id="shows">${date }</td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-success" name="backid">保存提交</button>
                <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
			</center>
		</td>
    </tr>
</table>
</form>
			</c:forEach>
</body>
</html>
