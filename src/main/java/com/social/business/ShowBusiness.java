package com.social.business;

import com.social.web.rest.dto.PostResponseDTO;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.vm.TitleRatingVM;

public interface ShowBusiness {
	
	PostResponseDTO<UserRatingDTO> postUserRating(String showId, TitleRatingVM rating); 
	
}
