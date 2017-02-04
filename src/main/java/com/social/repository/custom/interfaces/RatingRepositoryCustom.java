package com.social.repository.custom.interfaces;

import com.social.domain.Rating;

public interface RatingRepositoryCustom {
	
	public Rating getUserShowRatingBySlug(Long idProfile);
	
}
