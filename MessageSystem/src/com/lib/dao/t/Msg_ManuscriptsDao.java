package com.lib.dao.t;

import java.sql.Date;
import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface Msg_ManuscriptsDao {
	public List<Msg_manuscripts> selectAllByName(int currPage, int pageSize, String name, String number);
	public List<Msg_manuscripts> selectAll();
	public List<Msg_manuscripts> selectAllByMid(int msid);
	public Msg_manuscripts selectAllByMdid(int msid);
	public List<Msg_manuscripts> selectAllByMid(int currPage,int pageSize);
	public List<Msg_manuscripts> selectAllByRMid(int currPage, int pageSize,int userid, String name, String number,Date sendDate , Date receDate);
}
