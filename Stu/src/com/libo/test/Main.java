package com.libo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.libo.interceptor.MyInterceptor;

public class Main {

	static Configuration cfg=new Configuration()
	.configure()
	.setInterceptor(new MyInterceptor());
	static SessionFactory sf=cfg.buildSessionFactory();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}


}
