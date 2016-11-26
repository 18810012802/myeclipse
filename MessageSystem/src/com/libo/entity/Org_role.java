package com.libo.entity;

import java.sql.Date;
import java.util.List;

/**
 * ��ɫ;
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
	private int id;//����;
	private int org_id;//��ԱID;
	private Date createDate;//���ʱ��;
	private String roleName;//��ɫ����;
	private int state;//״̬��0.����1.����;
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
