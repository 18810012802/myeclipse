package com.libo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.libo.po.House;
import com.libo.util.HibernateUtil;

public class HouseDaoImpl implements HouseDao {
	@Override
	public List<House> query(House house, int page, int size) {
		Session session = HibernateUtil.getSession();
		StringBuffer hql = new StringBuffer();
		hql.append("from House where 1=1");
		if (house.getId() != null) {
			hql.append(" and id=:id");
		}
		if (house.getTitle() != null && !"".equals(house.getTitle().trim())) {
			hql.append(" and title like '%" + house.getTitle() + "%'");
		}
		if (house.getMinFloorage() != null) {
			hql.append(" and floorage>:minFloorage");
		}
		if (house.getMaxFloorage() != null) {
			hql.append(" and floorage<=:maxFloorage");
		}
		if (house.getMinPrice() != null) {
			hql.append(" and price>:minPrice");
		}
		if (house.getMaxPrice() != null) {
			hql.append(" and price<=:maxPrice");
		}
		if (house.getTypes() != null) {
			hql.append(" and types=:types");
		}
		if (house.getStreet() != null) {
			hql.append(" and street=:street");
		}

		Query query = session.createQuery(hql.toString());
		query.setProperties(house);
		// query.setParameter(0, "%"+house.getTitle()+"%");
		// 设置完条件后
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		return query.list();
	}

	@Override
	public int count(House house) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		StringBuffer hql = new StringBuffer();
		hql.append("from House where 1=1");
		if (house.getId() != null) {
			hql.append(" and id=:id");
		}
		if (house.getTitle() != null && !"".equals(house.getTitle().trim())) {
			hql.append(" and title like '%" + house.getTitle() + "%'");
		}
		if (house.getId() != null) {
			hql.append(" and id=:id");
		}
		if (house.getMinFloorage() != null) {
			hql.append(" and floorage>:minFloorage");
		}
		if (house.getMaxFloorage() != null) {
			hql.append(" and floorage<=:maxFloorage");
		}
		if (house.getMinPrice() != null) {
			hql.append(" and price>:minPrice");
		}
		if (house.getMaxPrice() != null) {
			hql.append(" and price<=:maxPrice");
		}
		if (house.getTypes() != null) {
			hql.append(" and types=:types");
		}
		if (house.getStreet() != null) {
			hql.append(" and street=:street");
		}
		Query query = session.createQuery(hql.toString());
		query.setProperties(house);
		return query.list().size();
	}

	@Override
	public boolean publishHouse(House house) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			session.saveOrUpdate(house);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(House house) {
		// TODO Auto-generated method stub
		try {
			HibernateUtil.getSession().delete(house);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<House> queryCriteria(House house, int page, int size) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(House.class);
		if (house.getId() != null) {
			criteria.add(Restrictions.eq("id", house.getId()));
		}
		if (house.getTitle() != null && !"".equals(house.getTitle().trim())) {
			criteria.add(Restrictions.ilike("title", house.getTitle(),
					MatchMode.ANYWHERE));
		}
		if (house.getMinFloorage() != null) {
			criteria.add(Restrictions.gt("floorage", house.getMinFloorage()));
		}
		if (house.getMaxFloorage() != null) {
			criteria.add(Restrictions.lt("floorage", house.getMaxFloorage()));
		}
		if (house.getMinPrice() != null) {
			criteria.add(Restrictions.gt("price", house.getMinPrice()));
		}
		if (house.getMaxPrice() != null) {
			criteria.add(Restrictions.lt("price", house.getMaxPrice()));
		}
		if (house.getTypes() != null) {
			criteria.add(Restrictions.eq("types", house.getTypes()));
		}
		if (house.getStreet() != null) {
			criteria.add(Restrictions.eq("street", house.getStreet()));
		}
		criteria.setFirstResult((page - 1) * size);
		criteria.setMaxResults(size);
		return criteria.list();
	}

	@Override
	public int countCriteria(House house) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(House.class);

		if (house.getId() != null) {
			criteria.add(Restrictions.eq("id", house.getId()));
		}
		if (house.getTitle() != null && !"".equals(house.getTitle().trim())) {
			criteria.add(Restrictions.ilike("title", house.getTitle(),
					MatchMode.ANYWHERE));
		}
		if (house.getMinFloorage() != null) {
			criteria.add(Restrictions.gt("floorage", house.getMinFloorage()));
		}
		if (house.getMaxFloorage() != null) {
			criteria.add(Restrictions.lt("floorage", house.getMaxFloorage()));
		}
		if (house.getMinPrice() != null) {
			criteria.add(Restrictions.gt("price", house.getMinPrice()));
		}
		if (house.getMaxPrice() != null) {
			criteria.add(Restrictions.lt("price", house.getMaxPrice()));
		}
		if (house.getTypes() != null) {
			criteria.add(Restrictions.eq("types", house.getTypes()));
		}
		if (house.getStreet() != null) {
			criteria.add(Restrictions.eq("street", house.getStreet()));
		}
		return criteria.list().size();
	}
}
