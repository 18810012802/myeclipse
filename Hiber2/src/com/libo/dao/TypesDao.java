package com.libo.dao;

import java.util.List;

import com.libo.po.Types;

public interface TypesDao {
	/**
	 * 查询所有租房类型
	 * @return
	 */
	public List<Types> queryAll();
}
