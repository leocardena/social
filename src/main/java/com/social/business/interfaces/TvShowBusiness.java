package com.social.business.interfaces;

import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.TvShow;
import com.social.web.rest.dto.TvShowDTO;
import com.social.web.rest.vm.TitleRatingVM;

public interface TvShowBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	TvShow createTvShow(TitleRatingVM titleRating, String showId);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Optional<TvShow> findBySlug(String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	TvShowDTO getTvShow(String id);
	
}
