package com.libo.dao;

import java.util.List;

import com.libo.po.District;
import com.libo.po.Street;
import com.libo.util.HibernateUtil;

public class StreetDaoImpl implements StreetDao {

	@Override
	public List<Street> queryAll() {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession().createQuery("from Street").list();
	}

	@Override
	public List<Street> queryById(District district) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("from Street where district=?")
				.setParameter(0, district).list();
	}

}
