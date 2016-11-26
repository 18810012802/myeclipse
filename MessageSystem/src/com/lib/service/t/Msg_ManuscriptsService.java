package com.lib.service.t;

import java.sql.Date;
import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface Msg_ManuscriptsService {
	public int selectAllByName(String name, String number);
	public List<Msg_manuscripts> selectAllByNam(int currPage, int pageSize, String name, String number);
	public List<Msg_manuscripts> selectAll();
	public List<Msg_manuscripts> selectAllByMid(int msid);
	public List<Msg_manuscripts> selectAllByMidd(int currPage);
	public List<Msg_manuscripts> selectAllByRMid(int currPage, int pageSize,int userid, String name, String number,Date sendDate , Date receDate);
	public int selectAllByRMid(int userid, String name, String number,Date sendDate , Date receDate);
}
