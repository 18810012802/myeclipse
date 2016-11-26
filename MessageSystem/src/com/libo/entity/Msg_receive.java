package com.libo.entity;

import java.sql.Date;
/**
 * 约稿接收表;
 * @author Administrator
 *
 */
public class Msg_receive {
	
	
	public Msg_receive() {
		
	}
	public Msg_receive(int id, Date editDate, int editUserId,
			int manuscriptsId, int state) {
		super();
		this.id = id;
		this.editDate = editDate;
		this.editUserId = editUserId;
		this.manuscriptsId = manuscriptsId;
		this.state = state;
	}
	private int id;//主键;
	private Date editDate;//操作时间;
	private int editUserId;//操作人员;
	private int manuscriptsId;//约稿信息id;
	private int state;//采编接收状态: 0. 已接收 1. 已拒收  2.已上报
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public int getEditUserId() {
		return editUserId;
	}
	public void setEditUserId(int editUserId) {
		this.editUserId = editUserId;
	}
	public int getManuscriptsId() {
		return manuscriptsId;
	}
	public void setManuscriptsId(int manuscriptsId) {
		this.manuscriptsId = manuscriptsId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
