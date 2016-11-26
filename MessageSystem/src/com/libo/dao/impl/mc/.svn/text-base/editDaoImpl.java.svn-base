package com.libo.dao.impl.mc;

import java.sql.SQLException;

import com.libo.dao.mc.editDao;
import com.libo.util.BaseDao;

public class editDaoImpl extends BaseDao implements editDao {

	//±à¼­
	public int editMenu(String newname, String url, int state,int id) {
		int rows=0;
		try {
			getConnection();
			String sql="UPDATE sys_menu SET menuname=? , url=? , state=? WHERE id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newname);
			pst.setString(2, url);
			pst.setInt(3, state);
			pst.setInt(4, id);
			rows=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return rows;
	}

	//É¾³ý
	public int dell(int id) {
		int rows=0;
		try {
			getConnection();
			String sql="UPDATE sys_menu SET state=1 WHERE id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rows=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return rows;
	}

}
