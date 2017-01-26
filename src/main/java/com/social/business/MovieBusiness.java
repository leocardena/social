package com.social.business;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.social.domain.Movie;

public interface MovieBusiness {
	
	@PreAuthorize("permitAll")
	public List<Movie> getAllMovies();
	
	@PreAuthorize("permitAll")
	public Movie getMovieById(String slug);
	
	@PreAuthorize("permitAll")
	public Movie getMovieByName(String name);
	
	@PreAuthorize("permitAll")
	public List<Movie> getAllMoviesByName(String name);
	
	@PreAuthorize("permitAll")
	public long getAvgRatingById(Long idRatingParent);
	
	@PreAuthorize("permitAll")
	public void insert(Movie movie);
}