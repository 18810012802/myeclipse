package com.libo.service.lichao;

import java.util.List;

import com.libo.entity.Msg_file;

public interface MsgFileService {
	public List<Msg_file> selectMinuteInfo(int currentPage,int maid,String title,String user);
	public int getMinute(int maid,String title,String user);
}
