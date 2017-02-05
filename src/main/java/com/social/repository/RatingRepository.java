package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {

	@Query(value = "SELECT AVG(NOTE) FROM RATING WHERE IDRATINGPARENT = :idRatingParentParam GROUP BY IDRATINGPARENT;",
			nativeQuery = true)
	Long avgByIdRatingParent(@Param("idRatingParentParam") Long idRatingParent);
	
	@Query(value = "SELECT r.* FROM Rating r INNER JOIN TvShow tv ON r.idRatingParent = tv.idRatingParent INNER JOIN Title t ON tv.idTitle = t.idTitle WHERE r.idProfile = ?1 AND t.slug = ?2", 
			nativeQuery = true)
	Optional<Rating> findRatingShowBySlug(Long idProfile, String slug);
	
}
