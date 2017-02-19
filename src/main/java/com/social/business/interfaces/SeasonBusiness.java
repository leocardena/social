package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.SeasonDTO;

public interface SeasonBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	SeasonDTO getSeason(Integer seasonNumber, String showId);

}
