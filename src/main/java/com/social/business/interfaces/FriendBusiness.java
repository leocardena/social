package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Friend;
import com.social.web.rest.dto.FriendDTO;
import com.social.web.rest.vm.FriendVM;

public interface FriendBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	Friend postFriend(FriendVM friendVM);

	@PreAuthorize("hasRole('ROLE_USER')")
	FriendDTO getFriend(Long idProfile);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteFriend(Long idProfile);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	FriendDTO putFriend(String status);
	
}
