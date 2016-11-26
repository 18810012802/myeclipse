package com.libo.dao.lichao;

import java.sql.Date;
import java.util.List;

import com.libo.entity.Msg_manuscripts;

public interface InfoDao {
	/**
	 * �������
	 */
	public int addInfo(Msg_manuscripts ms);
	/**
	 * ��ʾ���еĸ��
	 */
	public List<Msg_manuscripts> queryInfo(int currentPage,int pageSize,String name,String number,Date newDate,Date endDate);
	/**
	 * ��ȡ�������ķ���
	 */
	public int getPageCout(String name,String number,Date newDate,Date endDate);
	/**
	 * ��ȡ�ļ�id�ķŷ�
	 */
	public int getFileId();
	/**
	 * ��Ӹ�������
	 */
	public int addFile(String fname,String path,String ftype,int mid,int fid);
	/**
	 * ɾ�����
	 */
	public int delInfo(int id);
	/**
	 * ��id��ѯ���
	 */
	public List<Msg_manuscripts> selectInfo(int id );
	/**
	 * �����id�޸ĸ��
	 */
	public int updateInfo(Msg_manuscripts ms);
	/**
	 * ����Excel��ѯ���
	 */
	public List<Msg_manuscripts> selectInfoByExcel(int id );
	/**
	 * ��ѯ��������
	 */
	public  String QueryFlieNmae(int mid ,int fid);
}
