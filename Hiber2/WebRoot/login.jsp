<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<HTML>
<HEAD>
<TITLE>理博租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<LINK rel="stylesheet" type="text/css" href="css/style.css" />
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
			<DIV class=box>
				<H4>用户登录</H4>
				<FORM id="user" method="post" name="user"
					action="SearchHouseServlet?type=login">
					<DIV class="infos">
						<TABLE class="field">
							<TBODY>
								<TR>
									<TD colSpan=2></TD>
								</TR>
								<TR>
									<TD class="field">用 户 名：</TD>
									<TD>
										<!-- <input type="text" class="text" name="name" /> -->
										<INPUT id="name" class="text" type="text" name="name">
									</TD>
								</TR>
								<TR>
									<TD class="field">密 码：</TD>
									<TD>
										<!-- <input type="password" class="text" name="passwd" /> -->
										<INPUT id="passwd" class="text" type="password"
										name="password">
									</TD>
								</TR>
								<!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						-->
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT type="submit" value="登陆 " /> <INPUT
								onclick='document.location="SearchHouseServlet?type=goToRegs"'
								value=注册 type=button>
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
