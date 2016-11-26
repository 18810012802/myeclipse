<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>约稿信息查看</title>
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
     function downloadFile(){
		 var path=$("#downpath").val();
		 	$.ajax({
						type:"POST",
						url:"PublishServlet",
						data:"type=download&path="+path,
						success:function(msg){
							alert(msg);
							//jAlert(msg,"确定");
						}
					});
		 }
    $(function () {       
		$('#backid').click(function(){
				window.location.href="PublishServlet";
		 });
		 var vari="";
		 $('#td').val( $('#td').val()+vari);
		
		 
    });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">刊物名称</td>
        <td>${msg.name }</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">期号</td>
        <td>${msg.number }</td>
    </tr>
    <tr>
        <td id="td" width="10%" class="tableleft">内容</td>
        <td>
		<pre>
	${msg.content }
		</pre>
		</td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">约稿状态</td>
        <td>${(msg.state eq 0)?'未发布':'已发布' }</td>
    </tr>
	
    <tr>
        <td width="10%" class="tableleft">上报截止时间</td>
        <td>${msg.endDate }</td>
    </tr>
	

	<tr>
        <td width="10%" class="tableleft">附件
        <input id="downpath" type="hidden" value="${msg.path }"/></td>
        <td><a href="javascript:void(0);" onclick="downloadFile();">${msg.attachName }</a></td>
    </tr>
	
	<tr>
       <td width="10%" class="tableleft">发布时间</td>
        <td>${msg.publishTime }</td>
	</tr>
	
	<tr>
       <td width="10%" class="tableleft">发布人</td>
        <td>${msg.sendUserName }</td>
	</tr>
	
    <tr>
        <td colspan="2">
			<center>
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>