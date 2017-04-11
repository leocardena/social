package com.social.business.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.FriendDTO;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.response.PageableResponse;
import com.social.web.rest.vm.FriendStatusVM;
import com.social.web.rest.vm.FriendVM;

public interface FriendBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	FriendDTO postFriend(FriendVM friendVM);

	@PreAuthorize("hasRole('ROLE_USER')")
	FriendDTO getFriend(Long idFriend);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteFriend(Long idFriend);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	FriendDTO patchFriend(FriendStatusVM status, Long idFriend);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	PageableResponse<ProfileDTO> getFriends(Pageable pageable, String status);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Long getFriendsCount(String status);
	
}
