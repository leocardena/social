package com.social.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "season")
public class Season {
	
	@Column(name = "idtvshow")
	private Long tvShow;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idseason")
	private Long idSeason;

	@Column(name = "name")
	private String name;

	@Column(name = "number")
	private Integer number;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "season")
	private Set<Episode> epidodes = new HashSet<Episode>();

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "aired")
	private DateTime aired;

	@OneToOne
	@JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;

	@OneToOne
	@JoinColumn(name = "idratingparent")
	private RatingParent ratingParent;
	
	public Season createFrom(com.social.trakt.model.Season traktSeason, Long idTvShow) {
		
		Season season = new Season();
		season.setNumber(traktSeason.getNumber());
		season.setName(traktSeason.getTitle() != null ? traktSeason.getTitle() : null);
		season.setAired(traktSeason.getFirstAired() != null ? new DateTime(traktSeason.getFirstAired()) : null);
		season.setTvShow(idTvShow);
	
		return season;
	}

	public Long getTvShow() {
		return tvShow;
	}

	public void setTvShow(Long tvShow) {
		this.tvShow = tvShow;
	}
	
	public Long getIdSeason() {
		return idSeason;
	}

	public void setIdSeason(Long idSeason) {
		this.idSeason = idSeason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Episode> getEpidodes() {
		return epidodes;
	}

	public void setEpidodes(Set<Episode> epidodes) {
		this.epidodes = epidodes;
	}

	public DateTime getAired() {
		return aired;
	}

	public void setAired(DateTime aired) {
		this.aired = aired;
	}

	public CommentParent getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(CommentParent commentParent) {
		this.commentParent = commentParent;
	}

	public RatingParent getRatingParent() {
		return ratingParent;
	}

	public void setRatingParent(RatingParent ratingParent) {
		this.ratingParent = ratingParent;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
