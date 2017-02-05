package com.social.domain;

import java.util.HashSet;
import java.util.Set;
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
@PrimaryKeyJoinColumn(name="idtitle")
public class TvShow extends Title {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tvShow")
	private Set<Season> season = new HashSet<Season>();
	
    @OneToOne
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;
    
    @OneToOne
    @JoinColumn(name = "idratingparent")
    private RatingParent ratingParent;
    
	public Set<Season> getSeason() {
		return season;
	}

	public void setSeason(Set<Season> season) {
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
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


