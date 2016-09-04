package com.social.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Actor")
public class Actor {
	
	private String imdb;
	
	private String id;
	
	private String born;

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}
	
}
