package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.lichao.UserServiceImpl;
import com.libo.service.lichao.InfoService;
import com.libo.service.lichao.UserService;

public class SelectInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		InfoService info =new InfoServiceImpl();
		List<Msg_manuscripts> msg=info.selectInfo(id);
		UserService us=new UserServiceImpl();
		int oid=Integer.parseInt(request.getParameter("oid"));
		String uname=us.SelectUserName(oid);
		request.setAttribute("uname", uname);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("Manuscripts/updateinfo.jsp").forward(request, response);
	}

}
