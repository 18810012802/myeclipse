package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.service.impl.lichao.YetInfoServiecImpl;
import com.libo.service.lichao.YetInfoService;

public class SubCheckServlrt extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out=response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		YetInfoService yet =new YetInfoServiecImpl();
		int rows=yet.subCheck(id);
		if (rows > 0) {
			out.print("<script>alert('…Û∫À≥…π¶£°');location.href='SelectYetInfoServlet'</script>");
		} else {
			out.print("<script>alert('…Û∫À ß∞‹£°');location.href='SelectYetInfoServlet'</script>");
		}
	}

}
