package com.social.repository.custom.interfaces;

import java.util.Optional;
import com.social.domain.Rating;
import com.social.web.rest.dto.RatingDTO;

public interface RatingRepositoryCustom {
	
	Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent);
	Optional<RatingDTO> averageAndVotesByIdRatingParent(Long idRatingParent);
	
}
