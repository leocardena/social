package com.social.business;

import com.social.business.interfaces.RatingSeasonBusiness;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;

public class RatingSeasonBusinessImpl implements RatingSeasonBusiness {

	@Override
	public PostResponseAPI<UserRatingDTO> postUserRatingForSeason(String showId, Long seasonNumber, RatingVM rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRatingDTO putUserRatingForSeason(String showId, Long seasonNumber, Long userRatingId, RatingVM rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserRatingForSeason(String showId, Long seasonNumber, Long userRatingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserRatingDTO getUserRatingForSeasonBySlug(String slug, Long seasonNumber, Long userRatingId) {
		// TODO Auto-generated method stub
		return null;
	}


}
