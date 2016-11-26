package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.fan.Org_RoleService_fan;
import com.libo.service.impl.fan.Org_RoleServiceImpl_fan;

public class DeleteRoleServlet_fan extends HttpServlet {

	
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
		String id=request.getParameter("ids");
		//System.out.println(id);
		int count=0;
		Org_RoleService_fan orgRoleService=new Org_RoleServiceImpl_fan();
		String[] check=id.split(",");
		//System.out.println(id);
		for (String string : check) {
			if(string.equals("-1")){
				continue;
			}else{
				count=orgRoleService.updateOrgRoleById(Integer.valueOf(string));
			}
		}
		
		if(count>0){
			out.print("<script>location.href='SelectRoleServlet_fan';alert('É¾³ý³É¹¦');</script>");
		}else{
			out.print("<script>location.href='SelectRoleServlet_fan';alert('É¾³ýÊ§°Ü');</script>");
		}
	}

}
