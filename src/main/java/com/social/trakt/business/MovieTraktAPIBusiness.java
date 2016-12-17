package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.ResponseAPI;
import com.social.trakt.model.Movie;
import com.social.trakt.model.Released;

public interface MovieTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Movie>> getPopularMovies(String page, String limit, String extended, String query,
			String genres);
	
	@PreAuthorize("permitAll")
	public Movie getSummaryMovie(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Movie> getMovieTranslation(String id, String language, String extended);
	
	@PreAuthorize("permitAll")
	public List<Movie> getRelatedMovies(String id, String page, String limit, String extended);
	
	@PreAuthorize("permitAll")
	public List<Released> getAllMovies(String start_date, int days, String extended, String query, String genres);
	
}