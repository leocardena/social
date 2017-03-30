package com.social.web.rest.dto;

import com.social.domain.FriendPK;

public class FriendDTO {

	private FriendPK id;
	private String status;
	
	public FriendPK getId() {
		return id;
	}
	public void setId(FriendPK id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
