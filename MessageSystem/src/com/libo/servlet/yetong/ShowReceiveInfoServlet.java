package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.libo.entity.Attach;
import com.libo.entity.Box;
import com.libo.entity.Employee;
import com.libo.entity.Mail_box;
import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.MailBoxServiceImpl;
import com.libo.service.impl.yetong.OrgEmployeeSearchServiceImpl;
import com.libo.service.yetong.MailBoxService;
import com.libo.service.yetong.OrgEmployeeSearchService;

public class ShowReceiveInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String type = request.getParameter("type");
		OrgEmployeeSearchService employee=new OrgEmployeeSearchServiceImpl();
		if(type==null){
			//ÒµÎñÂß¼­³É
			//TGZmail_boxService mail=new TGZmail_boxServiceImpl();
			String userid = request.getParameter("id");
			if(userid==null){
				userid="0";
			}
			List<Employee> list=employee.selectemp();

			request.setAttribute("id", Integer.parseInt(userid));
			request.setAttribute("list", list);
			request.getRequestDispatcher("Email/sendemail.jsp").forward(request, response);					
			}else if(type.equals("look")){
			String id = request.getParameter("id");
			String tar = request.getParameter("tar");
			MailBoxService mail=new MailBoxServiceImpl();
			Box box=mail.selectbox(Integer.parseInt(id));
			Attach attach=mail.selectattach(Integer.parseInt(id));
			List<Employee> rlist=employee.selectemp();
			request.setAttribute("rlist",rlist);
			request.setAttribute("attach", attach);
			request.setAttribute("box", box);
			request.setAttribute("tar", tar);
			request.getRequestDispatcher("Email/relook.jsp").forward(request, response);
		}		
}

}
