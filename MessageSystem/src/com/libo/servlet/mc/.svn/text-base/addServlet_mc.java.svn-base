package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.mc.addServiceImpl;
import com.libo.service.mc.addService;

public class addServlet_mc extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("username");
		String url=request.getParameter("url");
		int state=Integer.parseInt(request.getParameter("status"));
		addService addService=new addServiceImpl();
		int rows=addService.addMenu(name, url, state);
		if(rows>0){
			response.getWriter().write("<script>alert('添加成功');if(confirm('还要加吗?')){location.href='Resource/add.jsp'}else{location.href='menuServlet_mc'}</script>");
		}else{
			response.getWriter().write("<script>alert('添加失败');location.href='Resource/add.jsp'</script>");
		}
		
	}

}
