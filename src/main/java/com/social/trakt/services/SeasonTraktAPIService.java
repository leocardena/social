package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Season;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface SeasonTraktAPIService {

	/*
	 * Returns all seasons for a show including the number of episodes in each season.*/
	@GET("/shows/{id}/seasons")
	public Call<List<Season>> getSummarySeason(@Path("id") String id, @Query("extended") String extended);
	
	/* Returns all show premieres airing during the time period specified. */
	@GET("/calendars/all/shows/premieres/{start_date}/{days}")
	public Call<List<FirstAired>> getAllSeasonPremieres(@Path("start_date") String start_date, @Query("days") int days,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

}
