package com.libo.dao;

import java.util.List;

import org.hibernate.Query;

import com.libo.po.Users;

public interface UsersDao {
	/**
	 * 查询用户信息
	 * @param users
	 * @return
	 */
	public List<Users> queryUsers(Users users);
	/**
	 *注册用户
	 * @param users
	 * @return
	 */
	public int add(Users users);
}
