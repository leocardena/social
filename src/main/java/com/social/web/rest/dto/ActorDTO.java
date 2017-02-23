package com.social.web.rest.dto;

public class ActorDTO {

	private Long id;
	private String slug;
	private String name;
	private String imdb;
	private String country;
	private String birthday;
	private RatingDTO rating;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
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
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public RatingDTO getRatingDTO() {
		return rating;
	}
	
	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}
}
