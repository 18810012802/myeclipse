﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<HTML>
<HEAD>
<TITLE>理博租房 - 发布租房信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<LINK rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/fabu.js"></script>
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新房屋信息发布</DT>
				<DD class=past>填写房屋信息</DD>
			</DL>
			<DIV class=box>
				<FORM id=myform method=post action="SearchHouseServlet"
					action="SearchHouseServlet">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>标 题：</TD>
									<TD><INPUT id=title class=text type=text
										value="${msg.title }" name=title> <input type="hidden"
										name="type" value="publish" /> <input type="hidden"
										name="dis_id" value="${msg.street.district.id }" /> <input
										type="hidden" name="str_id" value="${msg.street.id }" /> <input
										type="hidden" name="house_id" value="${msg.id }" /> <input
										type="hidden" name="types_id" value="${msg.types.id }" /></TD>
								</TR>
								<TR>
									<TD class=field>户 型：</TD>
									<TD><SELECT id="types" class=text name=types></SELECT></TD>
								</TR>
								<TR>
									<TD class=field>面 积：</TD>
									<TD><INPUT id=add_action_floorage class=text type=text
										name=floorage value=${msg.floorage }></TD>
								</TR>
								<TR>
									<TD class=field>价 格：</TD>
									<TD><INPUT id=add_action_price class=text type=text
										name=price value="${msg.price }"></TD>
								</TR>
								<TR>
									<TD class=field>房产证日期：</TD>
									<TD><INPUT class=text type=text name=houseDate
										value="${msg.houseDate }"></TD>
								</TR>
								<TR>
									<TD class=field>位 置：</TD>
									<TD>区：<SELECT id="district_id" class=text name=district>

									</SELECT> 街：<SELECT class=text id="street_id" name=street>
											<!-- <OPTION selected value=1001>中关村大街</OPTION> -->
									</SELECT>
									</TD>
								</TR>
								<TR>
									<TD class=field>联系方式：</TD>
									<TD><INPUT id=add_action_contact class=text type=text
										name=contact value="${msg.contact }"></TD>
								</TR>
								<TR>
									<TD class=field>详细信息：</TD>
									<TD><TEXTAREA name=description>${msg.description}</TEXTAREA></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT value=立即发布 type=submit>
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>理博租房 © 2010 理博软件 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
</HTML>
