package com.libo.service.mc;

import java.util.List;

import com.libo.entity.Sys_menu;

public interface menuService {
	//菜单管理
		public List<Sys_menu> query(String name,int page,int pageSize);
		//总页数
		public int query(String name);
}
