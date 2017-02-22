package com.social.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserRatingDTO {
	
	private Long id;
	private Integer note;
	
	public UserRatingDTO() {}

	public UserRatingDTO(Integer note, Long id) {
		this.note = note;
		this.id = id;
	}
	
	public UserRatingDTO(Integer note) {
		this.note = note;
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
