package com.libo.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.libo.dao.TrainDao;
import com.libo.entity.TrainInfo;

public class TrainServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String t = request.getParameter("t");
		if("type".equals(t)){
			TrainDao ps = new TrainDao();
			JSONArray ja = ps.getTrainTypes();
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(ja.toString());
			pw.close();
		}else if ("look".equals(t)) {
			TrainDao ps = new TrainDao();
			String no=request.getParameter("train_no");
			response.setContentType("text/html;charset=utf-8");
			List<TrainInfo> list=ps.findTrain(no);
			request.setAttribute("msg", list.get(0));
			request.getRequestDispatcher("look.jsp").forward(request, response);
		}else if ("del".equals(t)) {
			TrainDao ps = new TrainDao();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String ids = request.getParameter("ids");
			String[] idss = ids.split(",");
			result = ps.delTrain(idss);
			pw.write(result + "");
			pw.close();
		} else if ("add".equals(t)) {
			TrainDao ps = new TrainDao();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String no = request.getParameter("no");
			String train_no = request.getParameter("train_no");
			String start_station = request.getParameter("start_station");
			String arrival_station = request.getParameter("arrival_station");
			String start_time = request.getParameter("start_time");
			String arrival_time = request.getParameter("arrival_time");
			String type = request.getParameter("type");
			String runtime = request.getParameter("runtime");
			String station = request.getParameter("station");
			String time = request.getParameter("time");
			Double mile = Double.parseDouble(request.getParameter("mile"));
			TrainInfo u = new TrainInfo();
			u.setNo(no);
			u.setTrain_no(train_no);
			u.setStart_station(start_station);
			u.setArrival_station(arrival_station);
			u.setStart_time(start_time);
			u.setArrival_time(arrival_time);
			u.setType(type);
			u.setRuntime(runtime);
			u.setMile(mile);
			u.setStation(station);
			u.setTime(time);
			result = ps.add(u);
			pw.write(result + "");
			pw.close();
		} else if ("update".equals(t)) {
			TrainDao ps = new TrainDao();
			int result = 0;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String no = request.getParameter("no");
			String train_no = request.getParameter("train_no");
			String start_station = request.getParameter("start_station");
			String arrival_station = request.getParameter("arrival_station");
			String start_time = request.getParameter("start_time");
			String arrival_time = request.getParameter("arrival_time");
			String type = request.getParameter("type");
			String runtime = request.getParameter("runtime");
			String station = request.getParameter("station");
			String time = request.getParameter("time");
			Double mile = Double.parseDouble(request.getParameter("mile"));
			TrainInfo u = new TrainInfo();
			u.setNo(no);
			u.setTrain_no(train_no);
			u.setStart_station(start_station);
			u.setArrival_station(arrival_station);
			u.setStart_time(start_time);
			u.setArrival_time(arrival_time);
			u.setType(type);
			u.setRuntime(runtime);
			u.setMile(mile);
			u.setStation(station);
			u.setTime(time);
			result = ps.update(u);
			pw.write(result + "");
			pw.close();
		} else {
			TrainDao ps = new TrainDao();
			int page = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("rows"));
			String sort = request.getParameter("sort");
			String order = request.getParameter("order");
			String train_no = request.getParameter("train_no");
			String trainType = request.getParameter("trainType");
			Map<String, Object> map = ps.getAllTrain(sort, order, page,
					pageSize, train_no,trainType);
			JSONObject jo = JSONObject.fromObject(map);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(jo.toString());
			pw.close();
		}

	}
}
