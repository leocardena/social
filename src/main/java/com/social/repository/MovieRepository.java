package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.domain.Movie;

public interface MovieRepository 
	extends JpaRepository<Movie, Long>{

	@Query(value = "SELECT * FROM TITLE T INNER JOIN MOVIE M ON T.idTitle = M.idTitle INNER JOIN RATINGPARENT RP ON M.idRatingParent = RP.idRatingParent INNER JOIN RATING R ON RP.idRatingParent = R.idRatingParent INNER JOIN PROFILERATINGS PR ON R.idRating = PR.idRating INNER JOIN PROFILE P ON PR.idProfile = P.idProfile INNER JOIN USER U ON P.idUser = U.idUser WHERE U.username = :usernameParam AND T.slug = :slugParam", 
				nativeQuery = true)
	Movie getMovieBySlugAndUser(@Param("usernameParam") String username, @Param("slugParam") String slug);
}
