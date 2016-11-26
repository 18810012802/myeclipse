package com.libo.entity;

public class Area {
	public Area() {
		super();
	}
	
	public Area(int id, int tid, String name) {
		this.id = id;
		this.tid = tid;
		this.name = name;
	}

	private int id;
	private int tid;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
