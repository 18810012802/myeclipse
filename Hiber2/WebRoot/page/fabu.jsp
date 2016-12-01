﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>理博租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<script src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type : 'POST',
		dataType : 'json',
		url : 'SearchHouseServlet',
		data : {
			type : 'types',
		},
		success : function(msg) {
			for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#types").append("<option value="+ms.id+">"+ms.name+"</option>);");
				 var did=$(":input[name='dis_id']").val();
				$("#district_id").val(did);
				var sid=$(":input[name='str_id']").val();
				$.post("SearchHouseServlet",{type:'streetById',id:did},function(result){
					$("#street_id").find("option").remove();
					if(result.length==0){
						$("#street_id").append("<option value="+no+">"+data.name+"</option>");
					}
					for(var i=0;i<result.length;i++){
						var data=result[i];
						
						$("#street_id").append("<option value="+data.id+">"+data.name+"</option>");
					}
					$("#street_id").val(sid);
				},"json");	
				//value="${msg.street.district.id }"
			}
		}
	});
	
	$.post("SearchHouseServlet",{type:'district'},function(msg){
		for(var i=0;i<msg.length;i++){
				var ms=msg[i];
				$("#district_id").append("<option value="+ms.id+">"+ms.name+"</option>);");
			}
	},"json");
	
	$("#district_id").change(function(){
		var val=$(this).val();
		//if(val!='0'){
			$("#street_id").find("option").remove();
			$.post("SearchHouseServlet",{type:'streetById',id:val},function(result){
				for(var i=0;i<result.length;i++){
					var data=result[i];
					$("#street_id").append("<option value="+data.id+">"+data.name+"</option>");
				}
			},"json");			
			
	}); 
	});
</script>
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post action="SearchHouseServlet" 
action="SearchHouseServlet">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=title class=text type=text value="${msg.title }" name=title> 
    <input type="hidden" name="type" value="publish"/>
    <input type="hidden" name="dis_id" value="${msg.street.district.id }"/>
    <input type="hidden" name="str_id" value="${msg.street.id }"/>
    <input type="hidden" name="house_id" value="${msg.id }"/>
    </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT id="types" class=text name=types value=${msg.types.id }></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage value=${msg.floorage }></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${msg.price }"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=text name=houseDate value="${msg.houseDate }"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT id="district_id" class=text name=district >
    
    </SELECT> 街：<SELECT class=text id="street_id"
        name=street><!-- <OPTION selected value=1001>中关村大街</OPTION> --></SELECT> </TD></TR><!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${msg.contact }"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description >${msg.description}</TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT value=立即发布 type=submit> 
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>理博租房 © 2010 理博软件 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
