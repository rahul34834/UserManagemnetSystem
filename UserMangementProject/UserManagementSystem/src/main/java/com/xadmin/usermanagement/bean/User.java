package com.xadmin.usermanagement.bean;

public class User {
	
	private int id;
	private String name;
	private String emial;
	private String country;
	
	
	public User(String name, String emial, String country) {
		super();
		this.name = name;
		this.emial = emial;
		this.country = country;
	}


	public User(int id, String name, String emial, String country) {
		super();
		this.id = id;
		this.name = name;
		this.emial = emial;
		this.country = country;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
