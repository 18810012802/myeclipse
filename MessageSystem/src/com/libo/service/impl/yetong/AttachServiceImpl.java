package com.libo.service.impl.yetong;

import com.libo.dao.impl.yetong.AttachDaoImpl;
import com.libo.dao.yetong.AttachDao;
import com.libo.entity.Attach;

public class AttachServiceImpl {
	AttachDao dao = new AttachDaoImpl();

	public int addattach(Attach a) {
		// TODO Auto-generated method stub
		return dao.addattach(a);
	}

}
