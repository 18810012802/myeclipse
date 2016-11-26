package com.libo.service.impl.mc;

import com.libo.dao.impl.mc.addDaoImpl;
import com.libo.dao.mc.addDao;
import com.libo.service.mc.addService;

public class addServiceImpl implements addService {

	
	public int addMenu(String name, String url, int state) {
		addDao a=new addDaoImpl();
		return a.addMenu(name, url, state);
	}

}
