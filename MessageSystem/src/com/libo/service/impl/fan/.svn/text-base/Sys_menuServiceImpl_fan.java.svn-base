package com.libo.service.impl.fan;

import java.util.List;

import com.libo.dao.fan.Sys_menuDao_fan;
import com.libo.dao.impl.fan.Sys_menuDaoImpl_fan;
import com.libo.entity.Sys_menu;
import com.libo.service.fan.Sys_menuService_fan;

public class Sys_menuServiceImpl_fan implements Sys_menuService_fan {
	Sys_menuDao_fan dao=new Sys_menuDaoImpl_fan();
	@Override
	public List<Sys_menu> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Sys_menu> getSysMenuByName(String menuName) {
		// TODO Auto-generated method stub
		return dao.getSysMenuByName(menuName);
	}

	@Override
	public int addSysMenu(Sys_menu sysMenu) {
		// TODO Auto-generated method stub
		return dao.addSysMenu(sysMenu);
	}

	@Override
	public Sys_menu getSysMenuById(int id) {
		// TODO Auto-generated method stub
		return dao.getSysMenuById(id);
	}

	@Override
	public int updateMenu(Sys_menu sysMenu) {
		// TODO Auto-generated method stub
		return dao.updateMenu(sysMenu);
	}

	@Override
	public List<Sys_menu> getSysMenuByMenuLevel() {
		// TODO Auto-generated method stub
		return dao.getSysMenuByMenuLevel();
	}

	@Override
	public List<Sys_menu> getSysMenuBy() {
		// TODO Auto-generated method stub
		return dao.getSysMenuBy();
	}

	@Override
	public List<Sys_menu> getMenuIdByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return dao.getMenuIdByRoleId(roleId);
	}

	@Override
	public int getPagesBySize(int pageSize, String username) {
		int count = dao.getCount(username);
		if(count%pageSize==0){
			return count/pageSize;
		}else{
			return (count/pageSize)+1;
		}
	}

	@Override
	public List<Sys_menu> getAllByPage(int pageNum, int pageSize,
			String username) {
		// TODO Auto-generated method stub
		return dao.getAllByPage(pageNum, pageSize, username);
	}

	@Override
	public int getCount(String username) {
		// TODO Auto-generated method stub
		return dao.getCount(username);
	}

	@Override
	public List<Sys_menu> getALlByMenuId(Integer id, int i) {
		// TODO Auto-generated method stub
		return dao.getALlByMenuId(id, i);
	}

	@Override
	public int updateSysMenu(int id) {
		// TODO Auto-generated method stub
		return dao.updateSysMenu(id);
	}

}
