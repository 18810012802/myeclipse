package com.libo.dao.yetong;

import java.util.List;

import com.libo.entity.Employee;
import com.libo.entity.Org_employee;

public interface OrgEmployeeSearchDao {
	/**
	 * 
	 * @param 查询个人信息
	 * @return
	 */
	public Org_employee showInfo(int id);
	
	public int modifyPwd(int id,String pwdold,String pwdnew);
	
	public List<Employee> selectemp();
}
