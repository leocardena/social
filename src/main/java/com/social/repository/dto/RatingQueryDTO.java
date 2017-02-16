package com.social.repository.dto;

public class RatingQueryDTO {
	
	private Double average;
	private Long votes;
	
	public RatingQueryDTO() {
	}
	
	public RatingQueryDTO(Double average, Long votes) {
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

}
