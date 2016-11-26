package com.libo.servlet.lichao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Msg_file;
import com.libo.service.impl.lichao.MsgFileServiceImpl;
import com.libo.service.lichao.MsgFileService;
import com.libo.util.PageSize;

public class QueryMinuteBution extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MsgFileService file=new MsgFileServiceImpl();
		int currentPage=1;
		String strCurrent=request.getParameter("current");
		if(strCurrent!=null){
			currentPage=Integer.parseInt(strCurrent);
		}
		int maid=Integer.parseInt(request.getParameter("maid"));
		String title=request.getParameter("title");
		String user=request.getParameter("user");
		int pageCount=0;
		int minuteInfoCount=file.getMinute(maid, title, user);
		if(minuteInfoCount%PageSize.PAGE_SIZE==0){
			pageCount=minuteInfoCount/PageSize.PAGE_SIZE;
		}else{
			pageCount=minuteInfoCount/PageSize.PAGE_SIZE+1;
		}
		List<Msg_file> fil=file.selectMinuteInfo(currentPage, maid, title, user);
		request.setAttribute("fil", fil);
		request.setAttribute("title", title);
		request.setAttribute("user", user);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("minuteInfoCount", minuteInfoCount);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maid", maid);
		request.getRequestDispatcher("Manuscripts/filelist2.jsp").forward(request, response);
	}

}
