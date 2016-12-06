package com.libo.service;

import java.util.List;

import com.libo.dao.StuDao;
import com.libo.dao.StuImpl;
import com.libo.po.Classes;
import com.libo.po.Students;


public class StuServiceImpl implements StuService {

	@Override
	public List<Students> queryAll(Students stu) {
		// TODO Auto-generated method stub
		StuDao sd=new StuImpl();
		return sd.queryAll(stu);
	}

	@Override
	public boolean delete(Students stu) {
		// TODO Auto-generated method stub
		StuDao sd=new StuImpl();
		return sd.delete(stu);
	}

	@Override
	public boolean saveOrUpdate(Students stu) {
		// TODO Auto-generated method stub
		StuDao sd=new StuImpl();
		return sd.saveOrUpdate(stu);
	}

	@Override
	public List<Classes> queryAllClasses(Classes cla) {
		// TODO Auto-generated method stub
		StuDao sd=new StuImpl();
		return sd.queryAllClasses(cla);
	}

}
