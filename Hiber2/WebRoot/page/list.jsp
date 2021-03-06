﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	if (request.getParameter("page") == null) {
		request.setAttribute("page", 1);
	}
%>

<HTML>
<HEAD>
<TITLE>理博租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv="Content-Type">
<LINK rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/search.js"></script>

<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>

	<DIV id=navbar class=wrap>
		<FORM id=sform method=post action="SearchHouseServlet">
			<DL class="search clearfix">
				<DT>
					<UL>
						<LI class=bold>房屋信息</LI>
						<LI>标题：<INPUT class=text type=text name="title"> <LABEL
							class=ui-blue><INPUT value=搜索房屋 type=submit name=search></LABEL>
							<input type="hidden" name="type" value="list" /></LI>
					</UL>
				</DT>
				<DD>
					<UL>
						<LI class=first>价格</LI>
						<LI><SELECT id=price name=price>
								<OPTION selected value="">不限</OPTION>
								<OPTION value=0-100>100元以下</OPTION>
								<OPTION value=100-200>100元—200元</OPTION>
								<OPTION value=200-1000000>200元以上</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>房屋位置</LI>
						<LI><SELECT id=street name=street>
								<OPTION selected value="">不限</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>房型</LI>
						<LI><SELECT id=housetype name=housetype>
								<OPTION selected value="">不限</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>面积</LI>
						<LI><SELECT id=floorage name=floorage>
								<OPTION selected value="">不限</OPTION>
								<OPTION value=0-40>40以下</OPTION>
								<OPTION value=40-500>40-500</OPTION>
								<OPTION value=500-1000000>500以上</OPTION>
						</SELECT></LI>
					</UL>
				</DD>

			</DL>
		</FORM>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>
				<c:forEach items="${msg }" var="ms">
					<TR>
						<TD class=house-thumb><span><A href="details.htm"><img
									src="images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
						<TD>
							<DL>
								<DT>
									<A href="SearchHouseServlet?type=details&id=${ms.id }">${ms.title
										}</A>
								</DT>
								<DD>
									${ms.street.district.name }${ms.street.name },${ms.floorage }平米<BR>联系方式：${ms.contact
									}
								</DD>
							</DL>
						</TD>
						<TD class=house-type>${ms.types.name }</TD>
						<TD class=house-price><SPAN>${ms.price }</SPAN>元/月</TD>
					</TR>
				</c:forEach>
				<c:if test="${count eq 0 }">
					<TR><td>无租房信息</td>
					</TR>
				</c:if>
			</TBODY>
		</TABLE>
		<DIV class=pager>
			<UL>
				<LI class=current><A
					href="SearchHouseServlet?type=list&page=1&price=${price}&housetype=${housetype}&floorage=${floorage}&street=${street}&title=${title}">首页</A></LI>
				<LI><A
					href="SearchHouseServlet?type=list&page=${(page>0)?page-1:page}&price=${price}&housetype=${housetype}&floorage=${floorage}&street=${street}&title=${title}"><c:if
							test="${page ne 1}">
          	上一页	</c:if></A></LI>
				<LI><A
					href="SearchHouseServlet?type=list&page=${(count>page)?page+1:count }&price=${price}&housetype=${housetype}&floorage=${floorage}&street=${street}&title=${title}"><c:if
							test="${page ne count}">下一页</c:if></A></LI>
				<LI><A
					href="SearchHouseServlet?type=list&page=${count }&price=${price}&housetype=${housetype}&floorage=${floorage}&street=${street}&title=${title}">末页</A></LI>
			</UL>
			<SPAN class=total>${page }/${count }页</SPAN>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>理博租房 © 2010 理博租房 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
</HTML>
