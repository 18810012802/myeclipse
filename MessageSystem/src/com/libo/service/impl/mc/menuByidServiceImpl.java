package com.libo.service.impl.mc;

import java.util.List;

import com.libo.dao.impl.mc.menuByidDaoImpl;
import com.libo.dao.mc.menuByid;
import com.libo.entity.Sys_menu;
import com.libo.service.mc.menuByidService;

public class menuByidServiceImpl implements menuByidService {

	/**
	 * ��ѯ�˵�,����Ϊid
	 */
	public Sys_menu selectMenu(int id) {
		menuByid byid=new menuByidDaoImpl();
		return byid.selectMenu(id);
	}

}
