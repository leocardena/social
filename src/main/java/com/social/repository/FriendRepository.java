package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Friend;
import com.social.domain.FriendPK;

public interface FriendRepository extends JpaRepository<Friend, FriendPK>{

	Optional<Friend> findOneById(FriendPK friendPK);
	
}
