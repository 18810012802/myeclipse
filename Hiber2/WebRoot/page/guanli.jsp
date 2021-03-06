﻿<%@ page language="java" import="java.util.*" import="com.libo.po.Users"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Users u = (Users) request.getSession().getAttribute("user");
	if (u != null)
		request.setAttribute("isAdmin", u.getIsadmin());
	if (request.getParameter("page") == null) {
		request.setAttribute("page", 1);
	}
%>
<HTML>
<HEAD>
<TITLE>理博租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<LINK rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(function() {
		var uid = $(':input[name="uid"]').val();
		$(':input[name="upt_but"]')
				.click(
						function() {
							window.location.href = "SearchHouseServlet?type=toUpdate&id="
									+ uid;
						});
		$(':input[name="del_but"]').click(function() {
			window.location.href = "SearchHouseServlet?type=delete&id=" + uid;
		});
	});
</script>
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
		<DIV class=search>
			<LABEL class="ui-green searchs"><a
				href="SearchHouseServlet?type=toPublish" title="">发布房屋信息</a></LABEL> <LABEL
				class="ui-green"><INPUT
				onclick='document.location="SearchHouseServlet?type=logout"'
				value="退       出" type=button name=search></LABEL>
		</DIV>
	</DIV>
	<DIV class="main wrap">
		<DIV id=houseArea>
			<TABLE class=house-list>
				<TBODY>
					<c:forEach items="${msg }" var="ms">
						<TR>
							<TD class=house-thumb><SPAN><A href="details.htm"
									target="_blank"><img src="images/thumb_house.gif"
										width="100" height="75" alt=""></A></SPAN></TD>
							<TD>
								<DL>
									<DT>
										<A href="SearchHouseServlet?type=details&id=${ms.id }">${ms.title
											}</A>
									</DT>
									<DD>
										${ms.street.district.name }${ms.street.name},${ms.floorage }平米<BR>联系方式：${ms.contact}
									</DD>
								</DL>
							</TD>
							<c:if test="${isAdmin eq '1' }">
								<TD class=house-type><LABEL class=ui-green> <INPUT
										value="修    改" name="upt_but" type="button" /> <INPUT
										value="${ms.id }" type="hidden" name="uid" />
								</LABEL></TD>
								<TD class=house-price><LABEL class=ui-green> <INPUT
										value="删    除" type="button" name="del_but" />
								</LABEL></TD>
							</c:if>
						</TR>
					</c:forEach>
				</TBODY>
			</TABLE>
		</DIV>
		<DIV class=pager>
			<UL>
				<c:forEach var="x" begin="1" end="${count}" step="1">
					<LI class=current><A
						href="SearchHouseServlet?type=guanli&page=${x }&count=${count}">${x
							}</A></LI>
				</c:forEach>
			</UL>
			<SPAN class=total>${page }/${count }页</SPAN>
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
