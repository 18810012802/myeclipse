package com.libo.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.libo.po.Classes;
import com.libo.po.Students;
import com.libo.utils.HibernateUtil;


public class StuImpl implements StuDao {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		session.getTransaction().begin();
		/*Students s=new Students();
		Classes c=new Classes();
		Set<Students> ss=new HashSet<Students>();
		
		s.setAge(10);
		//s.setStuId(11);
		s.setStuName("1");
		c.setClsId(7);
		c.setClsName("七班");
		//s.setClasses(c);
		ss.add(s);
		c.setStudentses(ss);
		session.save(c);*/
		//String hql="from Students s where s.classes.clsId=:clsId";
		String hql="select distinct s from Students s inner join fetch s.classes c where c.clsId=:clsId";
		Query q=session.createQuery(hql);
		q.setInteger("clsId", 3);
		List list=q.list();
		//Students s=(Students)session.get(Students.class, 2);
		//System.out.println(s.getClasses());
		for(Iterator i=list.iterator();i.hasNext();){
			Object[] objs=(Object[])i.next();
			
			
			System.out.println(java.util.Arrays.toString(objs));
		}
		session.getTransaction().commit();
		session.close();
	}
	private void addStudents(List<Students> stus) throws Exception{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		for(int i=0;i<stus.size();i++){
			Students s1=stus.get(i);
			session.save(s1);
			if(i%20==0){
				session.flush();
				session.clear();
			}
			
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	private void updateStudents() throws Exception{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		ScrollableResults students=session.createQuery("from Students")
				.setCacheMode(CacheMode.IGNORE)
				.scroll(ScrollMode.FORWARD_ONLY);
		int count=0;
		while(students.next()){
			Students s=(Students)students.get(0);
			if(++count%20==0){
				session.flush();
				session.clear();
			}
			
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	private void updateStudents2() throws Exception{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hqlUpdate="update Students set name=:newName";
		int updateEntities=session.createQuery(hqlUpdate)
				.setString("newName","新名字")
				.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
	}
	private void deleteStudents() throws Exception{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hqlDelete="delete Students";
		int deletedEntities=session.createQuery(hqlDelete)
				.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Override
	public List<Students> queryAll(Students stu) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String hql="from Students";
		if(stu!=null&& stu.getStuId()!=null){
			hql+=" where stuId=:stuId";
		}
		Query q=session.createQuery(hql);
		q.setProperties(stu);
		List<Students> list=q.list();
		return list;
	}

	@Override
	public boolean delete(Students stu) {
		// TODO Auto-generated method stub
		try {
			HibernateUtil.getSession().delete(stu);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(Students stu) {
		// TODO Auto-generated method stub
		
		try {
			HibernateUtil.getSession().saveOrUpdate(stu);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Classes> queryAllClasses(Classes cla) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		String hql="from Classes";
		if(cla!=null&& cla.getClsId()!=null){
			hql+=" where clsId=:clsId";
		}
		Query q=session.createQuery(hql);
		q.setProperties(cla);
		List<Classes> list=q.list();
		return list;
	}
	
}