package com.libo.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionUtil {

	public static SessionFactory sessionFactory=null;
	private HibernateSessionUtil(){
	}
	private static synchronized void syncInit(){//在创建类时进行同步
	     if(sessionFactory==null){
	    	//1.读取这个核心配置文件[配置文件叫hibernate.cfg.xml/在src下]
	 		Configuration config=new Configuration().configure();
	 		//2.获取配置信息
	 		Properties pros=config.getProperties();
	 		//3.注册服务。
	 		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
	 		builder.applySettings(pros);
	 		//4.获取sessionfactory 
	 		sessionFactory=config.buildSessionFactory(builder.buildServiceRegistry());
	     }
	}
	public static SessionFactory getSessionFactory(){//静态方法创建实例
	     if(sessionFactory==null){
	     syncInit();
	     }
	     return sessionFactory;
	}
	public static Session getSession(){
		//5.获取session对象
		Session session=getSessionFactory().openSession();//打开数据库连接
		return session;
	}
}
