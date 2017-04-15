package com.social.web.rest.vm;

import org.joda.time.DateTime;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.social.util.CustomDateTimeSerializer;

public class AccountVM {

	private String name;
	private String lastName;
	private String country;
	private String genre;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
