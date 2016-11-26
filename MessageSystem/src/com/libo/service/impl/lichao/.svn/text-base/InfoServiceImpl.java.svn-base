package com.libo.service.impl.lichao;

import java.sql.Date;
import java.util.List;

import com.libo.dao.impl.lichao.InfoDaoImpl;
import com.libo.dao.lichao.InfoDao;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.lichao.InfoService;
import com.libo.util.PageSize;

public class InfoServiceImpl implements InfoService {
	InfoDao dao=new InfoDaoImpl();
	/**
	 * 发布稿件
	 */
	public int addinfo(String name, String number, String content,
			Date endDate, int uid,int state) {
		Msg_manuscripts msg=new Msg_manuscripts(name,number,content,endDate,uid,state);
		return dao.addInfo(msg);
	}
	/**
	 * 显示所有的稿件
	 */
	public List<Msg_manuscripts> queryInfo(int currentPage,String name,String number,Date newDate,Date endDate) {
		return dao.queryInfo(currentPage, PageSize.PAGE_SIZE,name,number,newDate,endDate);
	}
	/**
	 * 已经淘汰
	 * 获取总页数的方法
	 */
	public int getPageCout(String name,String number,Date newDate,Date endDate) {
		int rows= dao.getPageCout(null, null, null, null);
		int pageCount=0;
		if(rows%PageSize.PAGE_SIZE==0 ){
			pageCount=rows/PageSize.PAGE_SIZE;
		}else{
			pageCount=rows/PageSize.PAGE_SIZE+1;
		}
		return pageCount;
	}

	/**
	 * 获取文件id的放法
	 */
	public int getFileId() {
		return dao.getFileId();
	}


	/**
	 * 添加附件管理
	 */
	public int addFile(String fname, String path, String ftype, int mid ,int fid) {
		return dao.addFile(fname, path, ftype, mid,fid);
	}


	/**
	 * 删除稿件
	 */
	public int delInfo(int id) {
		return dao.delInfo(id);
	}


	/**
	 * 按id查询稿件
	 */
	public List<Msg_manuscripts> selectInfo(int id) {
		
		return dao.selectInfo(id);
	}


	/**
	 * 按照id修改稿件
	 */
	public int updateInfo(String name, String number, String content,
			Date endDate, int sendUserId, int state, int id) {
		Msg_manuscripts msg=new Msg_manuscripts(name, number, content, endDate, sendUserId, state, id);
		return dao.updateInfo(msg);
	}


	/**
	 * 已经淘汰
	 * 模糊查询稿件
	 */
	public List<Msg_manuscripts> queryInfoByLike(int currentPage, String name,
			String number, Date newDate, Date endDate) {
		
		return dao.queryInfo(currentPage, PageSize.PAGE_SIZE, name, number, newDate, endDate);
	}
	/**
	 * 获取总条数的方法
	 */
	public int getInfoCout(String name,String number,Date newDate,Date endDate) {
		
		return dao.getPageCout(name, number, newDate, endDate);
	}


	@Override
	public List<Msg_manuscripts> selectInfoByExcel(int id) {

		return dao.selectInfoByExcel(id);
	}
	@Override
	public String QueryFlieNmae(int mid, int fid) {
		
		return dao.QueryFlieNmae(mid, fid);
	}
}
