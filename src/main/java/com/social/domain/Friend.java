package com.social.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Friend")
public class Friend {
	
	private long id;
	
	private Profile profile;
	
	private Profile friend;
	
	private FriendStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Profile getFriend() {
		return friend;
	}

	public void setFriend(Profile friend) {
		this.friend = friend;
	}

	public FriendStatus getStatus() {
		return status;
	}

	public void setStatus(FriendStatus status) {
		this.status = status;
	}
	
}
