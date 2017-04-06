package com.social.business.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.Profile;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.response.PageableResponse;

public interface ProfileBusiness {

	@PreAuthorize("permitAll")
	ProfileDTO getProfile(String username);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Profile getProfile(Long idProfile);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	PageableResponse<ProfileDTO> getLikeProfile(String username, Pageable pageable);
}
