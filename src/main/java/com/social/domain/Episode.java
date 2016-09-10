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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "episode")
public class Episode {
	
	@Column(name = "name")
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idepisode")
	private long id;
	
	@Column(name = "votes")
	private long votes;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "aired")
	private DateTime aired;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Season season;
	
	@ManyToMany
	@JoinTable(name = "epidosecomments", joinColumns = {
			@JoinColumn(name = "idepisode", referencedColumnName = "idepisode") }, inverseJoinColumns = {
					@JoinColumn(name = "idcomment", referencedColumnName = "idcomment") })
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "episoderatings", joinColumns = {
			@JoinColumn(name = "idepisode", referencedColumnName = "idepisode") }, inverseJoinColumns = {
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
