package com.social.web.rest.vm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EpisodeRatingVM {
	
	private String name;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
