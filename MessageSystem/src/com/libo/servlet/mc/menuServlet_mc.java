package com.libo.servlet.mc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Sys_menu;
import com.libo.service.impl.mc.menuServiceImpl;
import com.libo.service.mc.menuService;
import com.libo.util.PageSize;

public class menuServlet_mc extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int current=1;
				if(request.getParameter("current")!=null){
					current=Integer.parseInt(request.getParameter("current"));
				}
			int page=1;

			if(current>1){
				page=current;
			}
			menuService menuService=new menuServiceImpl();
			int pageSize=PageSize.PAGE_SIZE;
			String name=request.getParameter("username");
			int pagelon=menuService.query(name)/pageSize;
			List<Sys_menu> list=new ArrayList<Sys_menu>();
			list=menuService.query(name,page,PageSize.PAGE_SIZE);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pagelon", pagelon);
			request.setAttribute("current", current);
			request.setAttribute("username", name);
			request.getRequestDispatcher("Resource/index.jsp").forward(request, response);

	}

}
