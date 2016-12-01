package com.libo.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.libo.po.District;
import com.libo.po.House;
import com.libo.po.Street;
import com.libo.po.Types;
import com.libo.po.Users;
import com.libo.service.HouseService;
import com.libo.service.HouseServiceImpl;
import com.libo.service.UsersService;
import com.libo.service.UsersServiceImpl;

public class SerachHouseServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Enumeration<String> sss = request.getParameterNames(); while
		 * (sss.hasMoreElements()) { System.out.println(sss.nextElement()); }
		 */
		String type = request.getParameter("type");
		if ("login".equals(type)) {
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			Users u = new Users();
			u.setName(name);
			u.setPassword(passwd);
			UsersService us = new UsersServiceImpl();
			if (us.login(u)) {
				Users users=us.queryUserByName(name);
				request.getSession().setAttribute("user", users);
				HouseService hs = new HouseServiceImpl();
				List<House> msg = hs.query(new House(), 1,3);
				int count = hs.count(new House(), 3);
				request.setAttribute("msg", msg);
				request.setAttribute("count", count);
				request.setAttribute("page", 1);
				request.getRequestDispatcher("page/guanli.jsp").forward(
						request, response);

			} else {
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}
		} else if ("guanli".equals(type)) {
			String page = request.getParameter("page");
			HouseService hs = new HouseServiceImpl();
			List<House> msg = hs.query(new House(), Integer.parseInt(page),3);
			request.setAttribute("msg", msg);
			request.setAttribute("count", request.getParameter("count"));
			request.setAttribute("page", page);
			request.getRequestDispatcher("page/guanli.jsp").forward(request,
					response);
		} else if ("goToRegs".equals(type)) {
			request.getRequestDispatcher("page/regs.jsp").forward(request,
					response);
		} else if ("regs".equals(type)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String telephone = request.getParameter("telephone");
			String username = request.getParameter("username");
			Users users = new Users();
			users.setName(name);
			users.setPassword(password);
			users.setTelephone(telephone);
			users.setUsername(username);
			users.setIsadmin("0");
			UsersService hs = new UsersServiceImpl();
			if (hs.add(users)) {
				request.setAttribute("failed", "注册失败！");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				request.setAttribute("successed", "注册失败！");
				request.getRequestDispatcher("regs.jsp").forward(request,
						response);
			}
		} else if ("uniqueName".equals(type)) {
			String name = request.getParameter("name");
			PrintWriter out = response.getWriter();
			UsersService hs = new UsersServiceImpl();
			Users users = new Users();
			users.setName(name);
			if (hs.ifExists(users)) {
				out.write("<span id='pa' style='color:red;'>用户已存在！</span>");
			} else {
				out.write("<span id='pa' style='color:green;'>用户名OK！</span>");
			}
			out.close();
		}else if("details".equals(type)){
			String id=request.getParameter("id");
			HouseService hs = new HouseServiceImpl();
			//request.setAttribute("types",hs.queryTypes());
			//request.setAttribute("street",hs.queryStreet());
			request.setAttribute("msg",hs.queryHouseById(Integer.parseInt(id)));
			request.getRequestDispatcher("page/details.jsp").forward(request,
					response);
		}else if("street".equals(type)){
			HouseService hs = new HouseServiceImpl();
			List<Street> street=hs.queryStreet();
			JSONArray ja=new JSONArray();
			for(Street s:street){
				JSONObject jo=new JSONObject();
				jo.put("id", s.getId());
				jo.put("name", s.getName());
				ja.add(jo);
			}
			PrintWriter out=response.getWriter();
			out.write(ja.toString());
			out.close();
		}else if("types".equals(type)){
			HouseService hs = new HouseServiceImpl();
			List<Types> types=hs.queryTypes();
			JSONArray ja=new JSONArray();
			for(Types s:types){
				JSONObject jo=new JSONObject();
				jo.put("id", s.getId());
				jo.put("name", s.getName());
				ja.add(jo);
			}
			PrintWriter out=response.getWriter();
			out.write(ja.toString());
			out.close();
		}else if("list".equals(type)){
			House house = new House();
			int page=1;
			String title=request.getParameter("title");
			String price=request.getParameter("price");
			String street=request.getParameter("street");
			String housetype=request.getParameter("housetype");
			String floorage=request.getParameter("floorage");
			if(title!=null&&!"".equals(title.trim())){
				house.setTitle(title);
			}
			if(price!=null&&!"".equals(price.trim())){
				String[] prices=price.split("-");
				house.setMinPrice(Integer.parseInt(prices[0]));
				house.setMaxPrice(Integer.parseInt(prices[1]));
			}
			if(floorage!=null&&!"".equals(floorage.trim())){
				String[] floorages=floorage.split("-");
				house.setMinFloorage(Integer.parseInt(floorages[0]));
				house.setMaxFloorage(Integer.parseInt(floorages[1]));
			}
			if(street!=null&&!"".equals(street.trim())){
				Street s=new Street();
				s.setId(Integer.parseInt(street));
				house.setStreet(s);
			}
			if(housetype!=null&&!"".equals(housetype.trim())){
				Types t=new Types();
				t.setId(Integer.parseInt(housetype));
				house.setTypes(t);
			}
			HouseService hs=new HouseServiceImpl();
			if(request.getParameter("page")!=null){
				page=Integer.parseInt(request.getParameter("page"));
			}
			List<House> msg=hs.query(house, page, 4);
			request.setAttribute("msg", msg);
			int count=hs.count(house, 4);
			request.setAttribute("title", title);
			request.setAttribute("price", price);
			request.setAttribute("street", street);
			request.setAttribute("housetype", housetype);
			request.setAttribute("floorage", floorage);
			request.setAttribute("count", count);
			request.setAttribute("page", page);
			request.getRequestDispatcher("page/list.jsp").forward(request,
					response);
		}else if("publish".equals(type)){
			String title=request.getParameter("title");
			String types=request.getParameter("types");
			String floorage=request.getParameter("floorage");
			String price=request.getParameter("price");
			String houseDate=request.getParameter("houseDate");
			String district=request.getParameter("district");
			String street=request.getParameter("street");
			String contact=request.getParameter("contact");
			String description=request.getParameter("description");
			House house =new House();
			house.setTitle(title);
			Types t=new Types();
			t.setId(Integer.parseInt(types));
			house.setTypes(t);
			Users u=(Users)request.getSession().getAttribute("user");
			house.setUsers(u);
			house.setFloorage(Integer.parseInt(floorage));
			house.setPrice(Integer.parseInt(price));
			house.setHouseDate(strToDate(houseDate));
			District d=new District();
			d.setId(Integer.parseInt(district));
			Street s=new Street();
			s.setId(Integer.parseInt(street));
			s.setDistrict(d);
			house.setStreet(s);
			house.setPubdate(new Date());
			house.setContact(contact);
			house.setDescription(description);
			/*Enumeration e=request.getParameterNames();
			while(e.hasMoreElements()){
				request.removeAttribute(e.nextElement().toString());
			}
			request.getRequestDispatcher("SearchHouseServlet?type=list").forward(request,
					response);*/
			HouseService hs=new HouseServiceImpl();
			String id=request.getParameter("house_id");
			if(id!=null && !"".equals(id)){
				house.setId(Integer.parseInt(id));
			}
			hs.publishHouse(house);
			List<House> msg=hs.query(new House(), 1, 4);
			request.setAttribute("msg", msg);
			request.setAttribute("page", 1);
			request.getRequestDispatcher("page/list.jsp").forward(request,
					response);
		}else if("district".equals(type)){
			HouseService hs = new HouseServiceImpl();
			List<District> district=hs.queryDistrict();
			JSONArray ja=new JSONArray();
			for(District s:district){
				JSONObject jo=new JSONObject();
				jo.put("id", s.getId());
				jo.put("name", s.getName());
				ja.add(jo);
			}
			PrintWriter out=response.getWriter();
			out.write(ja.toString());
			out.close();
		}else if("toPublish".equals(type)){
			request.getRequestDispatcher("page/fabu.jsp").forward(request,
					response);
		}else if("streetById".equals(type)){
			String did=request.getParameter("id");
			HouseService hs = new HouseServiceImpl();
			List<Street> street=hs.queryStreetById(Integer.parseInt(did));
			JSONArray ja=new JSONArray();
			for(Street d:street){
				JSONObject jo=new JSONObject();
				jo.put("id", d.getId());
				jo.put("name", d.getName());
				ja.add(jo);
			}
			PrintWriter out=response.getWriter();
			out.write(ja.toString());
			out.close();
		}else if("delete".equals(type)){
			String id=request.getParameter("id");
			HouseService hs=new HouseServiceImpl();
			House house=new House();
			house.setId(Integer.parseInt(id));
			hs.delete(house);
			List<House> msg = hs.query(new House(), 1,3);
			int count = hs.count(new House(), 3);
			request.setAttribute("msg", msg);
			request.setAttribute("count", count);
			request.setAttribute("page", 1);
			request.getRequestDispatcher("page/guanli.jsp").forward(
					request, response);
		}else if("toUpdate".equals(type)){
			String id=request.getParameter("id");
			HouseService hs=new HouseServiceImpl();
			House h=new House();
			h.setId(Integer.parseInt(id));
			House house=hs.query(h, 1, 1).get(0);
			request.setAttribute("msg", house);
			request.getRequestDispatcher("page/fabu.jsp").forward(request,
					response);
		}else if("logout".equals(type)){
			request.getSession().removeAttribute("user");
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	}
	public Date strToDate(String houseDate){
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=sdf.parse(houseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}