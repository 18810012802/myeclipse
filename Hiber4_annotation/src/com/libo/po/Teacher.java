package com.libo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TEACHER", schema = "SCOTT")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tname;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer tid) {
		this.tid = tid;
	}

	/** full constructor */
	public Teacher(Integer tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	// Property accessors
	@Id
	@Column(name = "TID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "TNAME", length = 64)
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}