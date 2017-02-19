package com.social.web.rest.dto;

public class SeasonDTO {

	private long id;
	private long idTvShow;
	private String name;
	private Integer number;
	private String aired;
	private RatingDTO rating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdTvShow() {
		return idTvShow;
	}

	public void setIdTvShow(long idTvShow) {
		this.idTvShow = idTvShow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getAired() {
		return aired;
	}

	public void setAired(String aired) {
		this.aired = aired;
	}

	public RatingDTO getRating() {
		return rating;
	}

	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}

}
