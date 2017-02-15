package com.social.web.rest.dto;

public class UserRatingDTO {
	
	private Integer note;
	
	public UserRatingDTO() {}

	public UserRatingDTO(Integer note) {
		this.note = note;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

}
