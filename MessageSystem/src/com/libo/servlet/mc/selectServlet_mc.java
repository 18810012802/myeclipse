package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.mc.loginServiceImpl;
import com.libo.service.mc.loginService;

public class selectServlet_mc extends HttpServlet {

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
			int oid=Integer.parseInt(request.getParameter("oid"));
			loginService loginService=new loginServiceImpl();
			String config=loginService.selectMenu(oid);
			out.write(config.toString());
	}

}
