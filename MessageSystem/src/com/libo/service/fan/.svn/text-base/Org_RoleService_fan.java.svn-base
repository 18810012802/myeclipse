package com.libo.service.fan;

import java.util.List;

import com.libo.entity.Org_role;


public interface Org_RoleService_fan {
	/**
     * 获取所有角色信息功能
     * @return 返回一个角色信息集合
     */
    public List<Org_role> getAll();
    /**
     * 根据角色名字关键字模糊查询所有的角色信息功能
     * @param roleName 传入的角色关键字
     * @return 返回一个角色信息集合
     */
    public List<Org_role> getRoleByRoName(String roleName);
    /**
     * 根据角色id删除角色信息功能
     * @param id 传入的角色id
     * @return 返回受影响行数
     */
    public int deleteByid(int id);
    /**
     * 添加角色
     * @param role 传入的添加的角色信息
     * @return 返回添加的角色的id
     */
    public int addRole(Org_role role);
    /**
     * 根据角色id添加权限
     * @param menuId 传入菜单id
     * @param roleId 传入的角色id
     * @return 返回受影响行数
     */
    public int addPerm(int menuId,int roleId);
    /**
     * 根据角色id获取角色信息
     * @param id 传入的id
     * @return 返回角色对象
     */
    public Org_role getRoleByid(int id);
    /**
     * 根据角色id删除权限方法
     * @param id 传入的角色id
     * @return 返回受影响行数
     */
    public int deletePerm(int id);
    /**
     * 修改角色信息方法
     * @param orgRole 传入要修改的角色对象
     * @return 返回受影响行数
     */
    public int updateRole(Org_role orgRole);
    /**
     * 获取总页数方法
     * @param pageSize 页面显示条数
     * @param username 查询条件关键字
     * @return 返回总页数
     */
    public int getPagesBySize(int pageSize,String rolename);
    /**
     * 角色信息分页功能
     * @param pageNum 当前页数
     * @param pageSize 每页显示信息条数
     * @param username 查询关键字
     * @return 返回信息集合
     */
    public List<Org_role> getAllByPage(int pageNum, int pageSize,String rolename);
    /**
     * 获取查询的数据的条数
     * @param username 传入的查询条件关键字
     * @return 返回数据条数
     */
    public int getCount(String rolename);
    /**
	    * 角色删除操作时实际为将角色状态修改为禁用
	    * @param id 传入的角色id
	    * @return 返回受影响行数
	    */
	   public int updateOrgRoleById(int id);
}

	
