package com.libo.dao;

import java.util.List;

import com.libo.po.Types;
import com.libo.util.HibernateUtil;

public class TypesDaoImpl implements TypesDao{

	@Override
	public List<Types> queryAll() {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession().createQuery("from Types").list();
	}

}