package com.libo.service.lichao;

import java.util.List;

import com.libo.entity.Msg_file;

public interface WaitInfoService {
	/**
	 * ��ѯ����δ��˵ĸ��
	 */
	public List<Msg_file> selectWaitInfo(int currentPage,String name,String number,String title);
	/**
	 * ��ѯδ��˸��������
	 */
	public int getWaitInfoCount(String name,String number,String title);
	/**
	 * ��id��ѯλ��˸��������
	 */
	public List<Msg_file> selectWaitInfoById(int id);
	/**
	 * ��˸���ķ���
	 */
	public int checkWaitInfo(int id ,int state);
}
