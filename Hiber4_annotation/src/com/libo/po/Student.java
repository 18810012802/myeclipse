package com.libo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "STUDENT", schema = "SCOTT")
public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String sname;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Student(Integer sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}

	// Property accessors
	@Id
	@Column(name = "SID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "SNAME", length = 64)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}