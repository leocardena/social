package com.social.web.rest.dto;

import com.social.domain.Friend;

public class FriendDTO {

	private String status;

	public static FriendDTO build(Friend friend) {
		FriendDTO friendDTO = new FriendDTO();
		friendDTO.setStatus(friend.getStatus().toString());
		return friendDTO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
