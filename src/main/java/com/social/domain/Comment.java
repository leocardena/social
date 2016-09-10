package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.joda.time.DateTime;

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
	
	@Column(name = "likes")
	private Long likes;
	
	@Column(name = "replies")
	private Long replies;
	
	@OneToOne
	private Comment parent;
	
	@Column(name = "dislike")
	private Long dislike;
	
	@OneToOne
	private CommentParent idCommentParent;

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

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public CommentParent getIdCommentParent() {
		return idCommentParent;
	}

	public void setIdCommentParent(CommentParent idCommentParent) {
		this.idCommentParent = idCommentParent;
	}

	public Long getDislike() {
		return dislike;
	}

	public void setDislike(Long dislike) {
		this.dislike = dislike;
	}

}
