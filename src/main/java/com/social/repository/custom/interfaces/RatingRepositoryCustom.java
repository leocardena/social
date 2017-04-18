package com.social.repository.custom.interfaces;

import java.util.List;
import java.util.Optional;

import com.social.domain.Rating;
import com.social.web.rest.dto.RatingDTO;
import com.social.web.rest.dto.RatingTargetDTO;

public interface RatingRepositoryCustom {
	
	Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent);
	Optional<RatingDTO> averageAndVotesByIdRatingParent(Long idRatingParent);
	Optional<Rating> findUserRating(Long profileId, Long idRatingParent, String slug);
	Long compatibilityBetweenFriends(Long profileId, Long friendId);
	List<RatingTargetDTO<?>> findRatingsByIdProfile(Long idProfile);
	
}
