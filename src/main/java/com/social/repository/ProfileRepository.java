package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Profile;
import com.social.domain.User;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	Optional<Profile> findOneByUser(User user);
	
	Profile findOneByName(String name);
	
}
