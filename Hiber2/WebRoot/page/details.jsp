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
<TITLE>理博租房 - 房屋信息</TITLE>
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
		<DIV class=search>
			<FORM method=get>
				<INPUT class=text type=text name=keywords> <LABEL
					class="ui-green searchs"><a href="###" target="_blank">搜索房屋</a></LABEL>
			</FORM>
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
	<DIV id=position class=wrap>当前位置：理博租房网 - 浏览房源</DIV>
	<DIV id=view class="main wrap">
		<DIV class=intro>
			<DIV class=lefter>
				<H1>${msg.title }</H1>
				<DIV class=subinfo>${msg.pubdate }</DIV>
				<DIV class=houseinfo>
					<P>
						户 型：<SPAN>${msg.types.name }</SPAN>
					</P>
					<P>
						面 积：<SPAN>${msg.floorage }m<SUP>2</SUP></SPAN>
					</P>
					<P>
						位 置：<SPAN>${msg.street.district.name }${msg.street.name }</SPAN>
					</P>
					<P>
						联系方式：<SPAN>${msg.contact }</SPAN>
					</P>
				</DIV>
			</DIV>
			<DIV class=side>
				<P>
					<A class=bold href="###">北京理博房地产经纪有限公司</A>
				</P>
				<P>资质证书：有</P>
				<P>内部编号:1000</P>
				<P>联 系 人：于洋</P>
				<P>
					联系电话：110<SPAN></SPAN>
				</P>
				<P>
					手机号码：<SPAN>暂无</SPAN>
				</P>
			</DIV>
			<DIV class=clear></DIV>
			<DIV class=introduction>
				<H2>
					<SPAN><STRONG>房源详细信息</STRONG></SPAN>
				</H2>
				<DIV class=content>
					<P>${msg.description }</P>
				</DIV>
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
