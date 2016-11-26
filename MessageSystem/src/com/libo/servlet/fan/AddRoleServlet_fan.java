package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.libo.entity.Org_employee;
import com.libo.entity.Org_role;
import com.libo.entity.Sys_menu;
import com.libo.service.fan.Org_EmployeeService_fan;

import com.libo.service.fan.Sys_menuService_fan;
import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;
import com.libo.service.impl.fan.Org_RoleServiceImpl_fan;
import com.libo.service.impl.fan.Sys_menuServiceImpl_fan;


public class AddRoleServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sys_menuService_fan menuService=new Sys_menuServiceImpl_fan();
		List<Sys_menu> listZhu=menuService.getSysMenuByMenuLevel();
		List<Sys_menu> listZi=menuService.getSysMenuBy();
		request.setAttribute("listZhu", listZhu);
		request.setAttribute("listZi", listZi);
		request.getRequestDispatcher("Role/addRole.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
         String []chenk = request.getParameterValues("chenk");
         Org_RoleServiceImpl_fan roleService = new Org_RoleServiceImpl_fan();
         Org_EmployeeService_fan orgEmployeeService = new Org_EmployeeServiceImpl_fan();
         Org_role role = new Org_role();
         String title = request.getParameter("title");
         String status = request.getParameter("status");
         HttpSession session = request.getSession();
         String user = (String)session.getAttribute("org_name");
         
         
         Org_employee orgem =  orgEmployeeService.selectOrgEmployeesByName(user);
         role.setOrg_id(orgem.getId());
         role.setRoleName(title);
         role.setState(Integer.valueOf(status));
         int id = roleService.addRole(role);
         
         for (int i = 0; i < chenk.length; i++) {
				roleService.addPerm(Integer.valueOf(chenk[i]), id);
			}
         if(id>0){
         	   out.print("<script>location.href='SelectRoleServlet_fan';alert('添加成功！');</script>");
            }else{
       		 out.print("<script>location.href='SelectRoleServlet_fan';alert('添加失败！');</script>");
   		 }
	}

}
