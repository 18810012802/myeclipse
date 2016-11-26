package com.libo.service.lichao;

import java.util.List;

import com.libo.entity.Msg_file;

public interface WaitInfoService {
	/**
	 * 查询所有未审核的稿件
	 */
	public List<Msg_file> selectWaitInfo(int currentPage,String name,String number,String title);
	/**
	 * 查询未审核稿件的总数
	 */
	public int getWaitInfoCount(String name,String number,String title);
	/**
	 * 按id查询位审核稿件的详情
	 */
	public List<Msg_file> selectWaitInfoById(int id);
	/**
	 * 审核稿件的方法
	 */
	public int checkWaitInfo(int id ,int state);
}
