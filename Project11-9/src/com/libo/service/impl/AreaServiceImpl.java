package com.libo.service.impl;

import java.util.List;

import com.google.gson.Gson;
import com.libo.dao.AreaDao;
import com.libo.dao.impl.AreaDaoImpl;
import com.libo.entity.Area;
import com.libo.service.AreaService;

public class AreaServiceImpl implements AreaService {
	AreaDao dao=new AreaDaoImpl();
	public String  selectArea(int pid) {
		List<Area> list=dao.selectArea(pid);
		Gson gs=new Gson();
		return gs.toJson(list);
	}

}
