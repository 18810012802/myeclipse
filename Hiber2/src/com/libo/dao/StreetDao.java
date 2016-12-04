package com.libo.dao;

import java.util.List;

import com.libo.po.District;
import com.libo.po.Street;

public interface StreetDao {
	/**
	 * 查询所有街道信息
	 * @return
	 */
	public List<Street> queryAll();
	/**
	 * 查询指定区的街道信息
	 * @param district
	 * @return
	 */
	public List<Street> queryById(District district);
}
