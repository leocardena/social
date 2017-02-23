package com.social.business;

import org.springframework.stereotype.Service;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.EpisodeRatingVM;
import com.social.web.rest.vm.RatingVM;

@Service
public class RatingEpisodeBusiness implements com.social.business.interfaces.RatingEpisodeBusiness {

	@Override
	public PostResponseAPI<UserRatingDTO> postUserRatingForEpisode(String showId, Integer seasonNumber,
			Integer episodeNumber, EpisodeRatingVM rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRatingDTO putUserRatingForEpisode(String showId, Integer seasonNumber, Long userRatingId,
			Integer episodeNumber, RatingVM rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserRatingForEpisode(String showId, Integer seasonNumber, Integer episodeNumber,
			Long userRatingId) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserRatingDTO getUserRatingForEpisode(String slug, Integer seasonNumber, Integer episodeNumber,
			Long idRatingParent) {
		// TODO Auto-generated method stub
		return null;
	}

}
