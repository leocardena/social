package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Episode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EpisodeTraktAPIService {

	/* Returns a single episode's details. */
	@GET("/shows/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}")
	public Call<Episode> getSummaryEpisode(@Path("showId") String showId, @Path("seasonNumber") String seasonNumber,
			@Path("episodeNumber") String episodeNumber, @Query("extended") String extended);

	@GET("/shows/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/translations/{language}")
	public Call<List<Episode>> getTranslationsForAEpisode(@Path("showId") String showId,
			@Path("seasonNumber") String seasonNumber, @Path("episodeNumber") String episodeNumber,
			@Path("language") String language);
}
