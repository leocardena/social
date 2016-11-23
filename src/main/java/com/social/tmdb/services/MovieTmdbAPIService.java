package com.social.tmdb.services;

import com.social.tmdb.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieTmdbAPIService {
	
	@GET("movie/popular")
	public Call<MovieResponse> getPopularMovies();
	
}
