package com.libo.service.impl.t;

import java.util.List;

import com.lib.dao.impl.t.Msg_RecriveDaoImpl;
import com.lib.dao.t.Msg_ReceiveDao;
import com.lib.service.t.Msg_ReceiveService;
import com.libo.entity.Msg_receive;

public class Msg_ReceiveServiceImpl implements Msg_ReceiveService {
	Msg_ReceiveDao msg=new Msg_RecriveDaoImpl();
	
	public int addRece(Msg_receive msRece) {
		int rows=msg.addRece(msRece);
		return rows;
	}

	@Override
	public List<Msg_receive> selectByUserId(int uid,int userid) {
		List<Msg_receive> list=msg.selectByUserId(uid, userid);
		return list;
	}
}
