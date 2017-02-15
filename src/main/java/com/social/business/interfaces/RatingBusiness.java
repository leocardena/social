package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postRatingForTvShow(String showId, TitleRatingVM rating); 
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putRatingForTvShow(Long ratingIdidRating, RatingVM rating, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteRatingForTvShow(Long idRating, String showId);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForTvShowBySlug(String slug, Long idRating);
}
