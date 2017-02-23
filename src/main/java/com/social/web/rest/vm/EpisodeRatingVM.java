package com.social.web.rest.vm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EpisodeRatingVM {
	
	private String name;
	private Long number;
	private RatingVM rating;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public RatingVM getRating() {
		return rating;
	}

	public void setRating(RatingVM rating) {
		this.rating = rating;
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
