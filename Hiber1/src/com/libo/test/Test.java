package com.libo.test;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.libo.po.TrainInfo;
import com.libo.utils.HibernateSessionUtil;

public class Test {
	public static void main(String[] args) {
		Session session=HibernateSessionUtil.getSession();
		
		
		
		Transaction tx=session.beginTransaction();
		TrainInfo ti2=(TrainInfo)session.load(TrainInfo.class,"dddd");
		//session.save(ti);
		TrainInfo ti=new TrainInfo();
		ti.setNo("ddddd");
		ti.setTrain_no(UUID.randomUUID().toString().replace("-", ""));
		ti.setArrival_station("ldiifo");
		ti.setArrival_time("12:13");
		ti.setStart_station("kkuhi");
		ti.setStart_time("10:10");
		ti.setRuntime("");
		ti.setTrain_no("dkuhwwv");
		ti.setMile(89);
		ti.setType("loihfowssw");
		//session.merge(ti);
		session.saveOrUpdate(ti);
		tx.commit();
		session.close();
	}
}