package com.libo.dao.mc;

import java.util.List;

import com.libo.entity.Sys_menu;

public interface menuDao {
	//�˵�����
	public List<Sys_menu> query(String name,int page,int pageSize);
	//��ҳ��
	public int query(String name);
}
