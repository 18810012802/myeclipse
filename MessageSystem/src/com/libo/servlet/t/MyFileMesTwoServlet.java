package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.util.Da;
import com.libo.util.PageUtil;

public class MyFileMesTwoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession(); 
		Object oid=session.getAttribute("org_id");
		String id="";
		if(oid==null){
			id="0";
		}else{
			id=oid.toString();
		}
		System.out.println(oid);
		int userid=Integer.parseInt(id);
		
		Msg_ManuscriptsService msg=new Msg_ManuscriptsServiceImpl();
		String mesname=request.getParameter("pname");
		String mesnum=request.getParameter("pnum");
		String mesendtim=request.getParameter("psendtime");
		String meendtim=request.getParameter("pendtime");
		
		String pname=null;
		if(mesname!=null){
			pname=mesname;
		}
		String pnum=null;
		if(mesnum!=null){
			pnum=mesnum;
		}
		int currPage=1;
		String strcurrent=request.getParameter("current");
		if(strcurrent!=null){
			currPage=Integer.parseInt(strcurrent);
		}
		Date psendtim=null;
		if(mesendtim!=null){
			psendtim=Da.toDate(mesendtim);
		}
		Date pendtim=null;
		if(meendtim!=null){
			pendtim=Da.toDate(meendtim);
		}
		
		List<Msg_manuscripts> ms=msg.selectAllByRMid(currPage, PageUtil.PAGESIZE, userid, pname, pnum, psendtim, pendtim);
		int count=msg.selectAllByRMid(userid, pname, pnum, psendtim, pendtim);
		int pagecount=0;
		if(count%PageUtil.PAGESIZE==0){
			pagecount=count/PageUtil.PAGESIZE;
		}else{
			pagecount=count/PageUtil.PAGESIZE+1;
		}
		
		request.setAttribute("msg", ms);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("coun", count);
		request.setAttribute("pname", pname);
		request.setAttribute("pnum", pnum);
		request.setAttribute("psendtim", psendtim);
		request.setAttribute("pendtim", pendtim);
		request.getRequestDispatcher("MyManuscripts/index2.jsp").forward(request, response);
	}

}
