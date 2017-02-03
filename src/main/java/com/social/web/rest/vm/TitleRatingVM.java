package com.social.web.rest.vm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TitleRatingVM {
	
	private String imdb;
	private String name;
	private String trailer;
	private String homePage;
	private RatingVM rating;
	
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

	public RatingVM getRating() {
		return rating;
	}

	public void setRating(RatingVM rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
