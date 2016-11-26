package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.YetInfoServiecImpl;
import com.libo.service.lichao.YetInfoService;
import com.libo.util.PageSize;

public class SelectYetInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		YetInfoService yet=new YetInfoServiecImpl();
		String strCurrent=request.getParameter("current");
		int currentPage=1;
		if(strCurrent!=null){
			currentPage=Integer.parseInt(strCurrent);
		}
		List<Msg_manuscripts> msg=yet.queryYetInfo(currentPage, name, number);
		int pageCount=0;
		int yetInfoCount=yet.getYetInfoCount(name, number);
		if(yetInfoCount%PageSize.PAGE_SIZE==0){
			pageCount=yetInfoCount/PageSize.PAGE_SIZE;
		}else{
			pageCount=yetInfoCount/PageSize.PAGE_SIZE+1;
		}
		request.setAttribute("msg",msg);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("yetInfoCount",yetInfoCount);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("name", name);
		request.setAttribute("number", number);
		request.getRequestDispatcher("Manuscripts/listinfo3.jsp").forward(request, response);
	}

}
