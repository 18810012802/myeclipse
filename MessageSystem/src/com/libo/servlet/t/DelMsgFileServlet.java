package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.Msg_fileService;
import com.libo.service.impl.t.Msg_fileServiceImpl;

public class DelMsgFileServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		Msg_fileService m=new Msg_fileServiceImpl();
		String deid=request.getParameter("delid");
		int did=0;
		if(deid!=null){
			did=Integer.parseInt(deid);
		}
		int rows=m.delSPart(did);
		if(rows>0){
			out.print("<script>alert('É¾³ý³É¹¦!');location.href='FilelistServlet';</script>");
		}else{
			out.print("<script>alert('É¾³ýÊ§°Ü!');location.href='FileListServlet';</script>");
		}
		
	}

}
