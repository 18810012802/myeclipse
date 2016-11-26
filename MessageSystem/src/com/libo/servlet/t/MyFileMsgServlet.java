package com.libo.servlet.t;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.service.t.Msg_ManuscriptsService;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.service.impl.t.Msg_fileServiceImpl;
import com.libo.util.PageUtil;

public class MyFileMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Msg_fileService m=new Msg_fileServiceImpl();
		Msg_ManuscriptsService mm=new Msg_ManuscriptsServiceImpl();
		String metitle=request.getParameter("title");
		String meauthor=request.getParameter("author");
		String mesnum=request.getParameter("number");
		String mesname=request.getParameter("nam");
		
		
		String nam=null;
		if(mesname!=null){
			nam=mesname;
		}
		String number=null;
		if(mesnum!=null){
			number=mesnum;
		}
		String title=null;
		if(mesnum!=null){
			title=metitle;
		}
		String author=null;
		if(mesnum!=null){
			author=meauthor;
		}
		int currPage=1;
		String strcurrent=request.getParameter("current");
		if(strcurrent!=null){
			currPage=Integer.parseInt(strcurrent);
		}
		int count=m.selectAllByMuch(title, author, number, nam);
		List<Msg_file> msg=m.selectAllByMuch(currPage, PageUtil.PAGESIZE, title, author, number, nam);
		int pagecount=0;
		if(count%PageUtil.PAGESIZE==0){
			pagecount=count/PageUtil.PAGESIZE;
		}else{
			pagecount=count/PageUtil.PAGESIZE+1;
		}
		
		request.setAttribute("ms", msg);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("pname", nam);
		request.setAttribute("pnum", number);
		request.setAttribute("pauthor", author);
		request.setAttribute("ptitle", title);
		request.setAttribute("coun", count);
		request.getRequestDispatcher("MyManuscripts/index3.jsp").forward(request, response);
		
	}

}
