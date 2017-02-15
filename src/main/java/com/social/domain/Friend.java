package com.social.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.social.util.FriendStatus;

@Entity
@Table(name = "friend")
@AssociationOverrides({
    @AssociationOverride(name = "id.profile",
        joinColumns = @JoinColumn(name = "idprofile")),
    @AssociationOverride(name = "id.friend",
        joinColumns = @JoinColumn(name = "idfriend")) })
public class Friend {
	
	@EmbeddedId
	private FriendPK id;
	
	@Enumerated(EnumType.STRING)
	private FriendStatus status;

	public FriendStatus getStatus() {
		return status;
	}

	public void setStatus(FriendStatus status) {
		this.status = status;
	}
	
	public FriendPK getId() {
		return id;
	}

	public void setId(FriendPK id) {
		this.id = id;
	}
	
	@Transient
	public Profile getProfile() {
		return getId().getProfile();
	}
	
	public void setProfile(Profile profile) {
		getId().setProfile(profile);
	}
	
	@Transient
	public Profile getFriend() {
		return getId().getFriend();
	}
	
	public void setFriend(Profile friend) {
		getId().setFriend(friend);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
