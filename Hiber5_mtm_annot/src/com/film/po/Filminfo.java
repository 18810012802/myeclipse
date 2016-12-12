package com.film.po;

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

/**
 * Filminfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FILMINFO", schema = "SCOTT")
public class Filminfo implements java.io.Serializable {

	// Fields

	private Integer filmid;
	private Filmtype filmtype;
	private String filmname;
	private String actor;
	private String director;
	private Integer ticketprice;
	private Integer minticketprice;
	private Integer maxticketprice;
	// Constructors
	@Transient
	public Integer getMinticketprice() {
		return minticketprice;
	}

	public void setMinticketprice(Integer minticketprice) {
		this.minticketprice = minticketprice;
	}
	@Transient
	public Integer getMaxticketprice() {
		return maxticketprice;
	}

	public void setMaxticketprice(Integer maxticketprice) {
		this.maxticketprice = maxticketprice;
	}

	/** default constructor */
	public Filminfo() {
	}

	/** minimal constructor */
	public Filminfo(Integer filmid) {
		this.filmid = filmid;
	}

	/** full constructor */
	public Filminfo(Integer filmid, Filmtype filmtype, String filmname,
			String actor, String director, Integer ticketprice) {
		this.filmid = filmid;
		this.filmtype = filmtype;
		this.filmname = filmname;
		this.actor = actor;
		this.director = director;
		this.ticketprice = ticketprice;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_st")
	@SequenceGenerator(name="seq_st",sequenceName="seq_st",allocationSize=1,initialValue=1)
	@Column(name = "FILMID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getFilmid() {
		return this.filmid;
	}

	public void setFilmid(Integer filmid) {
		this.filmid = filmid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPEID")
	public Filmtype getFilmtype() {
		return this.filmtype;
	}

	public void setFilmtype(Filmtype filmtype) {
		this.filmtype = filmtype;
	}

	@Column(name = "FILMNAME", length = 64)
	public String getFilmname() {
		return this.filmname;
	}

	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}

	@Column(name = "ACTOR", length = 64)
	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Column(name = "DIRECTOR", length = 64)
	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(name = "TICKETPRICE", precision = 6, scale = 0)
	public Integer getTicketprice() {
		return this.ticketprice;
	}

	public void setTicketprice(Integer ticketprice) {
		this.ticketprice = ticketprice;
	}

}