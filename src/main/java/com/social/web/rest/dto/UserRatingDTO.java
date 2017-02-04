package com.social.web.rest.dto;

public class UserRatingDTO {
	
	private Integer note;
	private Long id;
	
	public UserRatingDTO() {}

	public UserRatingDTO(Integer note, Long id) {
		super();
		this.note = note;
		this.id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
