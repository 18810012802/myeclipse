package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.OrgEmployeeSearchServiceImpl;
import com.libo.service.yetong.OrgEmployeeSearchService;
import com.libo.util.MD5Util;

public class PassWordServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.sendRedirect("Self/password.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		Org_employee oe = (Org_employee)session.getAttribute("org_employee");
		int uid = oe.getId();
		String op=request.getParameter("oldpwd");
		String np=request.getParameter("newpwd");
		String rp=request.getParameter("repwd");
		System.out.println(op+"=="+np+"=="+rp);
		if(!np.equals(rp)){
			out.print("<script>alert('两次输入的密码不一致！');location.href='User/password.jsp';</script>");
		}else{
			OrgEmployeeSearchService oes= new OrgEmployeeSearchServiceImpl();
			int flags=oes.modifyPwd(uid, op, np);
			if (flags>0) {
				out.print("<script>alert('密码修改成功');location.href='Self/password.jsp';</script>");
			} else {
				out.print("<script>location.href='Self/password.jsp';alert('密码修改失败');</script>");
			}
		}
		out.flush();
		out.close();
		
	}

}
