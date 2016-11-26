<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>添加医生--理博软件--2016</title>
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
				window.location.href="index.jsp";
		 });
    });
    var name = document.getElementById("name");
	var email = document.getElementById("email");
	var tel = document.getElementById("telephone");
	function checkinfo() {
			var ajax = new XMLHttpRequest();
			var tela=/^[0-9]{11}$/;
			var emaila=/^\w{5,20}@\w{2,5}\.\w{2,5}$/;
			ajax.open('post', 'CheckinfoServlet' );
			ajax.send();
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {
					var text = ajax.responseText;
					if(name.value==null){
						document.getElementById("msg1").innerHTML = text;
					}if(tela.test(tel.value)==false||tel.value==null){
						document.getElementById("msg2").innerHTML = text;
					}
					if(emaila.test(email.value)==false){
						document.getElementById("msg3").innerHTML = text;
					}
					}
					}
				
			
	}
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="pname" id="name" value=""/></td><span id="msg1"></span>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电话号码</td>
        <td><input type="text" name="pname" id="telephone" value=""/></td>	<span id="msg2"></span>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="pname" id="sex" value="" checked/>男&nbsp;&nbsp;&nbsp;<input type="radio" name="pname" value=""/>女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
        <td><input type="text" name="pname" id="birthday" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td><input type="text" name="pname" id="email" value=""/></td><span id="msg3"></span>
    </tr>
    <tr>
        <td width="10%" class="tableleft">地址</td>
        <td><input type="text" name="pname" id="address" value=""/></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">日期</td>
        <td><input type="text" name="pname" id="createDate" value=""/></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button" onclick=""><a href="AddbookServlet?userId=3">保存</a></button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid"><a href="innerServlet?type=personal">返回列表</a></button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>
