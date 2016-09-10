package com.social.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor extends People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idactor")
	private String id;
	
	@Column(name = "imdb")
	private String imdb;
	
	@ManyToMany
	@JoinTable(name = "actorcomments", joinColumns = {
			@JoinColumn(name = "idactor", referencedColumnName = "idactor") }, inverseJoinColumns = {
					@JoinColumn(name = "idcomment", referencedColumnName = "idcomment") })
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "actorratings", joinColumns = {
			@JoinColumn(name = "idactor", referencedColumnName = "idactor") }, inverseJoinColumns = {
					@JoinColumn(name = "idrating", referencedColumnName = "idrating") })
	private List<Rating> ratings = new ArrayList<>();
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idratingparent")
    private RatingParent ratingParent;
	
	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
