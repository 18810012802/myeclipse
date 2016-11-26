package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
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

public class QueryMinuteInfoServlet extends HttpServlet {

	
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
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserService us= new UserServiceImpl();
		String uname=us.SelectUserName(uid);
		InfoService info =new InfoServiceImpl();
		String fname=info.QueryFlieNmae(11, id);
		List<Msg_manuscripts> msg=info.selectInfo(id);
		request.setAttribute("uname", uname);
		request.setAttribute("fname", fname);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("Manuscripts/look3.jsp").forward(request, response);
		
	}

}
