package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.File_attachService;
import com.lib.service.t.Msg_fileService;
import com.lib.service.t.Org_employeeService;
import com.libo.entity.File_attach;
import com.libo.entity.Msg_file;
import com.libo.entity.Org_employee;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.t.File_attachServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;
import com.libo.service.impl.t.Org_employeeServiceImpl;
import com.libo.service.lichao.InfoService;

public class MyFileMsgLookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mid=request.getParameter("mid");
		String ptitle=request.getParameter("ptitle");
		String pid=request.getParameter("pid");
		
		int fid=0;
		if(mid!=null){
			fid=Integer.parseInt(mid);
		}
		int manid=0;
		if(pid!=null){
			 manid=Integer.parseInt(pid);
		}
		Msg_fileService msg=new Msg_fileServiceImpl();
		Org_employeeService md=new Org_employeeServiceImpl();
		List<Msg_file> mmsg=msg.selectAllbyFid(fid);
		InfoService info=new InfoServiceImpl();
		File_attach fil=new File_attach();
		fil.setMenuId(2);
		fil.setFileId(fid);
		String name=info.QueryFlieNmae(2, fid);
		
		
		request.setAttribute("msg", mmsg);
		request.setAttribute("pmtitle", ptitle);
		request.setAttribute("name", name);
		request.getRequestDispatcher("MyManuscripts/add1.jsp").forward(request, response);
	}

}
