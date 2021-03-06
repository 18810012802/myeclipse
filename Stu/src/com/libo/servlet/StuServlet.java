package com.libo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.libo.po.Classes;
import com.libo.po.Students;
import com.libo.service.StuService;
import com.libo.service.StuServiceImpl;

public class StuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		//Users user = (Users) request.getSession().getAttribute("user");
		if("list".equals(type)){
			
		}else if("toUpdate".equals(type)){
			StuService ss=new StuServiceImpl();
			String stuId=request.getParameter("stuId");
			Students stu=new Students();
			stu.setStuId(Integer.parseInt(stuId));
			List<Students> msg=ss.queryAll(stu);
			request.setAttribute("msg", msg.get(0));
			request.getRequestDispatcher("pages/update.jsp").forward(request, response);
		}else if("update".equals(type)){
			String stuId=request.getParameter("stuId");
			String stuName=request.getParameter("stuName");
			String age=request.getParameter("age");
			String clsId=request.getParameter("clsId");
			Students stu=new Students();
			Classes c=new Classes();
			if(clsId!=null){
				c.setClsId(Integer.parseInt(clsId));
				stu.setClasses(c);
			}
			if(stuId!=null){
				stu.setStuId(Integer.parseInt(stuId));
			}
			if(stuName!=null){
				stu.setStuName(stuName);
			}
			if(age!=null){
				stu.setAge(Integer.parseInt(age));
			}
			StuService ss=new StuServiceImpl();
			PrintWriter pw = response.getWriter();
			
			if(ss.saveOrUpdate(stu)){
				pw.append("<script>alert('操作成功!');window.location.href='StuServlet';</script>");
				pw.close();

			}
		}else if("detail".equals(type)){
			StuService ss=new StuServiceImpl();
			String stuId=request.getParameter("stuId");
			Students stu=new Students();
			stu.setStuId(Integer.parseInt(stuId));
			List<Students> msg=ss.queryAll(stu);
			request.setAttribute("msg", msg.get(0));
			request.getRequestDispatcher("pages/detail.jsp").forward(request, response);
		}
		else if("delete".equals(type)){
			String stuId=request.getParameter("stuId");
			StuService ss=new StuServiceImpl();
			PrintWriter pw = response.getWriter();
			Students stu=new Students();
			stu.setStuId(Integer.parseInt(stuId));
			if(ss.delete(stu)){
				pw.append("<script>alert('删除成功!');window.location.href='StuServlet';</script>");
			}
			pw.close();
		}else if("toAdd".equals(type)){
			StuService ss=new StuServiceImpl();
			List<Students> msg=ss.queryAll(new Students());
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("pages/add.jsp").forward(request, response);
		}else if("classes".equals(type)){
			StuService ss=new StuServiceImpl();
			List<Classes> msg=ss.queryAllClasses(new Classes());
			JSONArray ja=new JSONArray();
			for (Classes s : msg) {
				JSONObject jo = new JSONObject();
				jo.put("id", s.getClsId());
				jo.put("name", s.getClsName());
				ja.add(jo);
			}
			PrintWriter out = response.getWriter();
			out.write(ja.toString());
			out.close();
		}else{
			StuService ss=new StuServiceImpl();
			List<Students> msg=ss.queryAll(new Students());
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	public Date strToDate(String houseDate) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(houseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
