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
</head>
<body>
<form action="editServlet_mc?type=1" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${id}" />
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">资源名称<span style="color:red">*</span></td>
            <td><input type="text" name="realname" value="${name}"/></td>
        </tr>
        <tr>
            <td class="tableleft">url<span style="color:red">*</span></td>
            <td><input type="text" name="url" value="${url}"/></td>
        </tr>
        <c:if test="${state==0 }">
        <tr>
            <td class="tableleft">是否有效</td>
            <td>
                <input type="radio" name="status" value="0" checked/> 有效
              <input type="radio" name="status" value="1" /> 无效
            </td>
        </tr>
        </c:if>
         <c:if test="${state==1 }">
        <tr>
            <td class="tableleft">是否有效</td>
            <td>
                <input type="radio" name="status" value="0" /> 有效
              <input type="radio" name="status" value="1" checked/> 无效
            </td>
        </tr>
        </c:if>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="menuServlet_mc";
		 });
    });
</script>
