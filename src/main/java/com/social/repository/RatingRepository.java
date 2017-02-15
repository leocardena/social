package com.social.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.social.domain.Rating;
import com.social.repository.custom.interfaces.RatingRepositoryCustom;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {
	
	Optional<Rating> findRatingByIdRating(Long idRating);
	
}
