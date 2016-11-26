package com.lib.dao.impl.t;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.dao.t.Org_employeeDao;
import com.libo.entity.Org_employee;
import com.libo.util.BaseDao;

public class Org_employeeDaoImpl extends BaseDao implements Org_employeeDao {

	@Override
	public List<Org_employee> selectAllByOid(int org) {
		List<Org_employee> list=new ArrayList<Org_employee>();
		try {
		String sql="select * from org_employee where id=?";
		getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1, org);
		rs=pst.executeQuery();
		while(rs.next()){
			Org_employee or=new Org_employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
			list.add(or);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

}
