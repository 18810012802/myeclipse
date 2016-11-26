package com.libo.service.impl.lichao;

import java.util.List;

import com.libo.dao.impl.lichao.MsgFileDaoImpl;
import com.libo.dao.lichao.MsgFileDao;
import com.libo.entity.Msg_file;
import com.libo.service.lichao.MsgFileService;
import com.libo.util.PageSize;

public class MsgFileServiceImpl implements MsgFileService {
	MsgFileDao dao =new MsgFileDaoImpl();
	public List<Msg_file> selectMinuteInfo(int currentPage,int maid,String title,String user) {

		return dao.selectMinuteInfo(currentPage, PageSize.PAGE_SIZE, maid, title, user);
	}
	@Override
	public int getMinute(int maid, String title, String user) {
		return dao.getMinute(maid, title, user);
	}

}
