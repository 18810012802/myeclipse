package com.mql.dao;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TreeListDao extends BaseDao{

	public JSONArray query(int id){
		JSONArray ja=new JSONArray();
		String sql="select id,text,state from tree_list where tid=?";
		try {
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				JSONObject jb=new JSONObject();
				jb.put("id", rs.getInt(1));
				jb.put("text", rs.getString(2));
				jb.put("state", rs.getString(3));
				ja.add(jb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
	}
}
