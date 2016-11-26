package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.mc.editServiceImpl;
import com.libo.service.mc.editServi;

public class editDelet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		editServi editServi=new editServiceImpl();
		int rows=editServi.dell(id);
		if(rows>0){
			System.out.println(1);
			request.getRequestDispatcher("menuServlet_mc").forward(request, response);
		}

	}

}
