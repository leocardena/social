package com.social.web.rest.dto;

public class MovieDTO {

	private Long id;
	private String slug;
	private String imdb;
	private String name;
	private String trailer;
	private String homePage;
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
	
	public String getImdb() {
		return imdb;
	}
	
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTrailer() {
		return trailer;
	}
	
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public String getHomePage() {
		return homePage;
	}
	
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	public RatingDTO getRating() {
		return rating;
	}

	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}
	
}
