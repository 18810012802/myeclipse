package com.libo.servlet.t;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.dao.impl.t.Org_employeeDaoImpl;
import com.lib.dao.t.Org_employeeDao;
import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.Org_employee;
import com.libo.service.impl.t.Msg_ManuscriptsServiceImpl;
import com.libo.util.PageUtil;

public class MyFileMesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Msg_ManuscriptsService msg=new Msg_ManuscriptsServiceImpl();
		String code=request.getParameter("code");
		String mesname=request.getParameter("pname");
		String mesnum=request.getParameter("pnum");
		
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
		List<Msg_manuscripts> ms=msg.selectAllByNam(currPage, PageUtil.PAGESIZE, pname, pnum);
		int count=msg.selectAllByName(pname, pnum);
		int pagecount=0;
		if(count%PageUtil.PAGESIZE==0){
			pagecount=count/PageUtil.PAGESIZE;
		}else{
			pagecount=count/PageUtil.PAGESIZE+1;
		}

		
		request.setAttribute("msg", ms);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("pname", pname);
		request.setAttribute("pnum", pnum);
		request.setAttribute("coun", count);
		request.getRequestDispatcher("MyManuscripts/index.jsp").forward(request, response);
	}
	//²éÑ¯£¬Çå³ý
	

}
