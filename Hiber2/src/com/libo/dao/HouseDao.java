package com.libo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.libo.po.House;
import com.libo.util.HibernateUtil;

public interface HouseDao {
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
	 * @return
	 */
	public int count(House house);
	/**
	 * 条件查询租房信息
	 * @param house
	 * @param page
	 * @param size
	 * @return
	 */
	public List<House> queryCriteria(House house,int page,int size);
	/**
	 * 条件查询租房记录条数
	 * @param house
	 * @return
	 */
	public int countCriteria(House house);
	/**
	 * 发布（添加或修改）租房信息
	 * @param house
	 * @return
	 */
	public boolean publishHouse(House house);
	/**
	 * 删除指定租房信息
	 * @param house
	 * @return
	 */
	public boolean delete(House house);
}
