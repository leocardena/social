package com.social.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FriendPK implements Serializable {

	private static final long serialVersionUID = 1634956311600917256L;

//	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="idprofile")
	private Long profile;
	
//	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name="idfriend")
	private Long friend;
	
	public FriendPK() {
	}
	
	public FriendPK(Long profile, Long friend) {
		this.profile = profile;
		this.friend = friend;
	}
	
	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public Long getFriend() {
		return friend;
	}

	public void setFriend(Long friend) {
		this.friend = friend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendPK other = (FriendPK) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}
	
	


	
}
