package com.social.web.rest.vm;

import org.joda.time.DateTime;

public class ActorRatingVM {

	private String name;
	private String imdb;
	private String country;
	private DateTime birthday;
	private RatingVM ratingVM;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImdb() {
		return imdb;
	}
	
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	
	public DateTime getBirthday() {
		return birthday;
	}
	
	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}
	
	public RatingVM getRatingVM() {
		return ratingVM;
	}
	
	public void setRatingVM(RatingVM ratingVM) {
		this.ratingVM = ratingVM;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
		
}
