package com.social.repository.custom;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.QRating;
import com.social.domain.QRatingParent;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;
import com.social.web.rest.dto.RatingDTO;

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
	
	public Optional<Rating> findUserRating(Long profileId, Long idRatingParent, String slug) {
		
		QRating rating = new QRating("r");
		QRatingParent ratingParent = new QRatingParent("rp");
		
		Rating ratingResult = new JPAQuery<Rating>(em)
				.select(rating)
				.from(rating)
				.join(rating.idRatingParent, ratingParent)
				.where(rating.profile.eq(profileId))
				.where(ratingParent.id.eq(idRatingParent))
				.fetchOne();
		
		return Optional.ofNullable(ratingResult);
	}

	@Override
	public Optional<RatingDTO> averageAndVotesByIdRatingParent(Long idRatingParent) {
		QRating rating = QRating.rating;
		
		return new JPAQueryFactory(em)
			.select(rating.note.avg(), rating.idRating.count())
			.from(rating)
			.where(rating.idRatingParent.id.eq(idRatingParent))
			.groupBy(rating.idRatingParent)
			.fetch()
			.stream()
			.map(r -> new RatingDTO(r.get(rating.note.avg()).doubleValue(),
					r.get(rating.idRating.count()).longValue()))
			.findFirst();
	}

	@Override
	public Long compatibilityBetweenFriends(Long profileId, Long friendId) {
		QRating rating = QRating.rating;
		
		return new JPAQueryFactory(em)
			.select(rating.idRatingParent.count())
			.from(rating)
			.where(rating.profile.eq(profileId).or(rating.profile.eq(friendId)))
			.where(rating.note.gt(4))
			.groupBy(rating.idRatingParent)
			.having(rating.idRatingParent.count().gt(1))
			.fetchCount();
	}
	
}
