package com.libo.servlet.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Org_employee;
import com.libo.service.impl.mc.loginServiceImpl;
import com.libo.service.mc.loginService;

public class loginServlet_mc extends HttpServlet {

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
		loginService loginService=new loginServiceImpl();
		String name=request.getParameter("user_name");
		String pwd=request.getParameter("user_pwd");
		Org_employee org_employee=loginService.login(name, pwd);
		String hid=request.getParameter("hid");
		if(org_employee!=null){
			if(hid.equals("rem selected")){
				Cookie cookie=new Cookie("username", name);
				Cookie cookie1=new Cookie("userpwd", pwd);
				cookie.setPath("/");
				cookie1.setPath("/");
				response.addCookie(cookie);
				response.addCookie(cookie1);
			}
				int org_id=org_employee.getId();
				request.getSession().setAttribute("org_id",org_id);
				request.getSession().setAttribute("org_name", org_employee.getUsername());
				request.setAttribute("org_name",org_employee.getUsername() );
				request.getSession().setAttribute("org_employee", org_employee);
			
			out.write("<script>alert('³É¹¦')</script>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			out.write("<script>alert('Ê§°Ü');location.href='login.jsp'</script>");
		}
	}

}
