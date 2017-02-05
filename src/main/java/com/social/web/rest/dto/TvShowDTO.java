package com.social.web.rest.dto;

public class TvShowDTO {

	private long id;
	private String slug;
	private String imdb;
	private String name;
	private String trailer;
	private String homePage;
	private Long votes;
	private Double noteAverage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Double getNoteAverage() {
		return noteAverage;
	}

	public void setNoteAverage(Double noteAverage) {
		this.noteAverage = noteAverage;
	}
	
}
