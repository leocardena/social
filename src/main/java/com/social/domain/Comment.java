package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.joda.time.DateTime;
import java.util.List;

@Table(name = "comment")
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idcomment")
	private Long id;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "date")
	private DateTime date;
	
	@OneToOne
	private Profile profile;
	
	@Column(name = "likes")
	private Long likes;
	
	@Column(name = "replies")
	private Long replies;
	
	@OneToMany
	private List<Comment> reply;
	
	@Column(name = "dislike")
	private Long dislike;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getReplies() {
		return replies;
	}

	public void setReplies(Long replies) {
		this.replies = replies;
	}

	public List<Comment> getReply() {
		return reply;
	}

	public void setReply(List<Comment> reply) {
		this.reply = reply;
	}

	public Long getDislike() {
		return dislike;
	}

	public void setDislike(Long dislike) {
		this.dislike = dislike;
	}

}
