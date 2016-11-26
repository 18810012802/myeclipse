package com.libo.dao.lichao;

import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface YetInfoDao {
	/**
	 * 查询已审核的约稿
	 */
	public List<Msg_manuscripts> queryYetInfo(int currentPage,int pageSize,String name,String number);
	/**
	 * 获得已审核约稿的总数
	 */
	public int getYetInfoCount(String name,String number);
	/**
	 * 提交审核
	 */
	public int subCheck(int id );
	/**
	 * 导出execl查询已审核的稿件
	 */
	public List<Msg_manuscripts> selectYetInfoByExcel(int id );
	
}
