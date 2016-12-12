package com.libo.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * Classes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="classes")
public class Classes implements java.io.Serializable {

	// Fields
	@Id
	@Column(name="cls_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_st")
	@SequenceGenerator(name="seq_st",sequenceName="seq_st",allocationSize=1,initialValue=1)
	private Integer clsId;
	@Column(name="cls_name")
	private String clsName;
	private Set studentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String clsName) {
		this.clsName = clsName;
	}

	/** full constructor */
	public Classes(String clsName, Set studentses) {
		this.clsName = clsName;
		this.studentses = studentses;
	}

	// Property accessors

	public Integer getClsId() {
		return this.clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getClsName() {
		return this.clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	@OneToMany(fetch=FetchType.LAZY,mappedBy="class_id")
	@Cascade(value=(CascadeType.SAVE_UPDATE))
	public Set getStudentses() {
		return this.studentses;
	}

	public void setStudentses(Set studentses) {
		this.studentses = studentses;
	}

}