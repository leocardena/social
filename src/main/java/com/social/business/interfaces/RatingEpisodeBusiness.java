package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.EpisodeRatingVM;
import com.social.web.rest.vm.RatingVM;

public interface RatingEpisodeBusiness {

	@PreAuthorize("hasRole('ROLE_USER')")
	PostResponseAPI<UserRatingDTO> postUserRatingForEpisode(String showId, Integer seasonNumber, Integer episodeNumber,
			EpisodeRatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO putUserRatingForEpisode(String showId, Integer seasonNumber, Long userRatingId, Integer episodeNumber,
			RatingVM rating);

	@PreAuthorize("hasRole('ROLE_USER')")
	void deleteUserRatingForEpisode(String showId, Integer seasonNumber, Integer episodeNumber, Long userRatingId);

	@PreAuthorize("hasRole('ROLE_USER')")
	UserRatingDTO getUserRatingForEpisode(String slug, Integer seasonNumber, Integer episodeNumber,
			Long idRatingParent);

}
