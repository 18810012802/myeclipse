package com.mql.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mql.dao.Query;
import com.mql.dao.TreeListDao;
import com.mql.domain.User;

public class PublishServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> sss = request.getParameterNames();
		while (sss.hasMoreElements()) {
			System.out.println(sss.nextElement());
		}
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		String state=request.getParameter("state");
		if("tree".equals(type)){
			String id=request.getParameter("id");
			if(id==null){
				id="0";
			}
			TreeListDao tld=new TreeListDao();
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			JSONArray ja=tld.query(Integer.parseInt(id));
			pw.write(ja.toString());
			pw.close();
			
		}else if("ifexist".equals(type)){
			Query q=new Query();
			String name=request.getParameter("name");
			int count=q.exist(name);
			response.getWriter().write(count+"");
			response.getWriter().close();
		}else if("users".equals(type)){
			Query q=new Query();
			String name=request.getParameter("users");
			String s=q.queryU().toString();
			response.getWriter().write(s+"");
			response.getWriter().close();
		}else if ("del".equals(type)) {
			Query ps = new Query();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String ids = request.getParameter("ids");
			String[] idss = ids.split(",");
			result = ps.delete(idss);
			// String result=ps.add(List<User>);
			pw.write(result);
			pw.close();
		} else if ("add".equals(type)) {
			Query ps = new Query();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String rows = request.getParameter("rows");
			// result = ps.add(idss);
			// String result=ps.add(List<User>);
			pw.write(result);
			pw.close();
		} else if ("update".equals(type)) {
			Query ps = new Query();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			//Object rows = request.getParameter("rows");
			String id=request.getParameter("id");
			String email=request.getParameter("email");
			String user=request.getParameter("user");
			User u = new User();
			u.setId(Integer.parseInt(id));
			u.setUser(user);
			u.setEmail(email);
			result = ps.update(u);
			// String result=ps.add(List<User>);
			pw.write(result+"");
			pw.close();
		} else {
			Query ps = new Query();
			int page = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("rows"));
			String sort = request.getParameter("sort");
			String order = request.getParameter("order");

			String user = request.getParameter("user");
			Map<String, Object> map = ps.queryUser(sort, order, page, pageSize,
					user);
			JSONObject jo = JSONObject.fromObject(map);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(jo.toString());
			pw.close();
		}

	}
}
