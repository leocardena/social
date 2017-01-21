package com.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.social.domain.Movie;

public interface MovieRepository 
	extends JpaRepository<Movie, Long>{

	@Query(value = "SELECT * FROM TITLE T "
			+ "INNER JOIN MOVIE M "
			+ "ON T.idTitle = M.idTitle "
			+ "INNER JOIN RATINGPARENT RP "
			+ "ON M.idRatingParent = RP.idRatingParent "
			+ "INNER JOIN RATING R "
			+ "ON RP.idRatingParent = R.idRatingParent "
			+ "INNER JOIN PROFILE P "
			+ "ON R.idProfile = P.idProfile "
			+ "INNER JOIN USER U "
			+ "ON P.idUser = U.idUser ",
			nativeQuery = true)
	List<Movie> getMovieBySlugAndUser();
	
	Movie findOneById(Long id);
	
}
