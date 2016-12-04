package com.libo.dao;

import java.util.List;

import com.libo.po.District;

public interface DistrictDao {
	/**
	 * 查询所有区
	 * @return
	 */
	public List<District> queryAll();
}
