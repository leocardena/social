package com.social.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
public class Profile {
	
	private long id;
	
	private String genre;
	
	private String avatar;
	
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
