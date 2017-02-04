package com.social.business;

import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.TitleRatingVM;

public interface RatingBusiness {
	
	PostResponseAPI<UserRatingDTO> postRatingForTvShow(String showId, TitleRatingVM rating); 
	void get(String showId);
}
