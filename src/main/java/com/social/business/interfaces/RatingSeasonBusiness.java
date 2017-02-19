package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;

public interface RatingSeasonBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postUserRatingForSeason(String showId, Long seasonNumber, RatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putUserRatingForSeason(String showId, Long seasonNumber, Long userRatingId, RatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteUserRatingForSeason(String showId, Long seasonNumber, Long userRatingId);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForSeasonBySlug(String slug, Long seasonNumber, Long userRatingId);

}
