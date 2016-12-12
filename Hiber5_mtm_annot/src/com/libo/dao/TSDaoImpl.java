package com.libo.dao;

import java.util.List;

import com.libo.po.Teacher;
import com.libo.util.HibernateUtil;

public class TSDaoImpl implements TSDao {

	@Override
	public List<Teacher> query(){
		return HibernateUtil.getSession().createCriteria(Teacher.class).list();
	}

	@Override
	public void add(Teacher t) {
		// TODO 自动生成的方法存根
		HibernateUtil.getSession().save(t);
		
	}

	

}
