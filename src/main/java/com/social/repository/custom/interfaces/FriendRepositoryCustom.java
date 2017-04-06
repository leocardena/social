package com.social.repository.custom.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.social.domain.Friend;
import com.social.util.FriendStatus;

public interface FriendRepositoryCustom {

	public Page<Friend> findAllFriends(FriendStatus status, Long profileId, Pageable pageable);

}
