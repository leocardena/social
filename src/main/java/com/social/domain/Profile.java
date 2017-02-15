package com.social.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profilecomments", joinColumns = {
			@JoinColumn(name = "idprofile", referencedColumnName = "idprofile") }, inverseJoinColumns = {
					@JoinColumn(name = "idcomment", referencedColumnName = "idcomment") })
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
	private Set<Rating> ratings = new HashSet<Rating>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
	private Set<Lists> lists = new HashSet<Lists>();
	
	@OneToMany(mappedBy = "id.profile", fetch = FetchType.EAGER)
	private Set<Friend> friends =  new HashSet<Friend>();
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
	private Set<Message> messages =  new HashSet<Message>();
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
	private Set<EpisodeManager> managers =  new HashSet<EpisodeManager>();
	
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

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<EpisodeManager> getManagers() {
		return managers;
	}

	public void setManagers(Set<EpisodeManager> managers) {
		this.managers = managers;
	}

	public Set<Lists> getLists() {
		return lists;
	}

	public void setLists(Set<Lists> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
