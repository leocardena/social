package com.social.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvatarDTO {
	
	@JsonProperty("url")
	private String url;
	
	public AvatarDTO(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
