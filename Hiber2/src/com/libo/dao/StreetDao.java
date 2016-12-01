package com.libo.dao;

import java.util.List;

import com.libo.po.District;
import com.libo.po.Street;

public interface StreetDao {
	public List<Street> queryAll();
	public List<Street> queryById(District district);
}