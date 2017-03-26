package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.web.rest.dto.ProfileDTO;

public interface ProfileBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	ProfileDTO getProfile(String username);
	
}
