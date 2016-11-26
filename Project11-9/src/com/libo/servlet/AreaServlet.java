package com.libo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.AreaService;
import com.libo.service.impl.AreaServiceImpl;

public class AreaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
			}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int pid=Integer.parseInt(request.getParameter("pid"));
		AreaService ar=new AreaServiceImpl();
		response.getWriter().write(ar.selectArea(pid));
	}

}
