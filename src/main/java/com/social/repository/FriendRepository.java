package com.social.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.domain.Friend;
import com.social.domain.FriendPK;
import com.social.util.FriendStatus;

public interface FriendRepository extends JpaRepository<Friend, FriendPK> {

	@Query(value = "select f from Friend f where (f.id.profile.id = :friendId and f.id.friend.id = :profileId)"
			+ " or (f.id.profile.id = :profileId and f.id.friend.id = :friendId)")
	Optional<Friend> findFriendsById(@Param("profileId")Long profileId,@Param("friendId") Long friendId);
	
	@Query(value = "select f from Friend f where f.status"
			+ " = :status and (f.id.profile.id = :profileId or f.id.friend.id = :profileId)")
	Page<Friend> findAllFriends(@Param(value = "status") FriendStatus status, @Param(value = "profileId") Long profileId,
			Pageable pageable);
	
}
