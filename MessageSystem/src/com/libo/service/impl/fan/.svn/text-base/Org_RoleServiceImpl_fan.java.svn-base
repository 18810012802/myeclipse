package com.libo.service.impl.fan;

import java.util.List;

import com.libo.dao.fan.Org_RoleDao_fan;
import com.libo.dao.impl.fan.Org_RoleDaoImpl_fan;
import com.libo.entity.Org_role;

import com.libo.service.fan.Org_RoleService_fan;

public class Org_RoleServiceImpl_fan implements Org_RoleService_fan {

	Org_RoleDao_fan roDao = new Org_RoleDaoImpl_fan();
	public List<Org_role> getAll() {
		return roDao.getAll();
	}
	@Override
	public List<Org_role> getRoleByRoName(String roleName) {
		return roDao.getRoleByRoName(roleName);
	}
	@Override
	public int deleteByid(int id) {
		return roDao.deleteByid(id);
	}
	@Override
	public int addRole(Org_role role) {
		// TODO Auto-generated method stub
		return roDao.addRole(role);
	}
	@Override
	public int addPerm(int menuId, int roleId) {
		// TODO Auto-generated method stub
		return roDao.addPerm(menuId, roleId);
	}
	@Override
	public Org_role getRoleByid(int id) {
		// TODO Auto-generated method stub
		return roDao.getRoleByid(id);
	}
	@Override
	public int deletePerm(int id) {
		// TODO Auto-generated method stub
		return roDao.deletePerm(id);
	}
	@Override
	public int updateRole(Org_role orgRole) {
		// TODO Auto-generated method stub
		return roDao.updateRole(orgRole);
	}
	@Override
	public int getPagesBySize(int pageSize, String rolename) {
		int count = roDao.getCount(rolename);
		if(count%pageSize==0){
			return count/pageSize;
		}else{
			return (count/pageSize)+1; 	
			
		}
	}
	@Override
	public List<Org_role> getAllByPage(int pageNum, int pageSize,
			String rolename) {
		// TODO Auto-generated method stub
		return roDao.getAllByPage(pageNum, pageSize, rolename);
	}
	@Override
	public int getCount(String rolename) {
		// TODO Auto-generated method stub
		return roDao.getCount(rolename);
	}
	@Override
	public int updateOrgRoleById(int id) {
		// TODO Auto-generated method stub
		return roDao.updateOrgRoleById(id);
	}

}
