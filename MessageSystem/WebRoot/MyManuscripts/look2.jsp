<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
				window.location.href="filelist.jsp";
		 });
    });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
  <tr>
        <td width="10%" class="tableleft">所属期刊</td>
        <td>
			<select>
				<option>青年文摘201501期</option>
			</select>
		</td>
    </tr>   

   <tr>
        <td width="10%" class="tableleft">写稿人</td>
        <td><input type="text" value="唐杰" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">标题</td>
        <td><input type="text" value="" /></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">类别</td>
        <td><input type="text" value="" /></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">文体</td>
        <td><input type="text" value="" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">内容</td>
        <td> <textarea readonly="readonly" name="" id="" class="control-row4 input-large">
            
        </textarea></td>
    </tr>
	
	    <tr>
        <td width="10%" class="tableleft">附件</td>
        <td> 
            <input type="file"/>
			</td>
    </tr>
	
   <tr>
        <td width="10%" class="tableleft">发稿日期</td>
        <td>2015-07-21</td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">审核通过</button>
                <button type="button" class="btn btn-success" name="backid" id="backid">审核不通过</button>
                <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>
