package com.libo.entity;

import java.sql.Date;

/**
 * ��������;
 * 
 * @author Administrator
 * 
 */
public class File_attach {
	private int id;// ����;
	private Date createDate;// �ϴ�ʱ��;
	private String name;// �ļ�����;
	private String path;// �ļ�·��;
	private String filetype;// �ļ�����;
	private int menuId;// �˵�id��ӦSys_menu����id;
	private int fileId;// �ļ�id��ӦMsg_file������id;

	public File_attach() {

	}

	public File_attach(int id, Date createDate, String name, String path,
			String filetype, int menuId, int fileId) {

		this.id = id;
		this.createDate = createDate;
		this.name = name;
		this.path = path;
		this.filetype = filetype;
		this.menuId = menuId;
		this.fileId = fileId;
	}

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

}
