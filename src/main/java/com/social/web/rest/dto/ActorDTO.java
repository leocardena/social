package com.social.web.rest.dto;

import org.joda.time.DateTime;

public class ActorDTO {

	private Long id;
	private String slug;
	private String name;
	private String imdb;
	private String country;
	private DateTime birthday;
	private RatingDTO ratingDTO;
	
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
	
	public DateTime getBirthday() {
		return birthday;
	}
	
	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}
	
	public RatingDTO getRatingDTO() {
		return ratingDTO;
	}
	
	public void setRatingDTO(RatingDTO ratingDTO) {
		this.ratingDTO = ratingDTO;
	}
}
