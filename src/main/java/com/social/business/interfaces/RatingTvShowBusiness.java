package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingTvShowBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postRatingForTvShow(String showId, TitleRatingVM rating); 
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putRatingForTvShow(Long id, RatingVM rating, String slug);
	
	void deleteRatingForTvShow(Long id);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForTvShowBySlug(String slug);
}
