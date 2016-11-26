package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_file;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.impl.lichao.WaitInfoServiceImpl;
import com.libo.service.lichao.InfoService;
import com.libo.service.lichao.WaitInfoService;
import com.libo.util.Da;
import com.libo.util.PageSize;

public class QueryWaitInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		WaitInfoService wait=new WaitInfoServiceImpl();
		//设一个当前页号；
		int currentPage=1;
		String strCurrent=request.getParameter("current");
		if(strCurrent!=null){
			currentPage=Integer.parseInt(strCurrent);
		}
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		String title=request.getParameter("title");
		List<Msg_file> fil=wait.selectWaitInfo(currentPage, name, number, title);
		int waitInfoCount=wait.getWaitInfoCount(name, number, title);
		int pageCount=0;
		if(waitInfoCount%PageSize.PAGE_SIZE==0){
			pageCount=waitInfoCount/PageSize.PAGE_SIZE;
		}else{
			pageCount=waitInfoCount/PageSize.PAGE_SIZE+1;
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("fil",fil);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("waitInfoCount", waitInfoCount);
		request.setAttribute("name",name);
		request.setAttribute("number",number);
		request.setAttribute("title",title);
		request.getRequestDispatcher("Manuscripts/filelist.jsp").forward(request, response);
		
	}

}
