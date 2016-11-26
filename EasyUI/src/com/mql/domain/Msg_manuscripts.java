package com.mql.domain;

import java.sql.Date;

/**
 * Լ����Ϣ;
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
		private int id;//����
		private Date createDate;//���ʱ��;
		private String name;//�������;
		private String number;//�ں�;
		private String content;//����;
		private Date endDate;//�ϱ���ֹʱ��;
		private int sendUserId;//������Աid��Ӧ��Ա����id;
		private int state;//����״̬��0.δ����1.�ѷ���
		private int flag;//�ɿ����״̬: 0. �ϱ��� --- ����Լ����Ϣ�� Ĭ��Ϊ�ϱ���  1. ����� 2. ���ͨ��  3 .���δͨ��
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
		
}
