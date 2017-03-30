package com.social.repository.custom.interfaces;

import java.util.List;

import com.social.domain.Profile;

public interface ProfileRepositoryCustom {

	List<Profile> getProfileLikeUsername(String username);
	
}
