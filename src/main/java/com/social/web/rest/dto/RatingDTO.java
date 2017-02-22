package com.social.web.rest.dto;

public class RatingDTO {
	
	private Double average = 0.0;
	private Long votes = 0L;
	private Long idRatingParent;
	
	public RatingDTO() {
	}
	
	public RatingDTO(Double average, Long votes) {
		this.average = average;
		this.votes = votes;
	}
	
	public Double getAverage() {
		return average;
	}
	
	public void setAverage(Double average) {
		this.average = average;
	}
	
	public Long getVotes() {
		return votes;
	}
	
	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Long getIdRatingParent() {
		return idRatingParent;
	}

	public void setIdRatingParent(Long idRatingParent) {
		this.idRatingParent = idRatingParent;
	}

}
