package com.libo.service.impl.mc;

import com.libo.dao.impl.mc.editDaoImpl;
import com.libo.dao.mc.editDao;
import com.libo.service.mc.editServi;

public class editServiceImpl implements editServi {

	//�༭
	editDao e=new editDaoImpl();
	public int editMenu(String newname, String url, int state, int id) {
		
		return e.editMenu(newname, url, state, id);
	}
	//ɾ��
	public int dell(int id) {
		
		return e.dell(id);
	}
	

}
