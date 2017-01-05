package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Genre;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GenreTraktAPIService {

	@GET("/genres/{type}")
	public Call<List<Genre>> getListGenres(@Path("type") String type);
}
