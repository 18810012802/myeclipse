package com.film.dao;

import java.util.List;

import com.film.po.Filminfo;
import com.film.vo.FilminfoVO;

public interface FilmDao {
	public List query();
	public void add(Filminfo t);
	public String queryFilmTypes();
	public List queryCre(FilminfoVO fi);
}
