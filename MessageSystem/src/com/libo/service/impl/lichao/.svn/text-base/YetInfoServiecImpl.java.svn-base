package com.libo.service.impl.lichao;

import java.util.List;

import com.libo.dao.impl.lichao.YetInfoDaoImpl;
import com.libo.dao.lichao.YetInfoDao;
import com.libo.entity.Msg_manuscripts;
import com.libo.service.lichao.YetInfoService;
import com.libo.util.PageSize;

public class YetInfoServiecImpl implements YetInfoService {
	YetInfoDao dao =new YetInfoDaoImpl();
	public List<Msg_manuscripts> queryYetInfo(int currentPage, String name,
			String number) {

		return dao.queryYetInfo(currentPage, PageSize.PAGE_SIZE, name, number);
	}

	@Override
	public int getYetInfoCount(String name,String number) {
		return dao.getYetInfoCount(name,number);
	}

	@Override
	public int subCheck(int id) {
	
		return dao.subCheck(id);
	}

	@Override
	public List<Msg_manuscripts> selectYetInfoByExcel(int id) {
		
		return dao.selectYetInfoByExcel(id);
	}

}
