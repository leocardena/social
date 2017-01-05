package com.social.tmdb.services;

import com.social.tmdb.model.TmdbConfiguration;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ConfigurationTmdbAPIService {
	
	@GET("configuration")
	public Call<TmdbConfiguration> getTmdbConfiguration();

}
