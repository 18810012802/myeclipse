package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.libo.service.fan.Org_EmployeeService_fan;
import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;

public class DeleteOrg_EmployeeServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
        String orgId = request.getParameter("ids");
        System.out.println(orgId);
        int count = 0;
        Org_EmployeeService_fan orServices = new Org_EmployeeServiceImpl_fan();
        String[] check=orgId.split(",");
		for (String str : check) {
			//System.out.println(str);
			if(str.equals("-1")){
				continue;
			}else{
			 count = orServices.deletesOrgEmployee(Integer.valueOf(str));
			}
		}
        if(count>0){
       	 out.print("<script>location.href='Org_EmployeeServlet_fan';alert('É¾³ý³É¹¦£¡');</script>");
        }else{
       	 out.print("<script>location.href='Org_EmployeeServlet_fan';alert('É¾³ýÊ§°Ü£¡');</script>");
        }
	
	}
	}


