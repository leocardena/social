package com.social.business;

import org.springframework.stereotype.Service;
import com.social.web.rest.dto.PostResponseDTO;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class ShowBusinessImpl implements ShowBusiness {

	@Override
	public PostResponseDTO<UserRatingDTO> postUserRating(String showId, TitleRatingVM rating) {
		UserRatingDTO u = new UserRatingDTO();
		u.setNote(rating.getRating().getNote());
		return new PostResponseDTO<>("/api/rest/shows/" + showId + "/user-rating", u);
	}

}
