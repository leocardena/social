package com.social.business.interfaces;

import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.Season;

public interface SeasonBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Season createSeason(Season season, String showId);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Optional<Season> findBySlug(String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	String getSeason(String id);

}
