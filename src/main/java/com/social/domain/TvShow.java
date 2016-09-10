package com.social.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tvshow")
public class TvShow extends Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtvshow")
	private long id;
	
	@OneToMany(targetEntity=Season.class, mappedBy="tvShow", fetch=FetchType.EAGER)
	//@JoinColumn(name = "idTvShow")
	private List<Season> seasons;
	
	@ManyToMany
	@JoinTable(name = "tvshowcomments", joinColumns = {
			@JoinColumn(name = "idtvshow", referencedColumnName = "idtvshow") }, inverseJoinColumns = {
					@JoinColumn(name = "idcomment", referencedColumnName = "idcomment") })
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tvshowratings", joinColumns = {
			@JoinColumn(name = "idtvshow", referencedColumnName = "idtvshow") }, inverseJoinColumns = {
					@JoinColumn(name = "idrating", referencedColumnName = "idrating") })
	private List<Rating> ratings = new ArrayList<>();
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idratingparent")
    private RatingParent ratingParent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
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

}


