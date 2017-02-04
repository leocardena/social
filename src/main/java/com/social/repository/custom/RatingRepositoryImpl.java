package com.social.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.QRating;
import com.social.domain.QProfile;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

public class RatingRepositoryImpl implements RatingRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Rating getUserShowRatingBySlug(Long idProfile) {
		 JPAQueryFactory query = new JPAQueryFactory(em);
		
		QRating rating = QRating.rating;
		QProfile profile = QProfile.profile;
		
		return null;
	}
}


