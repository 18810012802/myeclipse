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
public class AddbookServlet extends HttpServlet {
	
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
		String createDate=null;//request.getParameter("createDate");
		String a=request.getParameter("userId");
		int userid=Integer.parseInt(a);
		String name=request.getParameter("name");
		String telephone=request.getParameter("telephone");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int state=0;
		Add_bookService bookService=new Add_bookServiceImpl();
		int rows=bookService.add(userid,name,telephone,sex,birthday,email,address,state);
		if(rows>0){
			out.print("<script>alert('添加成功');location.href='index.jsp';</script>");
		}else{
			out.print("<script>alert('添加失败');location.href='../admin/updateNews.jsp?newid="+userid+"';</script>");
		}

	}}