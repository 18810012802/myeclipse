package com.libo.servlet.fan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libo.entity.Org_employee;

import com.libo.service.fan.Org_EmployeeService_fan;
import com.libo.service.impl.fan.Org_EmployeeServiceImpl_fan;
import com.libo.util.PageSize;
import com.libo.util.PageSize_fan;
public class Org_EmployeeServlet_fan extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Org_EmployeeService_fan orgService=new Org_EmployeeServiceImpl_fan();
		String username = request.getParameter("username");
        String pageNum = request.getParameter("pageNum");
        //����һ��ҳ�뼯��
        List<Integer> nlist=new ArrayList<Integer>();
        int pages = 0;
			if(pageNum==null){
				pageNum = "1";
			}
			pages = Integer.valueOf(pageNum);
		//List<Org_employee> list = orgService.selectOrg();
        List<Org_employee> list = orgService.getAllByPage(pages, PageSize.PAGE_SIZE, username);
        
        //���ҳ��
        int max = orgService.getPagesBySize(PageSize_fan.pageSize, username);
        //��ÿ��ҳ�붼�ŵ�ҳ�뼯����ȥ
        for (int i = 1; i <=max; i++) {
        	nlist.add(i);
	}
        //��ѯ����������
        int count = orgService.getCount(username);
        request.setAttribute("list", list);
        request.setAttribute("max", max);
        request.setAttribute("count", count);
        request.setAttribute("pages", pages);
        request.setAttribute("nlist", nlist);
        request.getRequestDispatcher("User/index.jsp").forward(request, response);
		
	}

}
