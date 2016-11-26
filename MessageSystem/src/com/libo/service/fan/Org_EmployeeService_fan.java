package com.libo.service.fan;

import java.util.List;

import com.libo.entity.Org_employee;



public interface Org_EmployeeService_fan {
	/**
	 * 用户查询
	 * @return
	 * @author Administrator
	 */
	public List<Org_employee> selectOrg();
	/**
     * 根据人员id删除人员信息
     * @param id 传入的id 
     * @return 返回受影响行数
     */
    public int deleteOrgEmployee(int id);
    /**
     * 根据输入的关键字模糊查询人员信息
     * @param input 传入的关键字
     * @return 返回人员信息集合
     */
    public List<Org_employee> getAllByInput(String input);
    /**
     * 添加人员信息
     * @param orgEmployee 传入人员信息对象
     * @return 返回受影响行数
     */
    public int addOrgEmployee(Org_employee orgEmployee);
    /**
     * 根据人员id查询人员信息
     * @param id 传入的id
     * @return 返回一个信息对象
     */
    public Org_employee getOrgEmployeeById(int id);
    /**
     * 修改人员信息
     * @param orgEmloyee 传入修改的信息对象
     * @return 返回受影响行数
     */
    public int updateOrgEmployee(Org_employee orgEmloyee);
    /**
     * 获取种页数方法
     * @param pageSize 页面显示条数
     * @param username 查询条件关键字
     * @return 返回总页数
     */
    public int getPagesBySize(int pageSize,String username);
	/**
     * 人员信息分页功能
     * @param pageNum 当前页数
     * @param pageSize 每页显示信息条数
     * @param username 查询关键字
     * @return 返回信息集合
     */
    public List<Org_employee> getAllByPage(int pageNum, int pageSize,String username);
    /**
     * 获取查询的数据的条数
     * @param username 传入的查询条件关键字
     * @return 返回数据条数
     */
    public int getCount(String username);
    /**
	 * 人员删除操作时实际为将人员状态修改为禁用
	 * @param id 传入的人员id
	 * @return 返回受影响行数
	 */
	public int deletesOrgEmployee(int id);
	public Org_employee selectOrgEmployeesByName(String name);
	 public Org_employee seleByid(int id);
}
