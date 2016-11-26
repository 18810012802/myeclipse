package com.libo.servlet.yetong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libo.entity.Org_employee;
import com.libo.service.impl.yetong.OrgEmployeeSearchServiceImpl;
import com.libo.service.yetong.OrgEmployeeSearchService;

public class BasicInfoServlet extends HttpServlet {

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
		Object oid = session.getAttribute("org_id");
		String id = "";
		if (oid == null) {
			id = "0";
		} else {
			id = oid.toString();
		}
		int uid = Integer.parseInt(id);
		OrgEmployeeSearchService oes = new OrgEmployeeSearchServiceImpl();
		Org_employee oe = new Org_employee();
		oe = oes.showInfo(uid);
		String sex = "男";
		if (oe.getSex() == 2) {
			sex = "女";
		}
		String role = "未知";
		switch (oe.getRoleid()) {
		case 1:
			role = "管理员";
			break;
		case 2:
			role = "采编人员";
			break;
		case 3:
			role = "作者";
			break;
		case 4:
			role = "责任编辑";
			break;
		case 7:
			role = "主编";
			break;
		default:
			break;
		}
		String email = oe.getEmail();
		String telphone = oe.getTelphone();
		String idcaid = oe.getIdcaid();
		String photo = oe.getPhoto();

		request.setAttribute("oe", oe);
		request.setAttribute("sex", sex);
		request.setAttribute("email", email);
		request.setAttribute("telphone", telphone);
		request.setAttribute("idcaid", idcaid);
		request.setAttribute("roleid", role);
		request.setAttribute("photo", photo);
		request.getRequestDispatcher("Self/selfinfo.jsp").forward(request,
				response);
	}

}
