package com.libo.entity;

import java.sql.Date;

/**
 * 约稿信息;
 * @author Administrator
 *
 */
public class Msg_manuscripts {
		
		public Msg_manuscripts(String name) {
		super();
		this.name = name;
	}
		public Msg_manuscripts(String name, String number, String content,
			Date endDate, int sendUserId, int state) {
		super();
		this.name = name;
		this.number = number;
		this.content = content;
		this.endDate = endDate;
		this.sendUserId = sendUserId;
		this.state = state;
	}
		public Msg_manuscripts(int id, Date createDate, String name, String number,
			String content, Date endDate, int state) {
		this.id = id;
		this.createDate = createDate;
		this.name = name;
		this.number = number;
		this.content = content;
		this.endDate = endDate;
		this.state = state;
	}
		public Msg_manuscripts(String name, String number, String content,
			Date endDate, int sendUserId, int state ,int id){
		this.name = name;
		this.number = number;
		this.content = content;
		this.endDate = endDate;
		this.sendUserId = sendUserId;
		this.state = state;
		this.id = id;
	}
		public Msg_manuscripts(String name, String number, String content,
			Date endDate, int state) {
		this.name = name;
		this.number = number;
		this.content = content;
		this.endDate = endDate;
		this.state = state;
	}
		public Msg_manuscripts(int id, Date createDate, String name, String number,
			String content, Date endDate, int sendUserId, int state, int flag) {
		this.id = id;
		this.createDate = createDate;
		this.name = name;
		this.number = number;
		this.content = content;
		this.endDate = endDate;
		this.sendUserId = sendUserId;
		this.state = state;
		this.flag = flag;
	}
		public Msg_manuscripts() {
			super();
		}
		private int id;//主键
		private Date createDate;//添加时间;
		public Msg_manuscripts(int id, Date createDate, String name,
				String number, String content, Date endDate, int sendUserId,
				int state, int flag, Msg_file msgfile) {
			super();
			this.id = id;
			this.createDate = createDate;
			this.name = name;
			this.number = number;
			this.content = content;
			this.endDate = endDate;
			this.sendUserId = sendUserId;
			this.state = state;
			this.flag = flag;
			this.msgfile = msgfile;
		}
		public Msg_file getMsgfile() {
			return msgfile;
		}
		public void setMsgfile(Msg_file msgfile) {
			this.msgfile = msgfile;
		}
		
		public Msg_manuscripts(int id, Date createDate, String name,
				String number, String content, Date endDate, int sendUserId,
				int state, int flag, Org_employee ore) {
			super();
			this.id = id;
			this.createDate = createDate;
			this.name = name;
			this.number = number;
			this.content = content;
			this.endDate = endDate;
			this.sendUserId = sendUserId;
			this.state = state;
			this.flag = flag;
			this.ore = ore;
		}
		private String name;//刊物名称;
		private String number;//期号;
		private String content;//内容;
		private Date endDate;//上报截止时间;
		private int sendUserId;//发布人员id对应人员主键id;
		private int state;//发布状态：0.未发布1.已发布
		private int flag;//成刊审核状态: 0. 上报中 --- 发布约稿信息后 默认为上报中  1. 审核中 2. 审核通过  3 .审核未通过
		private Msg_file msgfile;
		private Org_employee ore;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public int getSendUserId() {
			return sendUserId;
		}
		public void setSendUserId(int sendUserId) {
			this.sendUserId = sendUserId;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public int getFlag() {
			return flag;
		}
		public void setFlag(int flag) {
			this.flag = flag;
		}
		public Org_employee getOre() {
			return ore;
		}
		public void setOre(Org_employee ore) {
			this.ore = ore;
		}
		
}
