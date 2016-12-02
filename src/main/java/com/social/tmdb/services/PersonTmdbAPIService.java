package com.social.tmdb.services;

import com.social.tmdb.model.Images;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonTmdbAPIService {
	
	@GET("person/{personId}/images")
	public Call<Images> getPersonImages(@Path("personId") String personId);

}
