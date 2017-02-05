package com.social.repository.custom.interfaces;

import java.util.Optional;

import com.social.domain.Rating;

public interface RatingRepositoryCustom {
	
	Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent);
	Double averageByIdRatingParent(Long idRatingParent);
	
}
