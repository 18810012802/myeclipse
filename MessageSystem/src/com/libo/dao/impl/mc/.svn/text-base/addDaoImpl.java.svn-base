package com.libo.dao.impl.mc;
import com.libo.dao.mc.addDao;
import com.libo.util.BaseDao;

public class addDaoImpl extends BaseDao implements addDao {

	//Ìí¼Ó²Ëµ¥
	public int addMenu(String name,String url,int state) {
		int rows=0;
		try {
			getConnection();
			String sql="INSERT INTO sys_menu (menuname,url,state) VALUE(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, url);
			pst.setInt(3, state);
			rows=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

}
