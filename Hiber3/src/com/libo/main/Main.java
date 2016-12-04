package com.libo.main;

import org.hibernate.Session;

import com.libo.po.Customer;
import com.libo.po.Name;
import com.libo.utils.HibernateSessionFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		/*Carport cp=new Carport();
		cp.setLocation("青岛");
		cp.setSize(50);
		Car c=new Car();
		c.setBrand("宝马");
		c.setNumber("iuuhojou");
		c.setCarport(cp);
		cp.setCar(c);
		session.save(cp);*/
		Customer c=new Customer();
		Name n=new Name();
		c.setAge(90);
		c.setTel("oihfo");
		n.setFirstname("oeihf");
		n.setLastname("oidho");
		c.setName(n);
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

}
