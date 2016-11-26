<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        $(':checkbox[name="group[]"]').click(function () {
            $(':checkbox', $(this).closest('li')).prop('checked', this.checked);
        });

		$('#backid').click(function(){
				window.location.href="SelectRoleServlet_fan";
		 });

    });
  	 var save= null;
     var title= null;
     var titles= null;
      window.onload=function (){
      save = document.getElementById("save");
      titles = document.getElementById("titles");
      title = document.getElementsByName("title")[0];
      var intervaltd = setInterval(function(){
         title.onmouseout = function(){
         if(title.value==null||title.value==""){
         save.disabled=true;
        titles.innerHTML="名称不能为空！";
         }else{
         save.disabled=false;
         titles.innerHTML="";
         }
      };
      },1000);
      };
</script>
</head>
<body>
<form action="UpdateRoleServlet_fan" method="post" class="definewidth m20" >
<input  type="hidden" value="${orgRole.id }" name="id"/>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">角色名称<span style="color:red">*</span></td>
        <td><input type="text" name="title" value="${orgRole.roleName }"/><span style="color:red" id="titles"></span></td>
    </tr>
    <tr>
        <td class="tableleft">状态<span style="color:red">*</span></td>
        <td>
            <input type="radio" name="status" value="1" <c:if test="${orgRole.state eq 1 }">checked</c:if>/> 启用
           <input type="radio" name="status" value="0" <c:if test="${orgRole.state eq 0 }">checked</c:if> /> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft">权限</td>
        <td>
		      <div class="control-group">
		      <c:forEach items="${listZhu }" var="listZhu" varStatus="i">
                    <label class="control-label"><input value="${listZhu.id }" type="checkbox"  
                     <c:forEach items="${listCha }" var="listCha" varStatus="z">
                    <c:if test="${listCha.id eq listZhu.id }">checked="checked"</c:if>
                     </c:forEach>
                     name="chenk"
                    >${listZhu.menuName }</label>
                     <c:forEach items="${listZi }" var="listZi" varStatus="j">
                     <c:if test="${listZi.menuLevel eq listZhu.id }">
                     
                    <label class="checkbox" for=""><input value="${listZi.id }" type="checkbox" 
                    <c:forEach items="${listCha }" var="listCha" varStatus="z">
                    <c:if test="${listCha.id eq listZi.id }">checked="checked"</c:if>
                     </c:forEach>
                     name="chenk"
                     >${listZi.menuName }<i class=""></i></label>
                   
                    </c:if>
                    </c:forEach>
                      </c:forEach>
                </div>  
                
		</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button" id="save">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>

