package com.lib.service.publish;

import java.util.List;
import java.util.Map;

import com.lib.dao.publish.PublishDao;
import com.lib.dao.publish.PublishDaoImpl;
import com.libo.entity.Msg_file_list;
import com.libo.entity.Msg_manuscripts;
import com.libo.entity.PublishDetail;

public class PublishServiceImpl implements PublishService {

	@Override
	public List<Msg_manuscripts> queryManuscripts(int page, int pageSize,
			Map<String, String> condition) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		return pd.queryManuscripts(page, pageSize, condition);
	}

	@Override
	public int[] queryManuscriptsCount(int pageSize,
			Map<String, String> condition) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		int count = pd.queryManuscriptsCount(condition);
		return new int[] {
				count % pageSize == 0 ? count / pageSize : count / pageSize + 1,
				count };
	}

	public PublishDetail queryDetailById(int id) {
		PublishDao pd = new PublishDaoImpl();
		return pd.queryDetailById(id);
	}

	@Override
	public List<Msg_file_list> queryFileList(int page, int pageSize,
			Map<String, String> condition) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		return pd.queryFileList(page, pageSize, condition);
	}

	@Override
	public int[] queryFileListCount(int pageSize, Map<String, String> condition) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		int count = pd.queryFileListCount(condition);
		return new int[] {
				count % pageSize == 0 ? count / pageSize : count / pageSize + 1,
				count };
	}

	@Override
	public Msg_file_list queryFileDetailById(int id) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		return pd.queryFileDetailById(id);
	}

	@Override
	public String check(String table, String field, int value, int id) {
		// TODO Auto-generated method stub
		PublishDao pd = new PublishDaoImpl();
		return pd.check(table, field, value, id);
	}

	@Override
	public String checkFile(int maId,String field,int value) {
		// TODO Auto-generated method stub
		PublishDao pd=new PublishDaoImpl();
		if(pd.checkFile(maId,field,value)){
			return "�����ɹ���";
		}
		return "����ʧ�ܣ�";
	}

}
