package com.libo.dao.fan;

import java.util.List;

import com.libo.entity.Org_employee;




public interface Org_EmployeeDao_fan {
	
	/**
	 * 查询
	 * @param username
	 * @return
	 */
	public List<Org_employee> selectOrg();
	 
    public int deleteOrgEmployee(int id);
    /**
     * 根据输入的关键字模糊查询人员信息
     * @param input 
     * @return 
     */
    public List<Org_employee> getAllByInput(String input);
    /**
     * 添加人员信息
     * @param orgEmployee
     * @return 
     */
    public int addOrgEmployee(Org_employee orgEmployee);
    /**
     * 根据人员id查询人员信息
     * @param 
     * @return 
     */
    public Org_employee getOrgEmployeeById(int id);
    
    /**
     * 修改人员信息
     * @param orgEmloyee 
     * @return 
     */
    public int updateOrgEmployee(Org_employee orgEmloyee);
	/**
     * 获取查询的数据的条数
     * @param username
     * @return 
     */
    public int getCount(String username);
    /**
     * 人员信息分页功能
     * @param pageNum 
     * @param pageSize 
     * @param username 
     * @return 
     */
    public List<Org_employee> getAllByPage(int pageNum, int pageSize,String username);
    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deletesOrgEmployee(int id);
    public Org_employee selectOrgEmployeesByName(String name);
    public Org_employee seleByid(int id);
}
