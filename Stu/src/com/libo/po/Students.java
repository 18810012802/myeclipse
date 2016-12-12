package com.libo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="students")
public class Students implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="stu_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_st")
	@SequenceGenerator(name="seq_st",sequenceName="seq_pet",allocationSize=1,initialValue=1)
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="class_id")
	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Column(name="stu_name",length=32)
	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	@Column(name="age",precision=6,scale=0)
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}