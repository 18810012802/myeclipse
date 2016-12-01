package com.libo.dao;

import java.util.List;

import com.libo.po.District;
import com.libo.util.HibernateUtil;

public class DistrictDaoImpl implements DistrictDao {

	@Override
	public List<District> queryAll() {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession().createQuery("from District").list();
	}
}
