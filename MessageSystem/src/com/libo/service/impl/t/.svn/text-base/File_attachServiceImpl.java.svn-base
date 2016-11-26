package com.libo.service.impl.t;

import java.util.List;

import com.lib.dao.impl.t.File_attachDaoImpl;
import com.lib.dao.impl.t.Msg_fileDaoImpl;
import com.lib.dao.t.File_attachDao;
import com.lib.dao.t.Msg_fileDao;
import com.lib.service.t.File_attachService;
import com.libo.dao.impl.lichao.InfoDaoImpl;
import com.libo.dao.lichao.InfoDao;
import com.libo.entity.File_attach;
import com.libo.service.lichao.InfoService;

public class File_attachServiceImpl implements File_attachService {
	File_attachDao fil=new File_attachDaoImpl();
	InfoDao info=new InfoDaoImpl();
	Msg_fileDao mf=new Msg_fileDaoImpl();
	
	public List<File_attach> selectAllByMenuId(int mid) {
		List<File_attach> f=fil.selectAllByMenuId(mid);
		return f;
	}

	@Override
	public int addAll(File_attach fil) {
		int rows=0;
		int fid=mf.selectFid();
		rows=info.addFile(fil.getName(), fil.getPath(), fil.getFiletype(), 3, fid);
		return rows;
	}

	@Override
	public File_attach selectAllByMFid(File_attach file) {
		File_attach lis=fil.selectAllByMFid(file);
		return lis;
	}

}
