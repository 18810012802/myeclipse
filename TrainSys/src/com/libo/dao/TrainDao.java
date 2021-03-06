package com.libo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.libo.entity.TrainInfo;
import com.libo.entity.TrainType;

public class TrainDao extends BaseDao {
	public JSONArray getTrainTypes() {
		JSONArray ja = new JSONArray();
		try {
			String sql = "select * from traintype ";
			getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				TrainType tt = new TrainType();
				tt.setId(rs.getInt(1));
				tt.setType(rs.getString(2));
				tt.setGroup(rs.getString(3));
				ja.add(tt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return ja;
	}

	/**
	 * 获取列车信息列表
	 * 
	 * @param sort
	 * @param order
	 * @param page
	 * @param pageSize
	 * @param u
	 * @return
	 */
	public Map<String, Object> getAllTrain(String sort, String order, int page,
			int pageSize, String train_no,String type) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<TrainInfo> list = new ArrayList<TrainInfo>();
		try {
			String sql = "select * from train_info ";

			if (train_no != null && !"".equals(train_no)
					&& !"null".equals(train_no)) {
				sql += " where train_no like '%" + train_no + "%'";
			}
			if (type != null && !"".equals(type)
					&& !"null".equals(type)) {
				sql += " where type = '" + type + "'";
			}
			sql += "order by " + sort + " " + order + " limit ?,?";
			getConnection();
			int first = pageSize * (page - 1);
			int total = getTotal(train_no,type);
			map.put("total", total);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, first);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				TrainInfo ti = new TrainInfo();
				ti.setTrain_no(rs.getString(1));
				ti.setStart_station(rs.getString(2));
				ti.setArrival_station(rs.getString(3));
				ti.setStart_time(rs.getString(4));
				ti.setArrival_time(rs.getString(5));
				ti.setType(rs.getString(6));
				ti.setRuntime(rs.getString(7));
				ti.setMile(rs.getDouble(8));
				ti.setNo(rs.getString(9));
				String station = rs.getString(2) + "--" + rs.getString(3);
				String time = rs.getString(4) + "--" + rs.getString(5);
				ti.setStation(station);
				ti.setTime(time);
				list.add(ti);
			}
			map.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return map;
	}

	/**
	 * 获取记录数
	 * 
	 * @param u
	 * @return
	 */
	public int getTotal(String u,String t) {
		int total = 0;
		String sql = "select count(*) from train_info where 1=1";
		if (u != null && !"".equals(u) && !"null".equals(u)) {
			sql += " and train_no like '%" + u + "%'";
		}
		if (t != null && !"".equals(t) && !"null".equals(t)) {
			sql += " and type = '" + t + "'";
		}
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			total = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 查看train_no记录是否已存在
	 * 
	 * @param train_no
	 * @return
	 */
	public int getTotalByTrainNo(String train_no) {
		int total = 0;
		String sql = "select count(*) from train_info where train_no = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, train_no);
			rs = pst.executeQuery();
			rs.next();
			total = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 添加记录
	 * 
	 * @param ti
	 * @return
	 */
	public int add(TrainInfo ti) {
		int rows = 0;
		getConnection();
		if (getTotalByTrainNo(ti.getTrain_no()) == 0) {
			String sql = "insert into train_info values(?,?,?,?,?,?,?,?,?)";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, ti.getTrain_no());
				String station[] = ti.getStation().split("--");
				String time[] = ti.getTime().split("--");
				pst.setString(2, station[0]);
				pst.setString(3, station[1]);
				pst.setString(4, time[0]);
				pst.setString(5, time[1]);
				pst.setString(6, ti.getType());
				String[] time1 = time[0].split(":");
				String[] time2 = time[1].split(":");
				int seconds = (Integer.parseInt(time2[0].trim()) * 60 + Integer
						.parseInt(time2[1].trim()))
						- (Integer.parseInt(time1[0].trim()) * 60 + Integer
								.parseInt(time1[1].trim()));
				String runtime = ((seconds) / 60) + ":" + ((seconds) % 60);
				ti.setRuntime(runtime);
				pst.setString(7, ti.getRuntime());
				pst.setDouble(8, ti.getMile());
				pst.setString(9, UUID.randomUUID().toString().replace("-", ""));
				rows = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}

	/**
	 * 修改记录
	 * 
	 * @param ti
	 * @return
	 */
	public int update(TrainInfo ti) {
		int rows = 0;
		getConnection();
		//if (getTotalByTrainNo(ti.getTrain_no()) == 0) {
			String sql = "update train_info set start_station=?,arrival_station=?,start_time=?,arrival_time=?,type=?,runtime=?,mile=?, train_no=? where no=?";
			try {
				pst = conn.prepareStatement(sql);
				String station[] = ti.getStation().split("--");
				String time[] = ti.getTime().split("--");
				pst.setString(1, station[0]);
				pst.setString(2, station[1]);
				pst.setString(3, time[0]);
				pst.setString(4, time[1]);
				pst.setString(5, ti.getType());
				String[] time1 = time[0].split(":");
				String[] time2 = time[1].split(":");
				int seconds = (Integer.parseInt(time2[0].trim()) * 60 + Integer
						.parseInt(time2[1].trim()))
						- (Integer.parseInt(time1[0].trim()) * 60 + Integer
								.parseInt(time1[1].trim()));
				String runtime = ((seconds) / 60) + ":" + ((seconds) % 60);
				ti.setRuntime(runtime);
				pst.setString(6, ti.getRuntime());
				pst.setDouble(7, ti.getMile());
				pst.setString(8, ti.getTrain_no());
				pst.setString(9, ti.getNo());
				rows = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		return rows;
	}

	/**
	 * 删除记录
	 * 
	 * @param ids
	 * @return
	 */
	public int delTrain(String[] ids) {
		int rows = 0;
		getConnection();
		String sql = "delete from train_info where no=?";
		try {
			for (String id : ids) {
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				rows += pst.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rows;
	}

	/*
	 * public List<TrainInfo> getAllTrain(){
	 * 
	 * }
	 * 
	 * public int delTrain(String[] trainId){
	 * 
	 * }
	 */
	public List<TrainInfo> findTrain(String no) {
		List<TrainInfo> list = new ArrayList<TrainInfo>();
		try {
			String sql = "select * from train_info where train_no = ? ";
			getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, no);
			rs = pst.executeQuery();
			while (rs.next()) {
				TrainInfo ti = new TrainInfo();
				ti.setTrain_no(rs.getString(1));
				ti.setStart_station(rs.getString(2));
				ti.setArrival_station(rs.getString(3));
				ti.setStart_time(rs.getString(4));
				ti.setArrival_time(rs.getString(5));
				ti.setType(rs.getString(6));
				ti.setRuntime(rs.getString(7));
				ti.setMile(rs.getDouble(8));
				ti.setNo(rs.getString(9));
				String station = rs.getString(2) + "--" + rs.getString(3);
				String time = rs.getString(4) + "--" + rs.getString(5);
				ti.setStation(station);
				ti.setTime(time);
				list.add(ti);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return list;
	}
}
