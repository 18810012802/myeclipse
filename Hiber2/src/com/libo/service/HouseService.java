package com.libo.service;

import java.util.List;

import com.libo.po.District;
import com.libo.po.House;
import com.libo.po.Street;
import com.libo.po.Types;

public interface HouseService {
	public List<House> query(House house,int page,int size);
	public int count(House house,int size);
	public List<Types> queryTypes();
	public List<Street> queryStreet();
	public List<Street> queryStreetById(int did);
	public House queryHouseById(int id);
	public List<District> queryDistrict();
	public boolean publishHouse(House house);
	public void delete(House house);
}
