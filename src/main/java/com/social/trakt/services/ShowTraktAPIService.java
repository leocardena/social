package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShowTraktAPIService {

	/* Returns the most popular shows. */
	@GET("/shows/popular")
	public Call<List<Show>> getPopularShows(@Query("page") String page, @Query("limit") String limit,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

	/* Returns a single shows's details. */
	@GET("/shows/{id}")
	public Call<Show> getSummaryShow(@Path("id") String id, @Query("extended") String extended);

	/* Returns all translations for a show. */
	@GET("/shows/{id}/translations/{language}")
	public Call<List<Show>> getShowTranslation(@Path("id") String id, @Path("language") String language,
			@Query("extented") String extented);

	/* Returns related and similar shows. */
	@GET("/shows/id/related")
	public Call<List<Show>> getRelatedShows(@Query("id") String id, @Query("page") String page,
			@Query("limit") String limit, @Query("extended") String extended);

	/* Returns all shows airing during the time period specified. */
	@GET("/calendars/all/shows/{start_date}/{days}")
	public Call<List<FirstAired>> getAllShows(@Path("start_date") String start_date, @Query("days") int days,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

	/* Returns all new show premieres during the time period specified. */
	@GET("/calendars/all/shows/new/{start_date}/{days}")
	public Call<List<FirstAired>> getNewAllShows(@Query("start_date") String start_date, @Path("days") int days,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

}
