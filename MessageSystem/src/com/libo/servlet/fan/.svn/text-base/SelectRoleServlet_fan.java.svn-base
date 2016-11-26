package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Org_role;

import com.libo.service.fan.Org_RoleService_fan;
import com.libo.service.impl.fan.Org_RoleServiceImpl_fan;
import com.libo.util.PageSize_fan;

public class SelectRoleServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Org_RoleService_fan roleService = new Org_RoleServiceImpl_fan();
        String rolename = request.getParameter("rolename");
        String pageNum = request.getParameter("pageNum");
        //定义一个页码集合
        List<Integer> nlist=new ArrayList<Integer>();
        int pages = 0;
			if(pageNum==null){
				pageNum = "1";
			}
			pages = Integer.valueOf(pageNum);
			 List<Org_role> list = roleService.getAllByPage(pages, PageSize_fan.pageSize, rolename);
	         //最大页数
	         int max = roleService.getPagesBySize(PageSize_fan.pageSize, rolename);
	         //将每个页码都放到页码集合中去
	         for (int i = 1; i <=max; i++) {
	        	 nlist.add(i);
			}
	         //查询的数据条数
	         int count = roleService.getCount(rolename);
	         request.setAttribute("list", list);
	         request.setAttribute("max", max);
	         request.setAttribute("count", count);
	         request.setAttribute("pages", pages);
	         request.setAttribute("nlist", nlist);
        request.getRequestDispatcher("Role/index.jsp").forward(request, response);
		

}
}
