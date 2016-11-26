package com.libo.service.fan;

import java.util.List;

import com.libo.entity.Sys_menu;



public interface Sys_menuService_fan {
	/**
	    * ��ȡ���еĲ˵���Ϣ
	    * @return ������Ϣ����
	    */
 public List<Sys_menu> getAll();
 /**
  * ��������Ĳ˵���ģ����ѯ�˵�
  * @param menuName ����Ĺؼ���
  * @return ���ز˵�����
  */
 public List<Sys_menu> getSysMenuByName(String menuName);
  /**
  * ��Ӳ˵�
  * @param sysMenu ����Ĳ˵���Ϣ
  * @return
  */
 public int addSysMenu(Sys_menu sysMenu);
 /**
  * ����id��ȡ�˵�����
  * @param id ����Ĳ˵�id
  * @return ����һ���˵�����
  */
 public Sys_menu getSysMenuById(int id);
 /**
  * �޸Ĳ˵�����
  * @param sysMenu ����Ҫ�޸ĵĲ˵���Ϣ����
  * @return ������Ӱ������
  */
 public int updateMenu(Sys_menu sysMenu);
 /**
  * ���ǲ�ѯһ���˵�����
  * @return ���ز˵�����
  */
 public List<Sys_menu> getSysMenuByMenuLevel();
 /**
  * ���ǲ�ѯ�����Ӳ˵��ķ���
  * @return �����Ӳ˵�����
  */
 public List<Sys_menu> getSysMenuBy();
 /**
  * ���ݽ�ɫid��ȡ�ý�ɫ�Ĳ˵�id
  * @param roleId ����Ľ�ɫid
  * @return ���ز˵�id����
  */
 public List<Sys_menu> getMenuIdByRoleId(int roleId);
 /**
  * ��ȡ��ҳ������
  * @param pageSize ҳ����ʾ����
  * @param username ��ѯ�����ؼ���
  * @return ������ҳ��
  */
 public int getPagesBySize(int pageSize,String username);
 /**
  * ��Ա��Ϣ��ҳ����
  * @param pageNum ��ǰҳ��
  * @param pageSize ÿҳ��ʾ��Ϣ����
  * @param username ��ѯ�ؼ���
  * @return ������Ϣ����
  */
 public List<Sys_menu> getAllByPage(int pageNum, int pageSize,String username);
 /**
  * ��ȡ��ѯ�����ݵ�����
  * @param username ����Ĳ�ѯ�����ؼ���
  * @return ������������
  */
 public int getCount(String username);
 /**
  * ����Ȩ��id��ϵͳ�˵�id��
  * @param id Ȩ��id
  * @param i ϵͳ�˵�id
  * @return
  */
	public List<Sys_menu> getALlByMenuId(Integer id, int i);
	 /**
	    * �˵�ɾ������ʱʵ��Ϊ���˵�״̬�޸�Ϊ����
	    * @param id ����Ĳ˵�id
	    * @return ������Ӱ������
	    */
	   public int updateSysMenu(int id);
}
