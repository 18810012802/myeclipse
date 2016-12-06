package com.libo.po;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private Classes classes;
	private String stuName;
	private Integer age;

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** full constructor */
	public Students(Classes classes, String stuName, Integer age) {
		this.classes = classes;
		this.stuName = stuName;
		this.age = age;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}