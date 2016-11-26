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
/**
 * 已经淘汰
 * @author Administrator
 *
 */
public class QueryInfoByLike extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		InfoService info =new InfoServiceImpl();
		//设一个当前页号；
		int currentPage=1;
		String strCurrent=request.getParameter("current");
		if(strCurrent!=null){
			currentPage=Integer.parseInt(strCurrent);
		}
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		Date newDate=Da.toDate(request.getParameter("newDate"));
		Date endDate=Da.toDate(request.getParameter("endDate"));
		List<Msg_manuscripts> msg=info.queryInfoByLike(currentPage, name, number, newDate, endDate);
		int pageCount=info.getPageCout(name, number, newDate, endDate);
		int InfoCount=info.getInfoCout(null, null, null, null);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg",msg);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("InfoCount", InfoCount);
		request.getRequestDispatcher("Manuscripts/listinfo.jsp").forward(request, response);
	}

}
