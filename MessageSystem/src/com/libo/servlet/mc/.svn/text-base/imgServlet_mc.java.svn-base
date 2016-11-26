package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.dao.impl.mc.loginDaoImpl;
import com.libo.dao.mc.loginDao;

public class imgServlet_mc extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		loginDao dao=new loginDaoImpl();
		String src=dao.selByName(name).getPhoto();
		System.out.println(src);
		response.getWriter().write(src);
	}

}
