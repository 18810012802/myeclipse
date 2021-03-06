package com.libo.test;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.libo.po.TrainInfo;
import com.libo.utils.HibernateSessionUtil;

public class Test {
	
	public static void main(String[] args) {
		 TrainInfo ti=new TrainInfo();
		 TrainInfo ti2=new TrainInfo();
		//session.save(ti);
		
		ti.setNo("hhhh");
		ti.setTrain_no(UUID.randomUUID().toString().replace("-", ""));
		ti.setArrival_station("ldidifo");
		ti.setArrival_time("12:13");
		ti.setStart_station("kkuerfqwdshi");
		ti.setStart_time("10:10");
		ti.setRuntime("");
		ti.setTrain_no("dkussfhwdwv");
		ti.setMile(89);
		ti.setType("loihfodswssw");
		//session.merge(ti);
		Session session=HibernateSessionUtil.getSession();
		session.beginTransaction();
		ti2=(TrainInfo)session.load(TrainInfo.class,"hhhh");
		//ti2=get("ddddd");
		//System.out.println(ti2.toString());
		session.saveOrUpdate(ti);
		//ti.setArrival_station("wwww");
		//merge(ti2);
		session.getTransaction().commit();
		session.close();
		//persist(ti);
		
	}
	/**
	 * 直接查询
	 * 不存在返回null
	 * @param id
	 * @return
	 */
	public static TrainInfo get(String id){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		TrainInfo ti=(TrainInfo)session.get(TrainInfo.class,id);
		tx.commit();
		session.close();
		return ti;
	}
	/**
	 * 延迟加载？
	 * 不存在则报错？
	 * @param session
	 * @param id
	 * @return
	 */
	public static TrainInfo load(Session session,String id){
		Transaction tx=session.beginTransaction();
		TrainInfo ti=(TrainInfo)session.load(TrainInfo.class,id);
		tx.commit();
		return ti;
	}
	/**
	 * 直接保存
	 * 不判断id是否存在
	 * @param ti
	 */
	public static void save(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		ti=(TrainInfo)session.get(TrainInfo.class, "hhhh");
		session.save(ti);
		tx.commit();
		session.close();
	}
	/**
	 * 直接保存
	 * 不判断id是否存在
	 * @param ti
	 */
	public static void persist(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		ti=(TrainInfo)session.get(TrainInfo.class, "hhhh");
		session.persist(ti);
		tx.commit();
		session.close();
	}
	/**
	 * id为空无操作
	 * id不存在报错
	 * @param ti
	 */
	public static void delete(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.delete(ti);
		tx.commit();
		session.close();
	}
	/**
	 * 不判断id是否存在
	 * 存在则修改，否则报错
	 * id为空也报错
	 * @param ti
	 */
	public static void update(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		ti=(TrainInfo)session.get(TrainInfo.class, "hhhh");
		session.update(ti);
		tx.commit();
		session.close();
	}
	/**
	 * 不判断id是否存在
	 * 存在则修改，否则报错
	 * id为空则添加
	 * @param ti
	 */
	public static void saveOrUpdate(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		ti=(TrainInfo)session.get(TrainInfo.class, "hhhh");
		session.saveOrUpdate(ti);
		tx.commit();
		session.close();
	}
	/**
	 * id为空直接添加
	 * id不为空就查询判断是否存在
	 * id不存在就添加
	 * id存在判断是否修改
	 * 如果有改变就修改
	 * 没有改变无操作
	 * @param ti
	 */
	public static void merge(TrainInfo ti){
		Session session=HibernateSessionUtil.getSession();
		Transaction tx=session.beginTransaction();
		ti=(TrainInfo)session.get(TrainInfo.class, "hhhh");
		session.merge(ti);
		tx.commit();
		session.close();
	}
	
}
