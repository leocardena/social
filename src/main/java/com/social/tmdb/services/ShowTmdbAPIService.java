package com.social.tmdb.services;

import com.social.tmdb.model.ShowPagination;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowTmdbAPIService {
	
	@GET("tv/popular")
	public Call<ShowPagination> getPopularShows();

}
