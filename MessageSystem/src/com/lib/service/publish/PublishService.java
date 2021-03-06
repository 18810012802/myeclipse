package com.lib.service.publish;

import java.util.List;
import java.util.Map;

import com.libo.entity.Msg_file_list;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.PublishDetail;

public interface PublishService {
	public List<Msg_manuscripts> queryManuscripts(int page, int pageSize,
			Map<String, String> condition);

	public int[] queryManuscriptsCount(int pageSize,
			Map<String, String> condition);

	public PublishDetail queryDetailById(int id);

	public List<Msg_file_list> queryFileList(int page, int pageSize,
			Map<String, String> condition);

	public int[] queryFileListCount(int pageSize, Map<String, String> condition);

	public Msg_file_list queryFileDetailById(int id);

	public String check(String table, String field, int value, int id);
	/**
	 * 根据约稿ID更改稿件状态信息
	 * @param maId
	 * @param flag
	 * @param state
	 * @return
	 */
	public String checkFile(int maId,String field,int value);
}
