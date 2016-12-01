package com.social.tmdb.services;

import com.social.tmdb.model.Images;
import com.social.tmdb.model.ShowPagination;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShowTmdbAPIService {
	
	@GET("tv/popular")
	public Call<ShowPagination> getPopularShows();
	
	@GET("tv/{showId}/images")
	public Call<Images> getShowImages(@Path("showId") String showId, @Query("language") String language,
			@Query("include_image_language") String includeImageLanguage);

}
