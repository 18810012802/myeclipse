package com.lib.serviceImpl;

import java.sql.Date;
import java.util.List;

//import util.PageUtil;

import com.lib.dao.impl.wang.Add_bookDaoImpl;
import com.lib.dao.wangchangcheng.Add_bookDao;
import com.lib.service.t.Add_bookService;
import com.libo.entity.Add_book;
import com.libo.util.PageUtil;



public class Add_bookServiceImpl extends Add_bookDaoImpl implements Add_bookService {
	Add_bookDao bookDao=new Add_bookDaoImpl();
	public int updateById(int createUserId, String name,String telphone, String sex, String birthday, String email,String address, int state) {
		Add_book book=new Add_book(now(),createUserId,name,telphone,sex,birthday,email,address,state);
		return bookDao.add(book);
	}
	private Date now() {
		// TODO Auto-generated method stub
		return now();
	}
	public int add(int createUserId, String name,String telphone, String sex, String birthday, String email,String address, int state) {
		Add_book book=new Add_book(now(),createUserId,name,telphone,sex,birthday,email,address,state);
		return bookDao.add(book);
	}
	public int deleteById(int id){
		return bookDao.deleteById(id);
		
	}
//	�ڲ�ͨѶ¼��ʾ������Ϣ
	 public List<Add_book> select(int currentPage,int userId){
		return bookDao.select(currentPage,PageUtil.PAGESIZE,userId);
		 
	 }
	 public List<Add_book> query(String str,int i){
		return bookDao.query(str,i);
	 }
	 public int UserCount() {
			int rows=bookDao.selectRows(0);
			int pageSize=0;
			if(rows%PageUtil.PAGESIZE==0){
				pageSize=rows/PageUtil.PAGESIZE;
			}else{
				pageSize=rows/PageUtil.PAGESIZE+1;
			}
			return pageSize;
		}
	 public Add_book selectById(int id){
		 return bookDao.selectById(id);
	 }
//		public List<news> userSelectNews(int currentPage,int topicId){
//			return newsdao.selectNews(currentPage,PageUtil.PAGESIZE,topicId);
//		}
//		@Override
//		public int userGetCount(int userId) {
//			// TODO Auto-generated method stub
//			int rows=bookDao.select(userId, 0, 0);
//			int pageSize=0;
//			if(rows%PageUtil.PAGESIZE==0){
//				pageSize=rows/PageUtil.PAGESIZE;
//			}else{
//				pageSize=rows/PageUtil.PAGESIZE+1;
//			}
//			return pageSize;
//		}
}
