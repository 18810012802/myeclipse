package com.libo.entity;

import java.sql.Date;

/**
 * 邮箱类
 * 
 * @author Administrator
 * 
 */
public class Mail_box {
	private int id;// 主键;
	private String title;// 标题;
	private String content;// 内容;
	private int sendUserId;// 发件人ID对应人员主键ID;
	private Date sendDate;// 发送时间;
	private String sendstate;// 发送文件状态;
	private int receiveUserId;// 收件人,ID应该为人员主键ID;
	private Date receiveDate;// 接收时间;
	private int receiveState;// 接收状态;
	private Org_employee oe;
	private File_attach fileAttach;

	public Mail_box() {

	}
	
	public Mail_box(int id, String title, String content, int sendUserId,
			Date sendDate, String sendstate, int receiveUserId,
			Date receiveDate, int receiveState) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendUserId = sendUserId;
		this.sendDate = sendDate;
		this.sendstate = sendstate;
		this.receiveUserId = receiveUserId;
		this.receiveDate = receiveDate;
		this.receiveState = receiveState;
	}

	public Mail_box(int id, String title, String content, int sendUserId,
			Date sendDate, String sendstate, int receiveUserId,
			Date receiveDate, int receiveState, Org_employee oe) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendUserId = sendUserId;
		this.sendDate = sendDate;
		this.sendstate = sendstate;
		this.receiveUserId = receiveUserId;
		this.receiveDate = receiveDate;
		this.receiveState = receiveState;
		this.oe = oe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendstate() {
		return sendstate;
	}

	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}

	public int getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(int receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public int getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(int receiveState) {
		this.receiveState = receiveState;
	}

	public Org_employee getOe() {
		return oe;
	}

	public void setOe(Org_employee oe) {
		this.oe = oe;
	}

	public File_attach getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(File_attach fileAttach) {
		this.fileAttach = fileAttach;
	}

}
