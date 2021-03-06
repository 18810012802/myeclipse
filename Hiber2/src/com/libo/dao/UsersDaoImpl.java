package com.libo.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.libo.po.Users;
import com.libo.util.HibernateUtil;

public class UsersDaoImpl implements UsersDao {
	@Override
	public List<Users> queryUsers(Users users) {
		StringBuffer sb = new StringBuffer("from Users u where 1=1");
		if (users.getId() != null) {
			sb.append(" and u.id=:id");
		}
		if (StringUtils.isNotEmpty(users.getName())) {
			sb.append(" and u.name=:name");
		}
		if (StringUtils.isNotEmpty(users.getPassword())) {
			sb.append(" and u.password=:password");
		}
		Query query = HibernateUtil.getSession().createQuery(sb.toString());
		query.setProperties(users);
		return query.list();
	}

	@Override
	public int add(Users users) {
		// TODO Auto-generated method stub
		Integer id = (Integer) HibernateUtil.getSession().save(users);
		return id;
	}

}
