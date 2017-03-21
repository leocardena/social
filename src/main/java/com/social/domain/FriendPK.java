package com.social.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FriendPK implements Serializable {
	
	private static final long serialVersionUID = 1086083733282299984L;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="idprofile")
	private Profile profile; //logado
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="idFriend")
	private Profile friend; //getProfile
	
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
