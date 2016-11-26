package com.libo.dao.fan;

import java.util.List;

import com.libo.entity.Sys_menu;


public interface Sys_menuDao_fan {
	 /**
	    * 获取所有的菜单信息
	    * @return 返回信息集合
	    */
    public List<Sys_menu> getAll();
    /**
     * 根据输入的菜单名模糊查询菜单
     * @param menuName 传入的关键字
     * @return 返回菜单集合
     */
    public List<Sys_menu> getSysMenuByName(String menuName);
    /**
     * 添加菜单
     * @param sysMenu 传入的菜单信息
     * @return
     */
    public int addSysMenu(Sys_menu sysMenu);
    /**
     * 根据id获取菜单对象
     * @param id 传入的菜单id
     * @return 返回一个菜单对象
     */
    public Sys_menu getSysMenuById(int id);
    /**
     * 修改菜单方法
     * @param sysMenu 传入要修改的菜单信息对象
     * @return 返回受影响行数
     */
    public int updateMenu(Sys_menu sysMenu);
    /**
     * 这是查询一级菜单方法
     * @return 返回菜单集合
     */
    public List<Sys_menu> getSysMenuByMenuLevel();
    /**
     * 这是查询其余子菜单的方法
     * @return 返回子菜单集合
     */
    public List<Sys_menu> getSysMenuBy();
    /**
     * 根据角色id获取该角色的菜单id
     * @param roleId 传入的角色id
     * @return 返回菜单id集合
     */
    public List<Sys_menu> getMenuIdByRoleId(int roleId);
    /**
     * 获取查询的数据的条数
     * @param username 传入的查询条件关键字
     * @return 返回数据条数
     */
    public int getCount(String username);
    /**
     * 菜单信息分页功能
     * @param pageNum 当前页数
     * @param pageSize 每页显示信息条数
     * @param username 查询关键字
     * @return 返回信息集合
     */
    public List<Sys_menu> getAllByPage(int pageNum, int pageSize,String username);
    /**
     * 根据权限id与系统菜单id查
     * @param id 权限id
     * @param i 系统菜单id
     * @return
     */
	   public List<Sys_menu> getALlByMenuId(Integer id, int i);
	   /**
	    * 菜单删除操作时实际为将菜单状态修改为禁用
	    * @param id 传入的菜单id
	    * @return 返回受影响行数
	    */
	   public int updateSysMenu(int id);
}
