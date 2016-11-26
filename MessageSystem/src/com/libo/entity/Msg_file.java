package com.libo.entity;

import java.sql.Date;

/**
 * 稿件表
 * @author Administrator
 *
 */
public class Msg_file {
	
	
	public Msg_file(int id, String title, String type, String filetype,
			 Date sendDate, Org_employee orgem) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.filetype = filetype;
		this.sendDate = sendDate;
		this.orgem = orgem;
	}
	public Msg_file( String title, String author, String type,
			String filetype, String content, String number, Date sendDate,
			Msg_manuscripts msgman, Org_employee orgem) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.filetype = filetype;
		this.content = content;
		this.number = number;
		this.sendDate = sendDate;
		this.msgman = msgman;
		this.orgem = orgem;
	}
	public Msg_manuscripts getMsgman() {
		return msgman;
	}
	public void setMsgman(Msg_manuscripts msgman) {
		this.msgman = msgman;
	}
	public Msg_file() {
		
	}
	
	public Msg_file(int id, String title, String type, String filetype,
			String number, Date sendDate, Org_employee orgem, 
			Msg_manuscripts msgman) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.filetype = filetype;
		this.number = number;
		this.sendDate = sendDate;
		this.msgman = msgman;
		this.orgem=orgem;
	}
	public Msg_file(int id, int createUserId, Date createDate, String title,
			String author, String from, String type, String filetype,
			String content, int maId, String number, int state, Date sendDate,
			int sendUser, int flag) {
	
		this.id = id;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.title = title;
		this.author = author;
		this.from = from;
		this.type = type;
		this.filetype = filetype;
		this.content = content;
		this.maId = maId;
		this.number = number;
		this.state = state;
		this.sendDate = sendDate;
		this.sendUser = sendUser;
		this.flag = flag;
	}
	
	public Msg_file(int id, int createUserId, Date createDate, String title,
			String author, String from, String type, String filetype,
			String content, int maId, String number, int state, Date sendDate,
			int sendUser, int flag, Msg_manuscripts msgman, Org_employee orgem) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.title = title;
		this.author = author;
		this.from = from;
		this.type = type;
		this.filetype = filetype;
		this.content = content;
		this.maId = maId;
		this.number = number;
		this.state = state;
		this.sendDate = sendDate;
		this.sendUser = sendUser;
		this.flag = flag;
		this.msgman = msgman;
		this.orgem = orgem;
	}
	
	public Msg_file(int id, int createUserId, Date createDate, String title,
			String author, String from, String type, String filetype,
			String content, int maId, String number, int state, Date sendDate,
			int sendUser, int flag, Org_employee orgem) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.title = title;
		this.author = author;
		this.from = from;
		this.type = type;
		this.filetype = filetype;
		this.content = content;
		this.maId = maId;
		this.number = number;
		this.state = state;
		this.sendDate = sendDate;
		this.sendUser = sendUser;
		this.flag = flag;
		this.orgem = orgem;
	}

	private int id;//主键;
	private int createUserId;//添加人员id;
	private Date createDate;//添加时间;
	private String title;//标题;
	private String author;//作者;
	private String from;//来源;
	private String type;//类别;
	private String filetype;//文体;
	private String content;//稿件内容;
	private int maId;//所属约稿id;
	private String number;//期号;
	private int state;//审核状态: 0. 审核中  1. 审核通过  2. 审核未通过
	private Date sendDate;//上报时间;
	private int sendUser;//上报人员id;
	private int flag;//文件状态: 0. 未上报  1. 已上报
	private Msg_manuscripts msgman;
	private Org_employee orgem;
	public Msg_file(int id, int createUserId, Date createDate, String title,
			String author, String from, String type, String filetype,
			String content, int maId, String number, int state, Date sendDate,
			int sendUser, int flag, Msg_manuscripts msgman) {
		super();
		this.id = id;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.title = title;
		this.author = author;
		this.from = from;
		this.type = type;
		this.filetype = filetype;
		this.content = content;
		this.maId = maId;
		this.number = number;
		this.state = state;
		this.sendDate = sendDate;
		this.sendUser = sendUser;
		this.flag = flag;
		this.msgman = msgman;
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
	public int getSendUser() {
		return sendUser;
	}
	public void setSendUser(int sendUser) {
		this.sendUser = sendUser;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Org_employee getOrgem() {
		return orgem;
	}
	public void setOrgem(Org_employee orgem) {
		this.orgem = orgem;
	}
	
	
	
}
