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
		 //��ȡout
		PrintWriter out = response.getWriter();
		//��ȡsession
		HttpSession session=request.getSession();
		//ʹ��ҵ���߼���
		Org_EmployeeService_fan service=new Org_EmployeeServiceImpl_fan();*/
		//��ȡ�ͻ��˵��û���������
		//���봦��--post����
		/*request.setCharacterEncoding("utf-8");
		String username=request.getParameter("user_name");
		String pwd=request.getParameter("user_pwd");
		Org_employee orge=service.login(username,pwd);
		if(orge!=null){
			String yesOrNo=request.getParameter("checkme");
			session.setAttribute("orge",orge);
			//ʹ��Cookie�����û�
		if(yesOrNo!=null&&yesOrNo.equals("checkme")){
			Cookie cookie=new Cookie("Loginname",orge.getLoginname());
			Cookie cookie1=new Cookie("Loginpassword",orge.getLoginpassword());
			//д�������
			cookie.setPath("/");
			cookie1.setPath("/");
			response.addCookie(cookie);
			response.addCookie(cookie1);
		}
			out.write("<script>alert('��¼�ɹ�');location.href='index.jsp';</script>");
			
		}else{
			out.write("<script>alert('��¼ʧ��');location.href='login.jsp';</script>");
		}
	}
	}
*/}
	}