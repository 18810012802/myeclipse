package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.libo.dao.yetong.MailBoxDao;
import com.libo.entity.Box;
import com.libo.entity.Employee;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.impl.yetong.OrgEmployeeSearchServiceImpl;
import com.libo.service.yetong.MailBoxService;
import com.libo.service.yetong.OrgEmployeeSearchService;
import com.libo.util.PageSize;
import com.libo.util.PageUtil;

public class ShowReceiveEmailsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MailBoxService mail=new MailBoxServiceImpl();
		
		HttpSession session=request.getSession();
		Org_employee receiveuser=(Org_employee)session.getAttribute("org_employee");
		
//		List<Box> list=mail.selectreceiveuserid(receiveuserid.getId());
		MailBoxService box=new MailBoxServiceImpl();
		String tiao = request.getParameter("tiao");
		String pname = request.getParameter("pname");
		String order = request.getParameter("order");
		String currentpage = request.getParameter("currentpage");
		if(tiao==null){
			tiao="";
		}
		if(pname==null){
			pname="";
		}
		if(currentpage==null){
			currentpage="1";
		}
		List<Box> list=box.mohubox(tiao, pname,order,Integer.parseInt(currentpage),receiveuser.getId());
		int count=box.countbox(tiao, pname,receiveuser.getId());
		int totalpage=1;
		if(count%PageUtil.PAGESIZE==0){
			totalpage=count/PageUtil.PAGESIZE;
		}else{
			totalpage=count/PageUtil.PAGESIZE+1;
		}
		
		OrgEmployeeSearchService employee=new OrgEmployeeSearchServiceImpl();
		List<Employee> rlist=employee.selectemp();
		
		
		
		request.setAttribute("pname", pname);
		request.setAttribute("tiao", tiao);
		request.setAttribute("order", order);
		request.setAttribute("pagesize", PageUtil.PAGESIZE);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("count", count);
		request.setAttribute("rlist",rlist);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Email/receiveemail.jsp").forward(request, response);
	}

}
