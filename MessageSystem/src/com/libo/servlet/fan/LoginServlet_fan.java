package com.libo.servlet.fan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libo.entity.Org_employee;


import com.libo.service.fan.Org_EmployeeService_fan;

import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;

public class LoginServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 //获取out
		PrintWriter out = response.getWriter();
		//获取session
		HttpSession session=request.getSession();
		//使用业务逻辑层
		Org_EmployeeService_fan service=new Org_EmployeeServiceImpl_fan();*/
		//获取客户端的用户名和密码
		//乱码处理--post发送
		/*request.setCharacterEncoding("utf-8");
		String username=request.getParameter("user_name");
		String pwd=request.getParameter("user_pwd");
		Org_employee orge=service.login(username,pwd);
		if(orge!=null){
			String yesOrNo=request.getParameter("checkme");
			session.setAttribute("orge",orge);
			//使用Cookie保存用户
		if(yesOrNo!=null&&yesOrNo.equals("checkme")){
			Cookie cookie=new Cookie("Loginname",orge.getLoginname());
			Cookie cookie1=new Cookie("Loginpassword",orge.getLoginpassword());
			//写入各户端
			cookie.setPath("/");
			cookie1.setPath("/");
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
			out.write("<script>alert('登录成功');location.href='index.jsp';</script>");
			
		}else{
			out.write("<script>alert('登录失败');location.href='login.jsp';</script>");
		}
	}
	}
*/}
	}