package com.libo.dao.lichao;

import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface YetInfoDao {
	/**
	 * ��ѯ����˵�Լ��
	 */
	public List<Msg_manuscripts> queryYetInfo(int currentPage,int pageSize,String name,String number);
	/**
	 * ��������Լ�������
	 */
	public int getYetInfoCount(String name,String number);
	/**
	 * �ύ���
	 */
	public int subCheck(int id );
	/**
	 * ����execl��ѯ����˵ĸ��
	 */
	public List<Msg_manuscripts> selectYetInfoByExcel(int id );
	
}
