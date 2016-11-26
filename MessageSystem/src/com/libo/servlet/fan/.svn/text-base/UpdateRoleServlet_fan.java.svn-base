package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Org_role;
import com.libo.entity.Sys_menu;


import com.libo.service.fan.Org_RoleService_fan;
import com.libo.service.fan.Sys_menuService_fan;
import com.libo.service.impl.fan.Org_RoleServiceImpl_fan;
import com.libo.service.impl.fan.Sys_menuServiceImpl_fan;

public class UpdateRoleServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.valueOf(ids);
		Org_RoleService_fan roleService = new Org_RoleServiceImpl_fan();
		Sys_menuService_fan menuService = new Sys_menuServiceImpl_fan();
		Org_role orgRole =  roleService.getRoleByid(id);
		List<Sys_menu> listCha = menuService.getMenuIdByRoleId(id);
		List<Sys_menu> listZhu =menuService.getSysMenuByMenuLevel();
		List<Sys_menu> listZi = menuService.getSysMenuBy();
		request.setAttribute("orgRole", orgRole);
		request.setAttribute("listCha", listCha);
		request.setAttribute("listZhu", listZhu);
		request.setAttribute("listZi", listZi);
		
         request.getRequestDispatcher("Role/editRole.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String roleId = request.getParameter("id");
        String []chenk = request.getParameterValues("chenk");
        Org_RoleService_fan roleService = new Org_RoleServiceImpl_fan();
        Org_role role = new Org_role();
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        role.setRoleName(title);
        role.setState(Integer.valueOf(status));
        role.setId(Integer.valueOf(roleId));
        int count = roleService.updateRole(role);
        int delete = roleService.deletePerm(Integer.valueOf(roleId));
        for (int i = 0; i < chenk.length; i++) {
			roleService.addPerm(Integer.valueOf(chenk[i]), Integer.valueOf(roleId));
		}
        if(count>0||delete>0){
        	   out.print("<script>location.href='SelectRoleServlet_fan';alert('修改成功！');</script>");
           }else{
      		 out.print("<script>location.href='SelectRoleServlet_fan';alert('修改失败！');</script>");
  		 }
		
	
		
	}

}
