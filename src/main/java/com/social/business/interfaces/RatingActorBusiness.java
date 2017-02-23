package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.ActorRatingVM;
import com.social.web.rest.vm.RatingVM;

public interface RatingActorBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postRatingForActor(String slug, ActorRatingVM actorRatingVM);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putRatingForActor(Long idRating, RatingVM ratingVM, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteRatingForActor(Long idRating, String slug);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForActor(String slug, Long idRatingParent);
	
	
}
