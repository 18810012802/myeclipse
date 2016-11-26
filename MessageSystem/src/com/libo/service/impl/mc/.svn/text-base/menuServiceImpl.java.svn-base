package com.libo.service.impl.mc;

import java.util.List;

import com.libo.dao.impl.mc.menuDaoImpl;
import com.libo.dao.mc.menuDao;
import com.libo.entity.Sys_menu;
import com.libo.service.mc.menuService;
import com.libo.util.PageSize;

public class menuServiceImpl implements menuService {

	//菜单管理
	menuDao menuDao=new menuDaoImpl();
	public List<Sys_menu> query(String name,int page,int pageSize) {
		
		return menuDao.query(name, page,PageSize.PAGE_SIZE);
	}
	//查询页数
	public int query(String name) {
		
		return menuDao.query(name);
	}

}
