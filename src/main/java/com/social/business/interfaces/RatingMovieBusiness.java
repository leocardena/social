package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingMovieBusiness {

	
	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postRatingForMovie(String movieId, TitleRatingVM rating); 
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putRatingForMovie(Long idRating, RatingVM ratingVM, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteRatingForMovie(Long idRating, String movieId);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForMovieBySlug(String slug, Long idRatingParent);
	
}
