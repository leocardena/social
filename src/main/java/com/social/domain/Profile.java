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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "profile")
public class Profile extends People {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idprofile")
	private Long id;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "avatar")
	private String avatar;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "iduser")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "profilecomments", joinColumns = {
			@JoinColumn(name = "idprofile", referencedColumnName = "idprofile") }, inverseJoinColumns = {
					@JoinColumn(name = "idcomment", referencedColumnName = "idcomment") })
	private List<Comment> comments = new ArrayList<>();
	
//	@OneToMany
//	@JoinTable(name = "profileratings", joinColumns = {
//			@JoinColumn(name = "idprofile", referencedColumnName = "idprofile") }, inverseJoinColumns = {
//					@JoinColumn(name = "idrating", referencedColumnName = "idrating") })
//	private List<Rating> ratings = new ArrayList<>();
	
	@OneToMany(mappedBy = "profile")
	private List<Rating> ratings = new ArrayList<>();
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
