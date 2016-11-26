package com.libo.service.mc;

import java.util.List;

import com.libo.entity.Sys_menu;

public interface menuByidService {
	//查询所有的菜单,条件为id
		public Sys_menu selectMenu(int id);
}
