package com.film.vo;

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
import javax.persistence.Transient;

import com.film.po.Filmtype;

/**
 * Filminfo entity. @author MyEclipse Persistence Tools
 */
public class FilminfoVO implements java.io.Serializable {

	// Fields

	private Integer filmid;
	private Filmtype filmtype;
	private String filmname;
	private String actor;
	private String director;
	private Integer ticketprice;
	private Integer minticketprice;
	private Integer maxticketprice;

	public Integer getMinticketprice() {
		return minticketprice;
	}

	public void setMinticketprice(Integer minticketprice) {
		this.minticketprice = minticketprice;
	}

	public Integer getMaxticketprice() {
		return maxticketprice;
	}

	public void setMaxticketprice(Integer maxticketprice) {
		this.maxticketprice = maxticketprice;
	}

	/** default constructor */
	public FilminfoVO() {
	}

	/** minimal constructor */
	public FilminfoVO(Integer filmid) {
		this.filmid = filmid;
	}

	/** full constructor */
	public FilminfoVO(Integer filmid, Filmtype filmtype, String filmname,
			String actor, String director, Integer ticketprice) {
		this.filmid = filmid;
		this.filmtype = filmtype;
		this.filmname = filmname;
		this.actor = actor;
		this.director = director;
		this.ticketprice = ticketprice;
	}

	// Property accessors
	public Integer getFilmid() {
		return this.filmid;
	}

	public void setFilmid(Integer filmid) {
		this.filmid = filmid;
	}

	public Filmtype getFilmtype() {
		return this.filmtype;
	}

	public void setFilmtype(Filmtype filmtype) {
		this.filmtype = filmtype;
	}

	public String getFilmname() {
		return this.filmname;
	}

	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getTicketprice() {
		return this.ticketprice;
	}

	public void setTicketprice(Integer ticketprice) {
		this.ticketprice = ticketprice;
	}

}