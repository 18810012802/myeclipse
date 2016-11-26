package com.libo.dao.lichao;

import java.sql.Date;
import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface InfoDao {
	/**
	 * 发布稿件
	 */
	public int addInfo(Msg_manuscripts ms);
	/**
	 * 显示所有的稿件
	 */
	public List<Msg_manuscripts> queryInfo(int currentPage,int pageSize,String name,String number,Date newDate,Date endDate);
	/**
	 * 获取总条数的方法
	 */
	public int getPageCout(String name,String number,Date newDate,Date endDate);
	/**
	 * 获取文件id的放法
	 */
	public int getFileId();
	/**
	 * 添加附件管理
	 */
	public int addFile(String fname,String path,String ftype,int mid,int fid);
	/**
	 * 删除稿件
	 */
	public int delInfo(int id);
	/**
	 * 按id查询稿件
	 */
	public List<Msg_manuscripts> selectInfo(int id );
	/**
	 * 按稿件id修改稿件
	 */
	public int updateInfo(Msg_manuscripts ms);
	/**
	 * 导出Excel查询稿件
	 */
	public List<Msg_manuscripts> selectInfoByExcel(int id );
	/**
	 * 查询附件名称
	 */
	public  String QueryFlieNmae(int mid ,int fid);
}
