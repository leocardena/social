package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {

	@Query(value = "SELECT AVG(NOTE) FROM RATING WHERE IDRATINGPARENT = :idRatingParentParam GROUP BY IDRATINGPARENT;",
			nativeQuery = true)
	long avgByIdRatingParent(@Param("idRatingParentParam") Long idRatingParent);
	
}
