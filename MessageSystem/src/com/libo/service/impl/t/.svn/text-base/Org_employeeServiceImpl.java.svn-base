package com.libo.service.impl.t;

import java.util.List;

import com.lib.dao.impl.t.Org_employeeDaoImpl;
import com.lib.dao.t.Org_employeeDao;
import com.lib.service.t.Org_employeeService;
import com.libo.entity.Org_employee;

public class Org_employeeServiceImpl implements Org_employeeService {
	Org_employeeDao mm=new Org_employeeDaoImpl();
	@Override
	public List<Org_employee> SelectAllByOid(int oid) {
		List<Org_employee> msg=mm.selectAllByOid(oid);
		return msg;
	}

}
