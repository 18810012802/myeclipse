<%@page import="com.libo.service.impl.lichao.UserServiceImpl"%>
<%@page import="com.libo.service.lichao.UserService"%>
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
    <script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="listinfo.jsp";
		 });
    });
</script>
</head>
<body>
<form action="IssueServlet"  method="post" enctype="multipart/form-data" class="definewidth m20">
<input type="hidden" name="id" value="{$user.id}" />
<input type="hidden" name="oid" value="<%=session.getAttribute("org_id")%>" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">刊物名称<span style="color:red">*</span></td>
            <td><input type="text" name="name" value="青年文摘"/></td>
        </tr>
        <tr>
            <td class="tableleft">期号<span style="color:red">*</span></td>
            <td><input type="text" name="number" value="201510001"/></td>
        </tr>
        <tr>
            <td class="tableleft">内容<span style="color:red">*</span></td>
            <td><textarea name="content" id="" class="control-row4 input-large">文件上报要求。。。。</textarea></td>
        </tr>
        <tr>
            <td class="tableleft">上报截止时间<span style="color:red">*</span></td>
            <td><input type="text" name="endDate"  value="2015-11-20" /></td>
        </tr>
         <tr>
            <td class="tableleft">发布人</td>
            <td><input type="text" name="email" readonly value="${uname }"/></td>
        </tr>
		<tr>
        <td class="tableleft">状态</td>
            <td>
				<select name="state">
					<option value="0" >未发布</option>
					<option value="1" >已发布</option>
				</select>
			</td>
        </tr>
		
         <tr>
            <td class="tableleft">附件</td>
            <td>
				<input type="file" name="fi"/>
			</td>
        </tr>		
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
