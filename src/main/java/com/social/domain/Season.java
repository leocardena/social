package com.social.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "Season")
public class Season {
	
	private long id;
	
	private long rating;
	
	private long votes;
	
	private List<Episode> epidodes;
	
	private DateTime aired;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}

	public List<Episode> getEpidodes() {
		return epidodes;
	}

	public void setEpidodes(List<Episode> epidodes) {
		this.epidodes = epidodes;
	}

	public DateTime getAired() {
		return aired;
	}

	public void setAired(DateTime aired) {
		this.aired = aired;
	}
	
}
