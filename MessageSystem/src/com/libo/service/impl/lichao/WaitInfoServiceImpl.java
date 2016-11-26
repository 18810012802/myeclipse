package com.libo.service.impl.lichao;

import java.util.List;

import com.libo.dao.impl.lichao.WaitInfoDaoimpl;
import com.libo.dao.lichao.WaitInfoDao;
import com.libo.entity.Msg_file;
import com.libo.service.lichao.WaitInfoService;
import com.libo.util.PageSize;

public class WaitInfoServiceImpl implements WaitInfoService {
	WaitInfoDao dao =new WaitInfoDaoimpl();
	/**
	 * 查询所有未审核的稿件
	 */
	public List<Msg_file> selectWaitInfo(int currentPage, 
			String name, String number, String title) {
		return dao.selectWaitInfo(currentPage, PageSize.PAGE_SIZE, name, number, title);
	}

	/**
	 * 查询未审核稿件的总数
	 */
	public int getWaitInfoCount(String name, String number, String title) {
		return dao.getWaitInfoCount(name, number, title);
	}

	/**
	 * 按id查询位审核稿件的详情
	 */
	public List<Msg_file> selectWaitInfoById(int id) {
		return dao.selectWaitInfoById(id);
	}

	/**
	 * 审核稿件的方法
	 */
	public int checkWaitInfo(int id, int state) {
		
		return dao.checkWaitInfo(id, state);
	}

}
