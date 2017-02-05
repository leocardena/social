package com.social.business.interfaces;

import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.TvShow;
import com.social.web.rest.dto.TvShowDTO;
import com.social.web.rest.vm.TitleRatingVM;

public interface TvShowBusiness {
	
	TvShow createTvShow(TitleRatingVM titleRating, String showId);
	Optional<TvShow> findBySlug(String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	TvShowDTO getTvShow(String id);
	
}
