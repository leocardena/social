package com.social.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.QRating;
import com.social.domain.QRatingParent;
import com.social.domain.QTitle;
import com.social.domain.QTvShow;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

public class RatingRepositoryImpl implements RatingRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Rating getUserShowRatingBySlug(Long idProfile, String slug) {
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		QRating rating = QRating.rating;
		QRatingParent ratingParent = QRatingParent.ratingParent;
		QTvShow tvShow = QTvShow.tvShow;
		QTitle title = QTitle.title;
		
		return null;
				
	}

}
