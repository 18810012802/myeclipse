package com.libo.entity;

import java.sql.Date;

/**
 * �����
 * @author Administrator
 *
 */
public class Msg_file_list {
	
	public Msg_file_list() {
		
	}
	public Msg_file_list(int id,String title,
			String type, String filetype, Date sendDate,
			String sendUser) {
	
		this.id = id;
		this.title = title;
		this.type = type;
		this.filetype = filetype;
		this.sendDate = sendDate;
		this.sendUser = sendUser;
	}
	public Msg_file_list(int id,String title,
			String type, String filetype, Date maCreateTime,
			String author,String maContent,int state) {
	
		this.id = id;
		this.title = title;
		this.type = type;
		this.filetype = filetype;
		this.maCreateTime = maCreateTime;
		this.author = author;
		this.maContent=maContent;
		this.state=state;
	}


	public String getMaContent() {
		return maContent;
	}
	public void setMaContent(String maContent) {
		this.maContent = maContent;
	}
	public Date getMaCreateTime() {
		return maCreateTime;
	}
	public void setMaCreateTime(Date maCreateTime) {
		this.maCreateTime = maCreateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMaId() {
		return maId;
	}
	public void setMaId(int maId) {
		this.maId = maId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Msg_manuscripts getMsgman() {
		return msgman;
	}
	public void setMsgman(Msg_manuscripts msgman) {
		this.msgman = msgman;
	}
	public Org_employee getOrgem() {
		return orgem;
	}
	public void setOrgem(Org_employee orgem) {
		this.orgem = orgem;
	}



	private int id;//����;
	private int createUserId;//�����Աid;
	private Date createDate;//���ʱ��;
	private String title;//����;
	private String author;//����;
	private String from;//��Դ;
	private String type;//���;
	private String filetype;//����;
	private String maContent;
	private Date maCreateTime;
	private String content;//�������;
	private int maId;//����Լ��id;
	private String number;//�ں�;
	private int state;//���״̬: 0. �����  1. ���ͨ��  2. ���δͨ��
	private Date sendDate;//�ϱ�ʱ��;
	private String sendUser;//�ϱ���Աid;
	private int flag;//�ļ�״̬: 0. δ�ϱ�  1. ���ϱ�
	private Msg_manuscripts msgman;
	private Org_employee orgem;

	
}
