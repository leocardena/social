package com.social.trakt.services;

import java.util.List;

import com.social.trakt.model.Movie;
import com.social.trakt.model.People;
import com.social.trakt.model.Released;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {

	/*Returns the most popular movies*/
	@GET("/movies/popular")
	public Call<List<Movie>> getPopularMovies(@Query("page") String page, @Query("limit") String limit,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);
	
	/*Returns a single movie's details.*/
	@GET("/movies/{id}")
	public Call<Movie> getSummaryMovies(@Query("id") String id, @Query("extended") String extended);

	/*Returns all translations for a movie.*/
	@GET("/movies/{id}/translations/{language}")
	public Call<Movie> getTranslationMovie(@Query("id") String id, @Query("{language") String language);

	/*Returns all cast and crew for a movie.*/
	@GET("/movies/{id}/people")
	public Call<List<People>> getPeopleMovie(@Query("id") String id, @Query("extended") String extended);

	/*Returns related and similar movies.*/
	@GET("/movies/{id}/related")
	public Call<List<Movie>> getRelatedMovies(@Query("id") String id, @Query("page") String page,
			@Query("limit") String limit, @Query("extended") String extended);

	/*Returns all movies with a release date during the time period specified.*/
	@GET("/calendars/all/movies/{start_date}/{days}")
	public Call<List<Released>> getAllMovies(@Query("start_date") String start_date, @Query("days") int days,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

}
