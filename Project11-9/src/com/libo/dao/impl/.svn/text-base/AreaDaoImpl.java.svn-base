package com.libo.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.AreaDao;
import com.libo.entity.Area;
import com.libo.util.BaseDao;

public class AreaDaoImpl extends BaseDao implements AreaDao {

	@Override
	public List<Area> selectArea(int pid) {
		List<Area> list=new ArrayList<Area>();
		String sql="select * from areas where parent_id="+pid;
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Area area=new Area(rs.getInt(1),rs.getInt(2),rs.getString(3));
				list.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

}
