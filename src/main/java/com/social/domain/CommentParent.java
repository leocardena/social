package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "commentparent")
@Entity
public class CommentParent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idcommentparent")
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcomment")
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
