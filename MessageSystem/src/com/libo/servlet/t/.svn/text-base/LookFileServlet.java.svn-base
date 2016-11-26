package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lib.service.t.File_attachService;
import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.File_attachServiceImpl;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;

public class LookFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int mid=Integer.parseInt(request.getParameter("fid"));
		File_attachService fil=new File_attachServiceImpl();
		File_attach file=new File_attach();
		file.setMenuId(11);
		file.setFileId(mid);
		File_attach filed=fil.selectAllByMFid(file);
		
		Msg_ManuscriptsService msg=new Msg_ManuscriptsServiceImpl();
		List<Msg_manuscripts> ms=msg.selectAllByMid(mid);
		
		request.setAttribute("msg", filed);
		request.setAttribute("ms", ms);
		request.getRequestDispatcher("MyManuscripts/look.jsp").forward(request, response);
	}

}
