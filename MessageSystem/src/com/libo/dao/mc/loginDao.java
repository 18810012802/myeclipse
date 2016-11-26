package com.libo.dao.mc;

import java.util.List;

import com.libo.entity.Org_employee;
import com.libo.entity.Sys_menu;

public interface loginDao {
	//登录
	public Org_employee login(String loginName,String LoginPwd);
	//权限一级菜单
	public List<Sys_menu> selectMenu2(int oid);
	//权限二级菜单
	public List<Sys_menu> selectMenu(int oid);
	public Org_employee selByName(String name);
}
