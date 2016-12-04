package com.libo.service;

import java.util.List;

import com.libo.po.Users;

public interface UsersService {
	/**
	 * 注册用户
	 * @param users
	 * @return
	 */
	public boolean add(Users users);
	/**
	 * 查询用户是否存在
	 * @param users
	 * @return
	 */
	public boolean ifExists(Users users);
	/**
	 * 根据用户名查询指定用户
	 * @param name
	 * @return
	 */
	public Users queryUserByName(String name);
}
