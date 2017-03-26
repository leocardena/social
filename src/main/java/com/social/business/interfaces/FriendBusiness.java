package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Friend;
import com.social.web.rest.vm.FriendVM;

public interface FriendBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	Friend postFriend(FriendVM friendVM);

}
