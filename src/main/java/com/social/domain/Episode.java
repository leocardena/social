package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "Episode")
public class Episode {
	
	@Column(name = "name")
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEpisode")
	private long id;
	
	@Column(name = "votes")
	private long votes;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "aired")
	private DateTime aired;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRatingParent")
	private RatingParent ratingParent;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Season season;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RatingParent getRatingParent() {
		return ratingParent;
	}

	public void setRatingParent(RatingParent ratingParent) {
		this.ratingParent = ratingParent;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}

	public DateTime getAired() {
		return aired;
	}

	public void setAired(DateTime aired) {
		this.aired = aired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
}
