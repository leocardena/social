package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingSeasonBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postUserRatingForSeason(String showId, Integer seasonNumber, TitleRatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putUserRatingForSeason(String showId, Integer seasonNumber, Long userRatingId, RatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteUserRatingForSeason(String showId, Integer seasonNumber, Long userRatingId);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForSeasonBySlug(String slug, Integer seasonNumber, Long idRatingParent);

}
