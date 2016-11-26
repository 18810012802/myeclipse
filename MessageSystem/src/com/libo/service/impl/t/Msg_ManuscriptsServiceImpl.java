package com.libo.service.impl.t;

import java.sql.Date;
import java.util.List;

import com.google.gson.Gson;
import com.lib.dao.impl.t.Msg_ManuscriptsDaoimpl;
import com.lib.dao.t.Msg_ManuscriptsDao;
import com.lib.service.t.Msg_ManuscriptsService;
import com.libo.entity.Msg_manuscripts;
import com.libo.util.PageUtil;

public class Msg_ManuscriptsServiceImpl implements Msg_ManuscriptsService {
	Msg_ManuscriptsDao ms=new Msg_ManuscriptsDaoimpl();
	
	public int selectAllByName(String name, String number) {
		List<Msg_manuscripts> msg=ms.selectAllByName(0, 0, name, number);
		int gg=msg.size();
		return gg;
	}

	@Override
	public List<Msg_manuscripts> selectAllByNam(int currPage, int pageSize, String name, String number) {
		List<Msg_manuscripts> msg=ms.selectAllByName(currPage, PageUtil.PAGESIZE, name, number);
		System.out.println(msg);
		return msg;
	}

	@Override
	public List<Msg_manuscripts> selectAll() {
		List<Msg_manuscripts> msg=ms.selectAll();
		return msg;
	}

	@Override
	public List<Msg_manuscripts> selectAllByMid(int msid) {
		List<Msg_manuscripts> msg=ms.selectAllByMid(msid);
		return msg;
	}

	@Override
	public List<Msg_manuscripts> selectAllByMidd(int currPage) {
		return ms.selectAllByMid(currPage, PageUtil.PAGESIZE);
	}

	@Override
	public List<Msg_manuscripts> selectAllByRMid(int currPage, int pageSize,
			int userid, String name, String number, Date sendDate, Date receDate) {
		List<Msg_manuscripts> msg=ms.selectAllByRMid(currPage, PageUtil.PAGESIZE, userid, name, number, sendDate, receDate);
		return msg;
	}

	@Override
	public int selectAllByRMid(int userid, String name,
			String number, Date sendDate, Date receDate) {
		List<Msg_manuscripts> msg=ms.selectAllByRMid(0, 0, userid, name, number, sendDate, receDate);
		int mmsg=msg.size();
		return mmsg;
	}

}
