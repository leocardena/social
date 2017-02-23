package com.social.web.rest.dto;

import org.joda.time.DateTime;

public class EpisodeDTO {

	private Long idEpisode;
	private Long season;
	private String name;
	private Long number;
	private DateTime aired;
	private RatingDTO rating;

	public Long getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(Long idEpisode) {
		this.idEpisode = idEpisode;
	}

	public Long getSeason() {
		return season;
	}

	public void setSeason(Long season) {
		this.season = season;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public DateTime getAired() {
		return aired;
	}

	public void setAired(DateTime aired) {
		this.aired = aired;
	}

	public RatingDTO getRating() {
		return rating;
	}

	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}

}
