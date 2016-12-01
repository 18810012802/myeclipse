package com.libo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.libo.po.House;
import com.libo.util.HibernateUtil;

public class HouseDaoImpl implements HouseDao {
	public List<House> query(House house,int page,int size){
		  // 3.绑定参数的第三种方法：
      // setProperties();
      Session session = HibernateUtil.getSession();
      StringBuffer hql = new StringBuffer();
      hql.append("from House where 1=1");
	     if (house.getId() != null) {
	          hql.append(" and id=:id");
	      }
	     if (house.getTitle() != null&&!"".equals(house.getTitle().trim())) {
	    	 hql.append(" and title like '%"+house.getTitle()+"%'");
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
     //query.setParameter(0, "%"+house.getTitle()+"%");
      //设置完条件后
      query.setFirstResult((page-1)*size);
      query.setMaxResults(size);
      return query.list();
	}

	@Override
	public int count(House house) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		 StringBuffer hql = new StringBuffer();
	      hql.append("from House where 1=1");
	     if (house.getId() != null) {
	    	  hql.append(" and id=:id");
          }
	     if (house.getTitle() != null&&!"".equals(house.getTitle().trim())) {
	    	 hql.append(" and title like '%"+house.getTitle()+"%'");
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
		Session session=HibernateUtil.getSession();
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
}