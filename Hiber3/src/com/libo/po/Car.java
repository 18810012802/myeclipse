package com.libo.po;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private Integer id;
	private Carport carport;
	private String number;
	private String brand;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(Integer id, Carport carport) {
		this.id = id;
		this.carport = carport;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carport getCarport() {
		return carport;
	}

	public void setCarport(Carport carport) {
		this.carport = carport;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	
	
}