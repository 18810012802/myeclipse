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
    <title>查看--理博软件--2016</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
     <script type="text/javascript" src="Js/modal.js"></script>
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
				document.forms[0].action="AddFileServlet?chose=chose";
				document.forms[0].submit();
		 });
    });
    </script>
</head>
<body>
<c:forEach items="${file }" var="file">
<form action="AddFileServlet?chose=cha&fid=${file.id }" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">标题<span style="color:red">*</span></td>
        <td><input type="text" name="title" value="${file.title }" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">作者<span style="color:red">*</span></td>
        <td><input type="text" name="author" value="${file.author }" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">来源<span style="color:red">*</span></td>
        <td><input type="text" name="from" value="${file.from }" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">类别<span style="color:red">*</span></td>
        <td>
		<select name="type" value="${file.type }">
			<option value="文学">文学</option>
			<option value="奇幻">奇幻</option>
			<option value="军旅">军旅</option>
			<option value="历史">历史</option>			
			<option value="言情">言情</option>
			<option value="奇幻">玄幻</option>
			<option value="其它">其它</option>
			
		</select>
		</td>
    </tr>
    
	<tr>
        <td width="10%" class="tableleft">文体<span style="color:red">*</span></td>
        <td><select name="filetype" value="${file.filetype }">
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
        <td width="10%" class="tableleft">稿件内容</td>
        <td> <textarea name="content" id="content" class="control-row4 input-large">
            ${file.content }
            
        </textarea></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">选择约稿信息</td>
        <td>
            <select name="msg" id="msgid">
        <c:forEach items="${msg }" var="mm">
                <option value="${mm.id }">${mm.name }</option>
        </c:forEach>
            </select>
            <span style="color:red">选择约稿信息后，将直接提采编人管审核</span>
        </td>
    </tr>
    <tr>
        <td colspan="2">
			<center>

				<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"  name="backid" id="backid">提交</button>
                <button type="submit" class="btn btn-success" name="backid">保存</button>
			</center>
		</td>
    </tr>
</table>
</form>
</c:forEach>
</body>
</html>
