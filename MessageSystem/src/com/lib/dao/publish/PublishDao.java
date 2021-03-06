package com.lib.dao.publish;

import java.util.List;
import java.util.Map;

import com.libo.entity.Msg_file_list;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.PublishDetail;

public interface PublishDao {
	/**
	 * 查询约稿信息
	 * 
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            分页大小
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public List<Msg_manuscripts> queryManuscripts(int page, int pageSize,
			Map<String, String> condition);

	/**
	 * 查询约稿记录条数
	 * 
	 * @param condition
	 * @return
	 */
	public int queryManuscriptsCount(Map<String, String> condition);

	/**
	 * 查询约稿详细信息
	 * 
	 * @param id
	 * @return
	 */
	public PublishDetail queryDetailById(int id);

	/**
	 * 查询稿件信息
	 * 
	 * @param page
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	public List<Msg_file_list> queryFileList(int page, int pageSize,
			Map<String, String> condition);

	/**
	 * 查询稿件记录条数
	 * 
	 * @param condition
	 * @return
	 */
	public int queryFileListCount(Map<String, String> condition);

	/**
	 * 查询稿件详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Msg_file_list queryFileDetailById(int id);

	/**
	 * 审核稿件或约稿
	 * 
	 * @param table
	 *            表名
	 * @param field
	 *            更改的字段名
	 * @param value
	 *            更改为
	 * @param id
	 *            更改的记录ID
	 * @return
	 */
	public String check(String table, String field, int value, int id);
	/**
	 * 根据约稿ID更改稿件状态信息
	 * @param maId
	 * @param flag
	 * @param state
	 * @return
	 */
	public boolean checkFile(int maId,String field,int value);

}
