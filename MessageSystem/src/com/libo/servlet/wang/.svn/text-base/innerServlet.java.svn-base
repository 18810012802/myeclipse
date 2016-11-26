package com.libo.servlet.wang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.dao.wangchangcheng.InnerDaoImpl;
import com.lib.service.t.Add_bookService;
import com.lib.serviceImpl.Add_bookServiceImpl;
import com.libo.entity.Add_book;
import com.libo.util.JxlExcelUtil;
public class innerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();// 分页大小
		int pageSize = 3;

		String type = request.getParameter("type");
		// 录用稿件
		if ("delPro".equals(type)) {
			Map<String, String> condition = new HashMap<String, String>();
			String createUserId=null;
			if("personal".equals(type)){
				createUserId=request.getSession().getAttribute("org_id").toString();
			}
			String name = request.getParameter("name");
			String telphone = request.getParameter("telphone");
			if (name != null && !("null".equals(name))
					&& !("".equals(name.trim()))) {
				condition.put("name", name);
		}
			if (telphone != null && !("null".equals(telphone))
					&& !("".equals(telphone.trim()))) {
				condition.put("telphone", telphone);
			}
		if (createUserId != null && !("null".equals(createUserId))
					&& !("".equals(createUserId.trim()))) {
				condition.put("createUserId", createUserId);
			}
			InnerDaoImpl ps = new InnerDaoImpl();
			List<Add_book> msg = ps.queryInnerList(0, pageSize,
					condition);
			Map<String, String> titles = Collections
					.synchronizedMap(new LinkedHashMap<String, String>());
			titles.put("id", "ID");
			titles.put("name", "姓名");
			titles.put("birthday", "出生日期");
			titles.put("telphone", "电话号码");
			titles.put("address", "地址");
			titles.put("email", "邮箱");

			String result = JxlExcelUtil.excleOutWithTitle(msg,
					"D:\\excel\\innerConnBook.xls", titles);
			response.getWriter().write(result);
			// request.getRequestDispatcher("/PublishServlet").forward(request,
			// response);

		}
			String createUserId=null;
			if("personal".equals(type)){
				createUserId=request.getSession().getAttribute("org_id").toString();
			}
			Map<String, String> condition = new HashMap<String, String>();
			String name = request.getParameter("name");
			String telphone = request.getParameter("telphone");
			if (name != null && !("null".equals(name))
					&& !("".equals(name.trim()))) {
				condition.put("name", name);
			}
			if (telphone != null && !("null".equals(telphone))
					&& !("".equals(telphone.trim()))) {
				condition.put("telphone", telphone);
			}
			if (createUserId != null && !("null".equals(createUserId))
					&& !("".equals(createUserId.trim()))) {
				condition.put("createUserId", createUserId);
			}
			int page = Integer
					.parseInt(request.getParameter("page") == null ? "1"
							: request.getParameter("page"));
			InnerDaoImpl ps = new InnerDaoImpl();

			List<Add_book> msg = ps.queryInnerList(page, pageSize, condition);
			int[] counts = ps.queryInnerCount(pageSize, condition);
			int pageCount = counts[0];
			int count = counts[1];
			request.setAttribute("msg", msg);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("page", page);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("count", count);
			request.setAttribute("name", name);
			request.setAttribute("telphone", telphone);
			String jsp="";
			if(createUserId != null && !("null".equals(createUserId))){
				
			}else{
				jsp="AddressList/inner.jsp";
			}
			request.getRequestDispatcher(jsp).forward(
					request, response);
		}

	}


