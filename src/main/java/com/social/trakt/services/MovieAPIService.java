package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MovieAPIService {
	
	@GET("/movies/popular")
	public Call<List<Movie>> getPopularMovies( @Query("page") String page,
			@Query("limit") String limit, @Query("extended") String extended );

}
