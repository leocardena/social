package com.social.web.rest.dto;

public class RatingTargetDTO<T> {

	private UserRatingDTO rating;
	private String type;
	private T title;
	
	public RatingTargetDTO() {}

	public RatingTargetDTO(UserRatingDTO rating, T title, String type) {
		super();
		this.rating = rating;
		this.title = title;
		this.type = type;
	}

	public UserRatingDTO getRating() {
		return rating;
	}

	public void setRating(UserRatingDTO rating) {
		this.rating = rating;
	}

	public T getTitle() {
		return title;
	}

	public void setTitle(T title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
