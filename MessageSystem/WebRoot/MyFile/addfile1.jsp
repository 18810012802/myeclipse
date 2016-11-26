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
<form action="AddFileServlet?chose=cha" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">标题<span style="color:red">*</span></td>
        <td><input type="text" name="title" value="在理博软件的日子" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">作者<span style="color:red">*</span></td>
        <td><input type="text" name="author" value="Bin.Huang" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">来源<span style="color:red">*</span></td>
        <td><input type="text" name="from" value="网络" /></td>
    </tr>

<tr>
        <td width="10%" class="tableleft">类别<span style="color:red">*</span></td>
        <td>
		<select name="type" value="文学">
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
        <td><select name="filetype" value="记述文">
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
            《银河》期刊是中共敖汉旗委宣传部、敖汉旗文学艺术界联合会主办并编辑出版的。《银河》杂志创刊于2006年，作为一本公开发行的本土文学杂志，银河以展现敖汉乡土文学、展示敖汉民间艺术、展露敖汉文艺成就为办刊理念，以推出文艺新作、培养和扶植文学人才、繁荣和发展文艺事业为己任，诚挚欢迎广大作家和文学艺术爱好者投稿。
　　1、体裁主要以小说、诗歌、散文、书法绘画、摄影作品为主。
　　2、本杂志收稿作品将进行严格的审核，所有稿件皆需作者的原创作品，抄袭或间接利用别人作品投稿的不予使用，对于涉及版权问题的情况将诉诸法律途径解决。
　　3、来稿文责自负，请自留底稿，本刊不予退稿。依照《著作权法》有关规定，本刊拥有删改权，如不同意请注明。
　　4、.为保证稿件的刊发进度，投稿前请作者们核对自己文章中的标点符号和明显的错别字，进行简单的校正。 
　　5、投稿请在主题栏以“姓名+投稿栏目+文章名称”格式标明，并附带简单的个人简介和联系地址，以便我们寄送样刊，并与您随时取得联系。
　　6、投稿以电子版为宜，投稿邮箱：ahxcbxl@163.com
　　联系电话：4321248
            
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
</body>
</html>
