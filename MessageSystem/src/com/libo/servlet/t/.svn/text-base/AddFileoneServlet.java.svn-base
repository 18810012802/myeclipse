package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;

public class AddFileoneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Msg_ManuscriptsService mm=new Msg_ManuscriptsServiceImpl();
		List<Msg_manuscripts> msg=mm.selectAll();
		System.out.println("msg:"+msg);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("MyFile/addfile1.jsp").forward(request, response);
	}

}
