package com.libo.dao.impl.lichao;

import java.sql.SQLException;

import com.libo.dao.lichao.UserDao;

import com.libo.util.BaseDao;

public class UserDaoimpl extends BaseDao implements UserDao {

	@Override
	public String SelectUserName(int id) {
		String name="";
		String sql="SELECT username FROM org_employee WHERE id =?";
		getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

}
