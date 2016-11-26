package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.lichao.InfoServiceImpl;
import com.libo.service.lichao.InfoService;
import com.libo.util.Da;
import com.libo.util.PageSize;



public class ShowServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		InfoService info =new InfoServiceImpl();
		//��һ����ǰҳ�ţ�
		int currentPage=1;
		String strCurrent=request.getParameter("current");
		if(strCurrent!=null){
			currentPage=Integer.parseInt(strCurrent);
		}
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		Date newDate=Da.toDate(request.getParameter("newDate"));
		Date endDate=Da.toDate(request.getParameter("endDate"));
		List<Msg_manuscripts> msg=info.queryInfo(currentPage, name, number, newDate, endDate);
		int infoCount=info.getInfoCout(name, number, newDate, endDate);
		int pageCount=0;
		if(infoCount%PageSize.PAGE_SIZE==0){
			pageCount=infoCount/PageSize.PAGE_SIZE;
		}else{
			pageCount=infoCount/PageSize.PAGE_SIZE+1;
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg",msg);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("infoCount", infoCount);
		request.setAttribute("name",name);
		request.setAttribute("number",number);
		request.setAttribute("newDate",newDate);
		request.setAttribute("endDate",endDate);
		request.getRequestDispatcher("Manuscripts/listinfo.jsp").forward(request, response);
	}

}
