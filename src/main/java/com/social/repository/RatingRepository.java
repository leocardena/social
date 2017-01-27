package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.domain.Rating;

public interface RatingRepository 
	extends JpaRepository<Rating, Long>{

	@Query(value = "SELECT AVG(NOTE) FROM RATING WHERE IDRATINGPARENT = :idRatingParentParam GROUP BY IDRATINGPARENT;",
			nativeQuery = true)
	long avgByIdRatingParent(@Param("idRatingParentParam") Long idRatingParent);
	
}
