package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Friend;
import com.social.domain.FriendPK;

public interface FriendRepository extends JpaRepository<Friend, FriendPK>{

}
