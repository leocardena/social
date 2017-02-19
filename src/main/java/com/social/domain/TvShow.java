package com.social.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tvshow")
@PrimaryKeyJoinColumn(name = "idtitle")
public class TvShow extends Title implements Serializable {

	private static final long serialVersionUID = -3364523662455326376L;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tvShow")
	private List<Season> season = new ArrayList<Season>();

	@OneToOne
	@JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;

	@OneToOne
	@JoinColumn(name = "idratingparent")
	private RatingParent ratingParent;

	public List<Season> getSeason() {
		return season;
	}

	public void setSeason(List<Season> season) {
		this.season = season;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((commentParent == null) ? 0 : commentParent.hashCode());
		result = prime * result + ((ratingParent == null) ? 0 : ratingParent.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TvShow other = (TvShow) obj;
		if (commentParent == null) {
			if (other.commentParent != null)
				return false;
		} else if (!commentParent.equals(other.commentParent))
			return false;
		if (ratingParent == null) {
			if (other.ratingParent != null)
				return false;
		} else if (!ratingParent.equals(other.ratingParent))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
