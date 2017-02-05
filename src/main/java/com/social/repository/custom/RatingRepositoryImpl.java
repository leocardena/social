package com.social.repository.custom;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.QRating;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

public class RatingRepositoryImpl implements RatingRepositoryCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Optional<Rating> findRatingByRatingParentAndProfile(Long idProfile, Long idRatingParent) {
		QRating rating = QRating.rating;
		
		Rating ratingResult = new JPAQuery<Rating>(em)
					.from(rating)
					.where(rating.profile.eq(idProfile).and(rating.idRatingParent.id.eq(idRatingParent)))
					.fetchOne();
		
		return Optional.ofNullable(ratingResult);
	}

	@Override
	public Double averageByIdRatingParent(Long idRatingParent) {
		QRating rating = QRating.rating;
		
		return new JPAQueryFactory(em).select(rating.note.avg())
			.from(rating)
			.where(rating.idRatingParent.id.eq(idRatingParent))
			.fetchOne();
	}

}
