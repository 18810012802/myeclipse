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
<TITLE>理博租房 - 用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<LINK rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="easyui\jquery.easyui.min.js"></script>
<script src="easyui\locale\easyui-lang-zh_CN.js"></script>
<script src="js/regs.js"></script>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新用户注册</DT>
				<DD class=past>填写个人信息</DD>
			</DL>
			<DIV class=box>
				<FORM action=SearchHouseServlet id=myform method="post">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>用 户 名：</TD>
									<TD><INPUT class=text type=text name=name> <INPUT
										class=text type=hidden name=type value=regs></TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD><INPUT class=text type=password name=password></TD>
								</TR>
								<TR>
									<TD class=field>确认密码：</TD>
									<TD><INPUT class=text type=password name=repassword>
									</TD>
								</TR>
								<TR>
									<TD class=field>电 话：</TD>
									<TD><INPUT class=text type=text name=telephone></TD>
								</TR>
								<TR>
									<TD class=field>用户姓名：</TD>
									<TD><INPUT class=text type=text name=username></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT value=立即注册 type=submit>
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
