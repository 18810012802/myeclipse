package com.libo.dao.impl.fan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.dao.fan.Sys_menuDao_fan;
import com.libo.entity.Sys_menu;

import com.libo.util.BaseDao;

public class Sys_menuDaoImpl_fan extends BaseDao implements Sys_menuDao_fan {

	@Override
	public List<Sys_menu> getAll() {
		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu menu = null;
		try {
		String sql = "select * from sys_menu";
		getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				menu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public List<Sys_menu> getSysMenuByName(String menuName) {
		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu menu = null;
		try {
		String sql = "select * from sys_menu";
		if(menuName!=null){
			sql+=" where menuName like ?";
		}
		getConnection();
			pst = conn.prepareStatement(sql);
			if(menuName!=null){
				pst.setString(1, "%"+menuName+"%");
			}
			rs = pst.executeQuery();
			while(rs.next()){
				menu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public int addSysMenu(Sys_menu sysMenu) {
		int count = 0;
		
		try {
		String sql ="insert into sys_menu(createDate,menuName,url,state,menuLevel) values(now(),?,?,?,0)";
		getConnection();	
			pst = conn.prepareStatement(sql);
			pst.setString(1, sysMenu.getMenuName());
			pst.setString(2, sysMenu.getUrl());
			pst.setInt(3, sysMenu.getState());
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}

	@Override
	public Sys_menu getSysMenuById(int id) {
		Sys_menu sysMenu=null;
		try {
		String sql = "select * from sys_menu where id = ?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				 sysMenu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return sysMenu;
	}

	@Override
	public int updateMenu(Sys_menu sysMenu) {
		int count = 0 ;
		try {
		String sql = "update sys_menu set menuName=?,url=?,state=? where id=?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, sysMenu.getMenuName());
			pst.setString(2, sysMenu.getUrl());
			pst.setInt(3, sysMenu.getState());
			pst.setInt(4, sysMenu.getId());
			count = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count ;
	}

	@Override
	public List<Sys_menu> getSysMenuByMenuLevel() {

		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu sysMenu = null;
		try {
		String sql = "select * from sys_menu where state=0 and menuLevel=0 and state=0";
		getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				sysMenu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
				list.add(sysMenu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public List<Sys_menu> getSysMenuBy() {
		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu sysMenu = null;
		try {
		String sql = "select * from sys_menu where state=0 and menuLevel>0 and state=0";
		getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				sysMenu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
				list.add(sysMenu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public List<Sys_menu> getMenuIdByRoleId(int roleId) {
		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu sysMenu = null;
		try {
		String sql = "SELECT menuId FROM org_role,org_rolemenumember,sys_menu WHERE org_role.`id`=org_rolemenumember.`roleId` "  
				     +"AND  org_rolemenumember.`menuId` = sys_menu.`id` AND org_role.`id`=?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, roleId);
			rs = pst.executeQuery();
			while(rs.next()){
				sysMenu = new Sys_menu();
				sysMenu.setId(rs.getInt("menuId"));
				list.add(sysMenu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public int getCount(String username) {
		int count =0;
		try {
		String sql = "select count(*) from sys_menu";
                if(username!=null){
			sql=sql+" where menuName like ? ";
		}
            getConnection();
			pst = conn.prepareStatement(sql);
			if(username!=null){
				pst.setString(1, "%"+username+"%");
			}
			rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}

	@Override
	public List<Sys_menu> getAllByPage(int pageNum, int pageSize, String username) {
		List<Sys_menu> list = new ArrayList<Sys_menu>();
		Sys_menu menu = null;
		try {
	     String sql = "select * from sys_menu";
	    if(username!=null){
	    	sql=sql+" where menuName like ? ";
	    }
	    sql=sql+" limit ?,?";
	    getConnection();
			pst = conn.prepareStatement(sql);
			if(username!=null){
				pst.setString(1, "%"+username+"%");
				pst.setInt(2, (pageNum-1)*pageSize);
				pst.setInt(3, pageSize);
			}
			else{
				pst.setInt(1, (pageNum-1)*pageSize);
				pst.setInt(2, pageSize);
			}
			rs = pst.executeQuery();
			while(rs.next()){
				menu = new Sys_menu(rs.getInt("id"), rs.getDate("createDate"), rs.getString("menuName"), rs.getString("url"), rs.getInt("state"), rs.getInt("menuLevel"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	@Override
	public List<Sys_menu> getALlByMenuId(Integer id, int i) {
		// TODO Auto-generated method stub
		List<Sys_menu> sysList=new ArrayList<Sys_menu>();
		Sys_menu sm=null;
		try {
		String sql="SELECT sm.id,sm.createDate,sm.menuname,sm.url,sm.state" +
				" FROM org_role r,org_rolemenumember rm,sys_menu sm" +
				" WHERE  r.`id`=rm.roleid AND sm.id=menuid AND r.`id`=? AND menulevel=?";
		getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, i);
			rs=pst.executeQuery();
			while(rs.next()){
				sm=new Sys_menu();
				sm.setId(rs.getInt("sm.id"));
				sm.setCreateDate(rs.getDate("sm.createDate"));
				sm.setMenuName(rs.getString("sm.menuname"));
				sm.setUrl(rs.getString("sm.url"));
				sm.setState(rs.getInt("sm.state"));
				sysList.add(sm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return sysList;
	}

	@Override
	public int updateSysMenu(int id) {
		int count = 0;
		try {
		String sql = "update sys_menu set state=1 where id = ?";
		getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return count;
	}

}
