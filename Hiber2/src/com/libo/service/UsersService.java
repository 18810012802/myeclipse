package com.libo.service;

import java.util.List;

import com.libo.po.Users;

public interface UsersService {
	public boolean login(Users users);
	public boolean add(Users users);
	public boolean ifExists(Users users);
	public Users queryUserByName(String name);
}
