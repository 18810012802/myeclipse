package com.libo.dao.impl.mc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.mc.menuDao;
import com.libo.entity.Sys_menu;
import com.libo.util.BaseDao;

public class menuDaoImpl extends BaseDao implements menuDao {

	//菜单管理
	public List<Sys_menu> query(String name,int page,int pageSize) {
		List<Sys_menu> list=new ArrayList<Sys_menu>();
		try {
			String sql="SELECT * FROM sys_menu ";
			if(name!=null){
				sql+="  WHERE menuname LIKE "+"'%"+name+"%'";
			}
			if(page>0&&pageSize>0){
				sql+="  limit  "+(page-1)*pageSize+","+pageSize;
			}
			getConnection();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Sys_menu menu=new Sys_menu(rs.getInt(1),rs.getDate(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(menu);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}


	//总页数
	public int query(String name) {
		int rows=0;
		try {
			getConnection();
			String sql="SELECT COUNT(id) FROM sys_menu";
			if(name!=null){
				sql+="   where menuname LIKE "+"'%"+name+"%'";
			}
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

}
