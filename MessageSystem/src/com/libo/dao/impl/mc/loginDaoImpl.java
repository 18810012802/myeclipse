package com.libo.dao.impl.mc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.mc.loginDao;
import com.libo.entity.Org_employee;
import com.libo.entity.Sys_menu;
import com.libo.util.BaseDao;

public class loginDaoImpl extends BaseDao implements loginDao {
			
	//登录
	public Org_employee login(String loginName, String LoginPwd) {
		Org_employee employee=null;
		try {
			String sql="select * from org_employee where loginname=? and loginpassword=? and state=0";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, LoginPwd);
			rs=pst.executeQuery();
			if(rs.next()){
			 employee=new Org_employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13));
				
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return employee;
	}

	//查权限
	public List<Sys_menu> selectMenu2(int oid) {
		List<Sys_menu> list=new ArrayList<Sys_menu>();
		try {
			StringBuffer sb=new StringBuffer();
			sb.append("SELECT DISTINCT sm.id,sm.createdate,sm.menuname,sm.url,sm.state,sm.menulevel FROM org_employee oe ,org_role orr,org_rolemenumember orgo,sys_menu sm  ");
			sb.append("WHERE orr.org_id=(SELECT roleid FROM org_employee WHERE id=? and state=0) AND orr.id=orgo.roleid AND orgo.menuid=sm.id  ");
			getConnection();
			pst=conn.prepareStatement(sb.toString());
			pst.setInt(1, oid);
			rs=pst.executeQuery();
			while(rs.next()){
				Sys_menu sys_menu=new Sys_menu(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(sys_menu);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	//权限二级菜单
	public List<Sys_menu> selectMenu(int oid) {
		List<Sys_menu>	list=new ArrayList<Sys_menu>();
		try {
			String sql="SELECT * FROM sys_menu WHERE menulevel=?";
			getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, oid);
			rs=pst.executeQuery();
			while(rs.next()){
				Sys_menu sys_menu=new Sys_menu(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(sys_menu);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public Org_employee selByName(String name) {
		Org_employee o=null;
		try {
			getConnection();
			String sql="SELECT * FROM org_employee WHERE loginname=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()){
				o=new Org_employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10), rs.getInt(11),rs.getInt(12), rs.getString(13));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}

}
