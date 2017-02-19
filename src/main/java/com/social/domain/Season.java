package com.social.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "season")
public class Season implements Serializable {
	
	private static final long serialVersionUID = -4839728303715381438L;

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
	private List<Episode> episodes = new ArrayList<Episode>();

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
	
	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aired == null) ? 0 : aired.hashCode());
		result = prime * result + ((commentParent == null) ? 0 : commentParent.hashCode());
		result = prime * result + ((episodes == null) ? 0 : episodes.hashCode());
		result = prime * result + ((idSeason == null) ? 0 : idSeason.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((ratingParent == null) ? 0 : ratingParent.hashCode());
		result = prime * result + ((tvShow == null) ? 0 : tvShow.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		if (aired == null) {
			if (other.aired != null)
				return false;
		} else if (!aired.equals(other.aired))
			return false;
		if (commentParent == null) {
			if (other.commentParent != null)
				return false;
		} else if (!commentParent.equals(other.commentParent))
			return false;
		if (episodes == null) {
			if (other.episodes != null)
				return false;
		} else if (!episodes.equals(other.episodes))
			return false;
		if (idSeason == null) {
			if (other.idSeason != null)
				return false;
		} else if (!idSeason.equals(other.idSeason))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (ratingParent == null) {
			if (other.ratingParent != null)
				return false;
		} else if (!ratingParent.equals(other.ratingParent))
			return false;
		if (tvShow == null) {
			if (other.tvShow != null)
				return false;
		} else if (!tvShow.equals(other.tvShow))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
