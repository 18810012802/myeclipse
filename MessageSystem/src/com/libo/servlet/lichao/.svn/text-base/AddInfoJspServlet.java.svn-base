package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.lichao.UserServiceImpl;
import com.libo.service.lichao.UserService;

public class AddInfoJspServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int oid =Integer.parseInt(request.getParameter("oid"));
		UserService us=new UserServiceImpl();
		String uname=us.SelectUserName(oid);
		request.setAttribute("uname", uname);
		request.getRequestDispatcher("Manuscripts/addinfo.jsp").forward(request, response);
	}

}
