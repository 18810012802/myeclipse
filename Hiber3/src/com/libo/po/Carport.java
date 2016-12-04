package com.libo.po;

/**
 * Carport entity. @author MyEclipse Persistence Tools
 */

public class Carport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Car car;
	private String location;
	private Integer size;

	// Constructors

	/** default constructor */
	public Carport() {
	}

	/** minimal constructor */
	public Carport(Integer id, Car car) {
		this.id = id;
		this.car = car;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


	
}