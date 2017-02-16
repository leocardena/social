package com.social.repository.custom.interfaces;

import java.util.Optional;
import com.social.domain.Rating;
import com.social.repository.dto.RatingQueryDTO;

public interface RatingRepositoryCustom {
	
	Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent);
	Optional<RatingQueryDTO> averageByIdRatingParent(Long idRatingParent);
	
}
