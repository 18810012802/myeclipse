package com.libo.entity;

import java.sql.Date;
import java.util.List;

/**
 * 角色;
 * @author Administrator
 *
 */
public class Org_role {
	
	public Org_role(int id, int org_id, Date createDate, String roleName,
			int state) {
		super();
		this.id = id;
		this.org_id = org_id;
		this.createDate = createDate;
		this.roleName = roleName;
		this.state = state;
	}
	public Org_role() {
		super();
	}
	public Org_role(int id, int org_id, Date createDate, String roleName,
			int state, List<Org_employee> employees) {
		super();
		this.id = id;
		this.org_id = org_id;
		this.createDate = createDate;
		this.roleName = roleName;
		this.state = state;
		this.employees = employees;
	}
	private int id;//主键;
	private int org_id;//人员ID;
	private Date createDate;//添加时间;
	private String roleName;//角色名称;
	private int state;//状态：0.启用1.禁用;
	private List<Org_employee> employees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Org_employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Org_employee> employees) {
		this.employees = employees;
	}
	
	
}
