package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.yetong.MailBoxService;

public class DeleteEmailByIdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mbd=request.getParameter("id");
		if (StringUtils.isEmpty(mbd)) {
			mbd="1";
		}
		int mbid=Integer.valueOf(mbd);
		String reStr=request.getParameter("reStr");
		if (StringUtils.isEmpty(reStr)) {
			reStr="0";
		}
		int re=Integer.valueOf(reStr);
		String eids=request.getParameter("eids");
		MailBoxService mailBoxService=new MailBoxServiceImpl();
		int rows=0;
		PrintWriter out=response.getWriter();
		if (StringUtils.isNotEmpty(eids)) {
			String[] ids=eids.split(",");
			for (String str : ids) {
				mbid=Integer.valueOf(str);
				rows=mailBoxService.deleteById(mbid,re);
			}
		}else {
			
			rows=mailBoxService.deleteById(mbid,re);
		}
		if (rows>0) {
			if (re==0) {
				out.print("<script>location.href='ShowEmailsByLikeServlet?page=1&reStr=0&uid=3';alert('删除成功！');</script>");
			}else {
				out.print("<script>location.href='ShowEmailsByLikeServlet?page=1&reStr=1&uid=1';alert('删除成功！');</script>");	
			}
		}
	}

}