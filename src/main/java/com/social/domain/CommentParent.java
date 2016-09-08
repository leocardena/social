package com.social.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class CommentParent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCommentParent")
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idComment")
	private Comment comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
