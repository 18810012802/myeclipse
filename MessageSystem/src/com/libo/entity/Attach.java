package com.libo.entity;

import java.sql.Date;

public class Attach {
	public Attach() {
	}
	public Attach(int id, Date createdate, String name, String path,
			String filetype, int menuid, int fileid) {
		this.id = id;
		this.createdate = createdate;
		this.name = name;
		this.path = path;
		this.filetype = filetype;
		this.menuid = menuid;
		this.fileid = fileid;
	}
	private int id;
	private Date createdate;
	private String name;
	private String path;
	private String filetype;
	private int menuid;
	private int fileid;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * @param createdate the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the filetype
	 */
	public String getFiletype() {
		return filetype;
	}
	/**
	 * @param filetype the filetype to set
	 */
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	/**
	 * @return the menuid
	 */
	public int getMenuid() {
		return menuid;
	}
	/**
	 * @param menuid the menuid to set
	 */
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	/**
	 * @return the fileid
	 */
	public int getFileid() {
		return fileid;
	}
	/**
	 * @param fileid the fileid to set
	 */
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
}
