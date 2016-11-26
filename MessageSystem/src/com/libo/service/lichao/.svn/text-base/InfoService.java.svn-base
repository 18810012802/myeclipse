package com.libo.service.lichao;

import java.sql.Date;
import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface InfoService {
	/**
	 * 发布稿件
	 */
	public int addinfo(String name,String number,String content,Date endDate,int uid,int state);
	/**
	 * 显示所有的稿件
	 */
	public List<Msg_manuscripts> queryInfo(int currentPage,String name,String number,Date newDate,Date endDate);
	/**
	 * 已经淘汰
	 * 获取总页数的方法
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
	public int updateInfo(String name,String number,String content,Date endDate,int sendUserid,int state,int id);
	/**
	 * 已经淘汰
	 * 模糊查询稿件
	 */
	public List<Msg_manuscripts> queryInfoByLike(int currentPage,String name,String number,Date newDate,Date endDate);
	/**
	 * 获取总条数的方法
	 */
	public int getInfoCout(String name,String number,Date newDate,Date endDate);
	/**
	 * 导出Excel查询稿件
	 */
	public List<Msg_manuscripts> selectInfoByExcel(int id );
	/**
	 * 查询附件名称
	 */
	public  String QueryFlieNmae(int mid ,int fid);
}
