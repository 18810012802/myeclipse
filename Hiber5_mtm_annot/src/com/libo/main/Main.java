package com.libo.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.libo.po.Student;
import com.libo.po.Teacher;
import com.libo.util.HibernateUtil;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Teacher t=new Teacher();
		t.setTname("t12");
		Student s1=new Student();
		s1.setSname("S11");
		Student s2=new Student();
		s2.setSname("S21");
		Student s3=new Student();
		s3.setSname("S31");
		//s1.getTeachers().add(t);
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		t.getStudents().add(s3);
		session.save(t);
		tx.commit();
		session.close();
		
	}
}