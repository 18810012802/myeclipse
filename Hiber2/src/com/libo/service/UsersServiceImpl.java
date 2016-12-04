package com.libo.service;

import java.util.List;

import com.libo.dao.UsersDao;
import com.libo.dao.UsersDaoImpl;
import com.libo.po.Users;

public class UsersServiceImpl implements UsersService {

	@Override
	public boolean add(Users users) {
		// TODO Auto-generated method stub
		UsersDao ud = new UsersDaoImpl();
		try {
			ud.add(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean ifExists(Users users) {
		// TODO Auto-generated method stub
		UsersDao ud = new UsersDaoImpl();
		if (ud.queryUsers(users).size() >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public Users queryUserByName(String name) {
		// TODO Auto-generated method stub
		UsersDao ud = new UsersDaoImpl();
		Users users = new Users();
		users.setName(name);
		List<Users> list = ud.queryUsers(users);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
