package com.libo.service.impl.fan;

import java.util.List;

import com.libo.dao.fan.Org_EmployeeDao_fan;
import com.libo.dao.impl.fan.Org_EmployeeDaoImpl_fan;
import com.libo.entity.Org_employee;
import com.libo.service.fan.Org_EmployeeService_fan;

public class Org_EmployeeServiceImpl_fan implements Org_EmployeeService_fan {
	Org_EmployeeDao_fan dao=new Org_EmployeeDaoImpl_fan();

	

	/**
	 * 查询
	 * @param username
	 * @return
	 */
	public List<Org_employee> selectOrg() {
		
		return dao.selectOrg();
	}



	@Override
	public List<Org_employee> getAllByPage(int pageNum, int pageSize,
			String username) {
		
		return dao.getAllByPage(pageNum, pageSize, username);
	}


	/**
	 * 
	 * 获取查询数据的条数
	 */
	@Override
	public int getCount(String username) {
		
		return dao.getCount(username);
	}



	@Override
	public int deleteOrgEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteOrgEmployee(id);
	}



	@Override
	public List<Org_employee> getAllByInput(String input) {
		// TODO Auto-generated method stub
		return dao.getAllByInput(input);
	}



	@Override
	public int addOrgEmployee(Org_employee orgEmployee) {
		// TODO Auto-generated method stub
		return dao.addOrgEmployee(orgEmployee);
	}



	@Override
	public Org_employee getOrgEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getOrgEmployeeById(id);
	}



	@Override
	public int updateOrgEmployee(Org_employee orgEmloyee) {
		// TODO Auto-generated method stub
		return dao.updateOrgEmployee(orgEmloyee);
	}



	@Override
	public int getPagesBySize(int pageSize, String username) {
		int count = dao.getCount(username);
		if(count%pageSize==0){
			return count/pageSize;
		}else{
			return (count/pageSize)+1; 	
			
		}
	}


	/**
	 * 删除用户信息
	 */
	@Override
	public int deletesOrgEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deletesOrgEmployee(id);
	}



	@Override
	public Org_employee selectOrgEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectOrgEmployeesByName(name);
	}



	@Override
	public Org_employee seleByid(int id) {
		
		return dao.seleByid(id);
	}



	

	

}
