package com.libo.dao;

import java.util.List;

import org.hibernate.Query;

import com.libo.po.Users;

public interface UsersDao {
	public List<Users> queryUsers(Users users);
	public int add(Users users);
}