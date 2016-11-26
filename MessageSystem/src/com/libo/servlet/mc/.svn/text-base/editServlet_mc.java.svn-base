package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.mc.editServiceImpl;
import com.libo.service.mc.editServi;

public class editServlet_mc extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String type=request.getParameter("type");
		if(type!=null){
			editMenu( request, response);
		}else{
		String  id=request.getParameter("id");
		String name=request.getParameter("name");
		String url=request.getParameter("url");
		String state=request.getParameter("state");
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("url", url);
		request.setAttribute("state", state);
		request.getRequestDispatcher("Resource/edit.jsp").forward(request, response);
		}
	}
	public void editMenu(HttpServletRequest request, HttpServletResponse response){
		editServi editServi=new editServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		String newname=request.getParameter("realname");
		String url=request.getParameter("url");
		int state=Integer.parseInt(request.getParameter("status"));
		int rows=editServi.editMenu(newname, url, state, id);
		try {
			request.getRequestDispatcher("menuServlet_mc").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
