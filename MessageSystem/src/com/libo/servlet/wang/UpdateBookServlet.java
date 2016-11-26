package com.libo.servlet.wang;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Add_bookService;
import com.lib.serviceImpl.Add_bookServiceImpl;
import com.libo.entity.Add_book;

@SuppressWarnings("serial")
public class UpdateBookServlet extends HttpServlet {
	
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
		//String createDate=request.getParameter("createDate");
		int id=Integer.parseInt(request.getParameter("userId"));
		Add_bookService bookService=new Add_bookServiceImpl();
        Add_book book=bookService.selectById(id);
        request.setAttribute("name", book.getName());
		request.setAttribute("telphone", book.getTelphone());
		request.setAttribute("sex", book.getSex());
		request.setAttribute("birthday", book.getBirthday());
		request.setAttribute("address", book.getAddress());
		request.setAttribute("email",book.getEmail());
		
		String a=request.getSession().getAttribute("org_id").toString();
		int userid=Integer.parseInt(a);
		String name=request.getParameter("name");
		String telephone=request.getParameter("tel");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int state=0;
		int rows=bookService.updateById(userid,name,telephone,sex,birthday,email,address,state);
		if(rows>0){
			out.print("<script>alert('更改成功');location.href='index.jsp';</script>");
		}else{
			out.print("<script>alert('更改失败');location.href='index.jsp';</script>");
		}
	}}