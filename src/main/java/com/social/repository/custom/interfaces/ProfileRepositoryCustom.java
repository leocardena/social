package com.social.repository.custom.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.social.domain.Profile;

public interface ProfileRepositoryCustom {

	 Page<Profile> getProfileLikeUsername(String username, Pageable pageable);
	
}
