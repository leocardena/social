package com.social.web.rest.vm;

public class ActorRatingVM {

	private String name;
	private String imdb;
	private String country;
	private RatingVM rating;
	
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
	
	public RatingVM getRating() {
		return rating;
	}
	
	public void setRating(RatingVM rating) {
		this.rating = rating;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
