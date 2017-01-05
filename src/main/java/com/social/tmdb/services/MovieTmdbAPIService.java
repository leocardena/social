package com.social.tmdb.services;

import com.social.tmdb.model.Images;
import com.social.tmdb.model.MoviePagination;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieTmdbAPIService {

	@GET("movie/popular")
	public Call<MoviePagination> getPopularMovies();

	@GET("movie/{movieId}/images")
	public Call<Images> getMovieImages(@Path("movieId") String movieId, @Query("language") String language,
			@Query("include_image_language") String includeImageLanguage);

}
