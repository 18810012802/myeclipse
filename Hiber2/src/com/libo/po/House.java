package com.libo.po;

import java.util.Date;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Types types;
	private Street street;
	private String title;
	private String description;
	private Integer price;
	private Date pubdate;
	private Integer floorage;
	private String contact;
	private Integer minPrice;
	private Integer maxPrice;
	private Integer minFloorage;
	private Integer maxFloorage;
	private Integer streetId;
	private Integer typesId;
	private Date houseDate;

	// Constructors

	public Date getHouseDate() {
		return houseDate;
	}

	public void setHouseDate(Date houseDate) {
		this.houseDate = houseDate;
	}

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public Integer getTypesId() {
		return typesId;
	}

	public void setTypesId(Integer typesId) {
		this.typesId = typesId;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinFloorage() {
		return minFloorage;
	}

	public void setMinFloorage(Integer minFloorage) {
		this.minFloorage = minFloorage;
	}

	public Integer getMaxFloorage() {
		return maxFloorage;
	}

	public void setMaxFloorage(Integer maxFloorage) {
		this.maxFloorage = maxFloorage;
	}

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(Users users, Types types, Street street, String title,
			String description, Integer price, Date pubdate, Integer floorage,
			String contact,Date houseDate) {
		this.users = users;
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
		this.houseDate=houseDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Types getTypes() {
		return this.types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Integer getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}