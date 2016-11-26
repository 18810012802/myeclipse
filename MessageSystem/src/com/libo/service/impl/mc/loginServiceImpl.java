package com.libo.service.impl.mc;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.libo.dao.impl.mc.loginDaoImpl;
import com.libo.dao.mc.loginDao;
import com.libo.entity.Org_employee;
import com.libo.entity.Sys_menu;
import com.libo.service.mc.loginService;



public class loginServiceImpl implements loginService{

	//登录
	loginDao ld=new loginDaoImpl();
	public Org_employee login(String loginName, String LoginPwd) {
		return ld.login(loginName, LoginPwd);
	}
	//权限
	public List<Sys_menu> selectMenu2(int oid) {
		// TODO Auto-generated method stub
		return ld.selectMenu2(oid);
	}
	//config
	public String selectMenu(int oid) {
		List<Sys_menu> list=ld.selectMenu2(oid);//查出用户的一级权限
		JsonArray config1=new JsonArray();
		JsonObject config=new JsonObject();
		JsonArray menu=new JsonArray();
		for(int i=0;i<list.size();i++){
			List<Sys_menu> lt=ld.selectMenu(list.get(i).getId());
			JsonArray items=new JsonArray();
			for(int j=0;j<lt.size();j++){
				JsonObject jo=new JsonObject();
				jo.addProperty("id", lt.get(j).getId());
				jo.addProperty("text", lt.get(j).getMenuName());
				jo.addProperty("href", lt.get(j).getUrl());
				items.add(jo);	
			}
			JsonObject js=new JsonObject();
			js.addProperty("text", list.get(i).getMenuName());
			js.add("items", items);
			menu.add(js);	
		}
		config.addProperty("id", oid);
		config.add("menu", menu);
		config1.add(config);
		return  config1.toString();
	}
	
}
