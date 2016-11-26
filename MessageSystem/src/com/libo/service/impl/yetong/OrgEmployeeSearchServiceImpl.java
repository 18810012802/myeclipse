package com.libo.service.impl.yetong;

import java.util.List;

import com.libo.dao.impl.yetong.OrgEmployeeSearchDaoImpl;
import com.libo.dao.yetong.OrgEmployeeSearchDao;
import com.libo.entity.Employee;
import com.libo.entity.Org_employee;
import com.libo.service.yetong.OrgEmployeeSearchService;

public class OrgEmployeeSearchServiceImpl implements OrgEmployeeSearchService {
	OrgEmployeeSearchDao oed = new OrgEmployeeSearchDaoImpl();
	@Override
	public Org_employee showInfo(int id) {
		return oed.showInfo(id);
	}
	@Override
	public int modifyPwd(int id, String pwdold, String pwdnew) {
		return oed.modifyPwd(id, pwdold, pwdnew);
	}
	@Override
	public List<Employee> selectemp() {
		return oed.selectemp();
	}

}
