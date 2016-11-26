package com.libo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String code=request.getParameter("code").toLowerCase();
		String rand=(String)request.getSession().getAttribute("rand"); 
		if(code.equals(rand)){
			response.getWriter().write("<font color='green'>验证码正确！</font>");
		}else{
			response.getWriter().write("<font color='red'>验证码错误！</font>");
		}
		
	}

}
