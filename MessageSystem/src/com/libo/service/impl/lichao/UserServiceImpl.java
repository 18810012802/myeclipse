package com.libo.service.impl.lichao;

import com.libo.dao.impl.lichao.UserDaoimpl;
import com.libo.dao.lichao.UserDao;
import com.libo.service.lichao.UserService;

public class UserServiceImpl implements UserService {
	/**
	 * 获取用户真实姓名的方法
	 */
	UserDao dao =new UserDaoimpl();
	public String SelectUserName(int id) {

		return dao.SelectUserName(id);
	}

}
