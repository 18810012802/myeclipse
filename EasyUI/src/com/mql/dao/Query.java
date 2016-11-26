package com.mql.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mql.domain.User;

public class Query extends BaseDao {
	public int add(User user){
		int rows=0;
		getConnection();
		String sql = "insert into msg_manuscripts values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1,user.getUser());
			pst.setString(2,user.getEmail());
			
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	public int update(User user){
		int rows=0;
		getConnection();
		String sql = "update msg_manuscripts set name=?,number=? where id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,user.getUser());
			pst.setString(2,user.getEmail());
			pst.setString(3, user.getId()+"");
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rows);
		return rows;
	}
	public int delete(String[] ids){
		int rows=0;
		getConnection();
		String sql = "delete from msg_manuscripts where id=?";
		try {
			for(String id:ids){
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				rows+= pst.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return rows;
	}
	public Map<String, Object> queryUser(String sort, String order, int page,
			int pageSize, String u) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		try {
			String sql = "select id,name as user,number as email from msg_manuscripts ";
					
			if (u != null && !"".equals(u) && !"null".equals(u)) {
				sql += " where name like '%" + u + "%'";
			}
			sql += "order by "+ sort + " " + order+" limit ?,?";
			getConnection();
			int first = pageSize * (page - 1);
			int total = getTotal(u);
			map.put("total", total);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, first);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUser(rs.getString(2));
				user.setEmail(rs.getString(3));
				list.add(user);
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

	public String queryManuscripts(int page, int pageSize, String user) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		try {
			String sql = "select name as user,number as email  from msg_manuscripts limit ?,?";

			getConnection();
			int first = pageSize * (page - 1);
			int total = getTotal(user);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, first);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			sb.append("[{\"total\" : " + total + "},{\"rows\" : [");
			boolean b = false;
			while (rs.next()) {
				if (!b) {
					b = true;
				}
				sb.append("{\"user\" : \"" + rs.getString(1)
						+ "\",\"email\" : \"" + rs.getString(2) + "\"},");
			}
			if (b)
				sb = sb.deleteCharAt(sb.length() - 1);
			sb.append("]}]");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close();
		}
		return sb.toString();
	}

	public int getTotal(String u) {
		int total = 0;
		String sql = "select count(*) from msg_manuscripts";
		if (u != null && !"".equals(u) && !"null".equals(u)) {
			sql += " where name like '%" + u + "%'";
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
}
