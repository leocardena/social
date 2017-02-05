package com.social.business.interfaces;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingBusiness {
	
	PostResponseAPI<UserRatingDTO> postRatingForTvShow(String showId, TitleRatingVM rating); 
	UserRatingDTO putRatingForTvShow(Long id, RatingVM rating);
	void deleteRatingForTvShow(Long id);
	UserRatingDTO getUserRatingForTvShowBySlug(String slug);
}
