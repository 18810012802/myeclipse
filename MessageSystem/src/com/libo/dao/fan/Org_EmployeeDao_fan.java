package com.libo.dao.fan;

import java.util.List;

import com.libo.entity.Org_employee;




public interface Org_EmployeeDao_fan {
	
	/**
	 * ��ѯ
	 * @param username
	 * @return
	 */
	public List<Org_employee> selectOrg();
	 
    public int deleteOrgEmployee(int id);
    /**
     * ��������Ĺؼ���ģ����ѯ��Ա��Ϣ
     * @param input 
     * @return 
     */
    public List<Org_employee> getAllByInput(String input);
    /**
     * �����Ա��Ϣ
     * @param orgEmployee
     * @return 
     */
    public int addOrgEmployee(Org_employee orgEmployee);
    /**
     * ������Աid��ѯ��Ա��Ϣ
     * @param 
     * @return 
     */
    public Org_employee getOrgEmployeeById(int id);
    
    /**
     * �޸���Ա��Ϣ
     * @param orgEmloyee 
     * @return 
     */
    public int updateOrgEmployee(Org_employee orgEmloyee);
	/**
     * ��ȡ��ѯ�����ݵ�����
     * @param username
     * @return 
     */
    public int getCount(String username);
    /**
     * ��Ա��Ϣ��ҳ����
     * @param pageNum 
     * @param pageSize 
     * @param username 
     * @return 
     */
    public List<Org_employee> getAllByPage(int pageNum, int pageSize,String username);
    /**
     * ɾ���û�
     * @param id
     * @return
     */
    public int deletesOrgEmployee(int id);
    public Org_employee selectOrgEmployeesByName(String name);
    public Org_employee seleByid(int id);
}
