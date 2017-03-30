package com.social.business.interfaces;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Profile;
import com.social.web.rest.dto.ProfileDTO;

public interface ProfileBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	ProfileDTO getProfile(String username);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Profile getProfile(Long idProfile);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	List<ProfileDTO> getLikeProfile(String username);
}
