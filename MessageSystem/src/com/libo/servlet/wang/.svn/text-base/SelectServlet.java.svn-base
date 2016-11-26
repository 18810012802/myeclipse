package com.libo.servlet.wang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Add_bookService;
import com.lib.serviceImpl.Add_bookServiceImpl;
import com.libo.entity.Add_book;

@SuppressWarnings("serial")
public class SelectServlet extends HttpServlet {
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
		int currentPage=1;
		String a=request.getSession().getAttribute("org_id").toString();
		int userId=0;//Integer.parseInt(a);
		String currentString=request.getParameter("current");
		if(currentString!=null){
			currentPage=Integer.parseInt(currentString);
		}
		Add_bookService bookService=new Add_bookServiceImpl();
		//List<Add_book> qu=bookService.query(S);

		List<Add_book> books=bookService.select(currentPage,userId);
		int pageCount=bookService.UserCount();
		request.setAttribute("books", books);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("AddressList/inner.jsp").forward(request, response);

		
		
}}