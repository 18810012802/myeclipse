package com.libo.service.impl.t;

import java.util.List;

import com.lib.dao.impl.t.Msg_RecriveDaoImpl;
import com.lib.dao.impl.t.Msg_fileDaoImpl;
import com.lib.dao.impl.t.Org_employeeDaoImpl;
import com.lib.dao.t.Msg_ReceiveDao;
import com.lib.dao.t.Msg_fileDao;
import com.lib.dao.t.Org_employeeDao;
import com.lib.service.t.Msg_fileService;
import com.libo.entity.Msg_file;
import com.libo.entity.Msg_receive;
import com.libo.entity.Org_employee;
import com.libo.util.PageUtil;

public class Msg_fileServiceImpl implements Msg_fileService {
	Msg_fileDao mf=new Msg_fileDaoImpl();
	Msg_ReceiveDao mr=new Msg_RecriveDaoImpl();
	Org_employeeDao ms=new Org_employeeDaoImpl();

	public List<Msg_file> selectAllbyFid(int currentPage,
			String title, String type, String wordType) {
		List<Msg_file> msg=mf.selectAllbyFid(currentPage, PageUtil.PAGESIZE, title, type, wordType);
		return msg;
	}

	@Override
	public int selectAllbyFid() {
		List<Msg_file> ms=mf.selectAllbyFid();
		int inms=ms.size()/PageUtil.PAGESIZE;	
		return inms;
	}

	@Override
	public int selectAllbyFilid(String title, String type,
			String wordType) {
		List<Msg_file> msg=mf.selectAllbyFid(0, 0, title, type, wordType);
		int inms=msg.size();	
		return inms;
	}

	@Override
	public int addSPart(Msg_file msfil) {
		int rows=mf.addSPart(msfil);
		return rows;
	}

	@Override
	public int updSPart(Msg_file msfil, int id, int flag) {
		int rows=mf.updSPart(msfil, id, flag);
		return rows;
	}

	@Override
	public List<Msg_file> selectAllbyFid(int id) {
		List<Msg_file> msg=mf.selectAllbyFid(id);
		
		return msg;
	}

	@Override
	public int delSPart(int id) {
		int rows=mf.delSPart(id);
		return rows;
	}

	@Override
	public List<Msg_file> selectAllByMuch(int currentPage, int pageSize,
			String title, String author, String number, String name) {
		List<Msg_file> msg=mf.selectAllByMuch(currentPage, PageUtil.PAGESIZE, title, author, number, name);
		return msg;
	}

	@Override
	public int selectAllByMuch(String title, String author,
			String number, String name) {
		List<Msg_file> msg=mf.selectAllByMuch(0, 0, title, author, number, name);
		int mmsg=msg.size();
		return mmsg;
	}

	@Override
	public int addAll(Msg_file msfil) {
		int rows=mf.addAll(msfil);
		return rows;
	}

	@Override
	public List<Msg_file> selectAllbyFfid(int fid) {
		List<Msg_file> mmdd=mf.selectAllbyFfid(fid);
		return mmdd;
	}

}
