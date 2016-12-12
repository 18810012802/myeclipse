package com.film.dao;

import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.util.json.JSONArray;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import com.film.po.Filminfo;
import com.film.vo.FilminfoVO;
import com.libo.util.HibernateUtil;

public class FilmDaoImpl implements FilmDao {

	@Override
	public List<Filminfo> query() {
		Session session=HibernateUtil.getSession();
		List<Filminfo> list=session.createSQLQuery("select filmid,filmname,actor,director,typeid,ticketprice from filminfo")
                .addEntity(Filminfo.class)
                //.setInteger("stuId", 2)
                .list();
		return list;
	}

	@Override
	public void add(Filminfo fi) {
		Session session=HibernateUtil.getSession();
		session.save(fi);
	}

	@Override
	public String queryFilmTypes() {
		Session session=HibernateUtil.getSession();
		List<Map> list=session.createSQLQuery("select * from filmtype")
				/*.addScalar("filmname",StandardBasicTypes.STRING)
	            .addScalar("actor",StandardBasicTypes.STRING)
	            .addScalar("director",StandardBasicTypes.STRING)
	            .addScalar("typeId",StandardBasicTypes.INTEGER)*/
				.addScalar("typeId",StandardBasicTypes.INTEGER)
	            .addScalar("typeName",StandardBasicTypes.STRING)
	            .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
	            .list();
		JSONArray ja=new JSONArray();
		for(Map m:list){
			ja.put(m);
		}
		return ja.toString();
	}

	@Override
	public List queryCre(FilminfoVO fi) {
		Session session=HibernateUtil.getSession();
		Criteria c=session.createCriteria(Filminfo.class);
		if(fi.getFilmname()!=null){
			c.add(Restrictions.ilike("filmname", fi.getFilmname(), MatchMode.ANYWHERE));
		}
		if(fi.getActor()!=null){
			c.add(Restrictions.ilike("actor", fi.getActor(), MatchMode.ANYWHERE));
		}
		if(fi.getDirector()!=null){
			c.add(Restrictions.ilike("director", fi.getDirector(), MatchMode.ANYWHERE));
		}
		if(fi.getFilmtype()!=null&&fi.getFilmtype().getTypeid()!=null&&fi.getFilmtype().getTypeid()!=0){
			c.add(Restrictions.eq("filmtype.typeid", fi.getFilmtype().getTypeid()));
		}
		if(fi.getMaxticketprice()!=null){
			c.add(Restrictions.lt("ticketprice", fi.getMaxticketprice()));
		}
		if(fi.getMinticketprice()!=null){
			c.add(Restrictions.gt("ticketprice", fi.getMinticketprice()));
		}
		return c.list();
	}

}
