package com.social.web.rest.dto;

import com.social.util.Compatibility;

public class ProfileDTO {

	private Long id;
	private String country;
	private String name;
	private String genre;
	private String avatar;
	private String compatibility;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(String compatibility) {
		this.compatibility = compatibility;
	}
	
}
