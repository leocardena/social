package com.social.tmdb.business;

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.tmdb.model.Movie;

public interface MovieTmdbAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Movie getPopularRandomMovie(String size);
	
	@PreAuthorize("permitAll")
	public Map<String, Object> getMovieImages(String movieId, String backdropSize, String posterSize, String language);

}
