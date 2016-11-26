package com.libo.dao.impl.mc;

import java.sql.SQLException;
import java.util.List;

import com.libo.dao.mc.menuByid;
import com.libo.entity.Sys_menu;
import com.libo.util.BaseDao;

public class menuByidDaoImpl extends BaseDao implements menuByid {

	/**
	 * 查询所有的菜单,条件id
	 */
	public Sys_menu selectMenu(int id) {
		Sys_menu menu=null;
		try {
			getConnection();
			String sql="SELECT * FROM sys_menu WHERE id="+id;
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				 menu=new Sys_menu(rs.getInt(1),rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return menu;
	}

}
