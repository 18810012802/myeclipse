package com.libo.entity;

import java.sql.Date;

/**
 * 人员实体类
 * @author Administrator
 *
 */
public class Org_employee {
	
	public Org_employee(String username) {
		super();
		this.username = username;
	}
	public Org_employee(Org_role orgrole, int id, Date createDate,
			String loginname, String loginpassword, String username, int sex,
			String email, String telphone, String idcaid, String address,
			int state, int roleid, String photo) {
		super();
		this.orgrole = orgrole;
		this.id = id;
		this.createDate = createDate;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.telphone = telphone;
		this.idcaid = idcaid;
		this.address = address;
		this.state = state;
		this.roleid = roleid;
		this.photo = photo;
	}
	public Org_employee(int id, String loginname, String loginpassword) {
		
		this.id = id;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
	}
	
	public Org_employee(String loginname, String username) {
		super();
		this.loginname = loginname;
		this.username = username;
	}
	public Org_employee(Date createDate, String loginname,
			String loginpassword, String username, int sex, String email,
			String telphone, String idcaid, String address, int state,
			int roleid, String photo) {
		super();
		this.createDate = createDate;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.telphone = telphone;
		this.idcaid = idcaid;
		this.address = address;
		this.state = state;
		this.roleid = roleid;
		this.photo = photo;
	}
	public Org_employee() {
		super();
	}
	public Org_employee(int id, Date createDate, String loginname,
			String loginpassword, String username, int sex, String email,
			String telphone, String idcaid, String address, int state,
			int roleid, String photo) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
		this.username = username;
		this.sex = sex;
		this.email = email;
		this.telphone = telphone;
		this.idcaid = idcaid;
		this.address = address;
		this.state = state;
		this.roleid = roleid;
		this.photo = photo;
	}
	private Org_role orgrole;
	private int id;//主键ID;
	private Date createDate;//添加时间;
	private String loginname;//登陆账号;
	private String loginpassword;//密码;
	private String username;//真实姓名;
	private int sex;//性别1.男2.女;
	private String email;//邮箱;
	private String telphone;//电话;
	private String idcaid;//身份证号;
	private String address;//地址;
	private int state;//状态：0.启用1.禁用;
	private int roleid;//角色id对应实体类：org_role的主键;
	private String photo;//头像;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getIdcaid() {
		return idcaid;
	}
	public void setIdcaid(String idcaid) {
		this.idcaid = idcaid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Org_role getOrgrole() {
		return orgrole;
	}
	public void setOrgrole(Org_role orgrole) {
		this.orgrole = orgrole;
	}
	
}
