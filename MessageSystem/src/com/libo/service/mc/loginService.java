package com.libo.service.mc;

import java.util.List;

import com.libo.entity.Org_employee;
import com.libo.entity.Sys_menu;

public interface loginService {
	// µÇÂ¼
	public Org_employee login(String loginName, String LoginPwd);

	// È¨ÏÞ
	public List<Sys_menu> selectMenu2(int oid);

	// config
	public String selectMenu(int oid);
}
