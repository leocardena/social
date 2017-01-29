package com.social.web.rest.vm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RatingVM {
	
	private Integer note;

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
