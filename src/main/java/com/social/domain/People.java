package com.social.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "People")
public class People {
	
	private long id;
	
	private DateTime birthay;
	
	private String name;
	
	private String country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DateTime getBirthay() {
		return birthay;
	}

	public void setBirthay(DateTime birthay) {
		this.birthay = birthay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
