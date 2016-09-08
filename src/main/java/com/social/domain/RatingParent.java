package com.social.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class RatingParent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRatingParent")
	private String id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRating")
	private Rating rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
}
