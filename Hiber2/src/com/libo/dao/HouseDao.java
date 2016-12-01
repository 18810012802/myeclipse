package com.libo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.libo.po.House;
import com.libo.util.HibernateUtil;

public interface HouseDao {
	public List<House> query(House house,int page,int size);
	public int count(House house);
	public boolean publishHouse(House house);
	public boolean delete(House house);
}
