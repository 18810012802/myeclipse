package com.libo.service;

import java.util.List;

import com.libo.dao.DistrictDao;
import com.libo.dao.DistrictDaoImpl;
import com.libo.dao.HouseDao;
import com.libo.dao.HouseDaoImpl;
import com.libo.dao.StreetDao;
import com.libo.dao.StreetDaoImpl;
import com.libo.dao.TypesDao;
import com.libo.dao.TypesDaoImpl;
import com.libo.po.District;
import com.libo.po.House;
import com.libo.po.Street;
import com.libo.po.Types;

public class HouseServiceImpl implements HouseService {

	@Override
	public List<House> query(House house, int page, int size) {
		// TODO Auto-generated method stub
		HouseDao hd = new HouseDaoImpl();
		//List<House> list = hd.query(house, page, size);
		List<House> list = hd.queryCriteria(house, page, size);
		return list;
	}

	@Override
	public int count(House house, int size) {
		// TODO Auto-generated method stub
		HouseDao hd = new HouseDaoImpl();
		//int count = hd.count(house);
		int count = hd.countCriteria(house);
		int c = (count % size == 0) ? count / size : (count / size) + 1;
		return c;
	}

	@Override
	public List<Types> queryTypes() {
		// TODO Auto-generated method stub
		TypesDao td = new TypesDaoImpl();
		return td.queryAll();
	}

	@Override
	public List<Street> queryStreet() {
		// TODO Auto-generated method stub
		StreetDao sd = new StreetDaoImpl();
		return sd.queryAll();
	}

	@Override
	public List<District> queryDistrict() {
		// TODO Auto-generated method stub
		DistrictDao sd = new DistrictDaoImpl();
		return sd.queryAll();
	}

	@Override
	public House queryHouseById(int id) {
		// TODO Auto-generated method stub
		HouseDao hd = new HouseDaoImpl();
		House house = new House();
		house.setId(id);
		//return hd.query(house, 1, 1).get(0);
		return hd.queryCriteria(house, 1, 1).get(0);
	}

	@Override
	public boolean publishHouse(House house) {
		// TODO Auto-generated method stub
		HouseDao hd = new HouseDaoImpl();
		return hd.publishHouse(house);
	}

	@Override
	public List<Street> queryStreetById(int did) {
		// TODO Auto-generated method stub
		StreetDao sd = new StreetDaoImpl();
		District d = new District();
		d.setId(did);
		return sd.queryById(d);
	}

	@Override
	public void delete(House house) {
		// TODO Auto-generated method stub
		HouseDao hd = new HouseDaoImpl();
		hd.delete(house);
	}

}
