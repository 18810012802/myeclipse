package com.libo.service;

import java.util.List;

import com.libo.po.District;
import com.libo.po.House;
import com.libo.po.Street;
import com.libo.po.Types;

public interface HouseService {
	/**
	 * 查询租房信息
	 * @param house
	 * @param page
	 * @param size
	 * @return
	 */
	public List<House> query(House house,int page,int size);
	/**
	 * 查询租房记录条数
	 * @param house
	 * @param size
	 * @return
	 */
	public int count(House house,int size);
	/**
	 * 查询租房类型
	 * @return
	 */
	public List<Types> queryTypes();
	/**
	 * 查询所有街道类型
	 * @return
	 */
	public List<Street> queryStreet();
	/**
	 * 查询指定街道类型
	 * @param did
	 * @return
	 */
	public List<Street> queryStreetById(int did);
	/**
	 * 根据id查询指定租房信息
	 * @param id
	 * @return
	 */
	public House queryHouseById(int id);
	/**
	 * 查询所有区
	 * @return
	 */
	public List<District> queryDistrict();
	/**
	 * 发布（修改或添加）租房信息
	 * @param house
	 * @return
	 */
	public boolean publishHouse(House house);
	/**
	 * 删除指定租房信息
	 * @param house
	 */
	public void delete(House house);
}
