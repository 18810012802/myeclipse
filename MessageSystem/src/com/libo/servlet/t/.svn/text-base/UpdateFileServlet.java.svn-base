package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;

public class UpdateFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("midd");
		int fid =0;
		if(id!=null){			
		fid= Integer.valueOf(id);
		}
		System.out.println("fidÎª£º"+fid);
		Msg_fileService msg=new Msg_fileServiceImpl();
		List<Msg_file> mmfil=msg.selectAllbyFfid(fid);
		Msg_ManuscriptsService mman=new Msg_ManuscriptsServiceImpl();
		List<Msg_manuscripts> mms=mman.selectAll();
		System.out.println("mmfilÐÅÏ¢£º"+mmfil.get(0).getContent());

		request.setAttribute("msg", mms);
		request.setAttribute("file", mmfil);
		request.getRequestDispatcher("MyFile/addfile.jsp").forward(request, response);
	}

}
