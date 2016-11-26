package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dao.t.File_attachDao;
import com.lib.service.t.File_attachService;
import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.File_attachServiceImpl;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;

public class LookMyFileMesTwoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mmd=request.getParameter("mid");
		int mid=0;
		if(mmd!=null){
			mid=Integer.parseInt(mmd);
		}
		Msg_ManuscriptsService msg=new Msg_ManuscriptsServiceImpl();
		List<Msg_manuscripts> mm=msg.selectAllByMid(mid);
		File_attachService file=new File_attachServiceImpl();
		File_attach fil=new File_attach();
		fil.setMenuId(11);
		fil.setFileId(mid);
		File_attach ms=file.selectAllByMFid(fil);
		
		request.setAttribute("ms", mm);
		request.setAttribute("msg", ms);
		request.getRequestDispatcher("MyManuscripts/look3.jsp").forward(request, response);
	}

}
