package com.libo.servlet.wang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Add_bookService;
import com.lib.serviceImpl.Add_bookServiceImpl;

@SuppressWarnings("serial")
public class DeleteBookServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		Add_bookService bookService=new Add_bookServiceImpl();
		int rows=bookService.deleteById(id);
		if(rows>0){
			out.print("<script>alert('É¾³ý³É¹¦');location.href='AddressList/index.jsp';</script>");
		}else{
			out.print("<script>alert('É¾³ýÊ§°Ü');location.href='AddressList/index.jsp;</script>");
		}

	}}	