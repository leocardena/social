package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchTraktAPIService {

	@GET("/search/{type}")
	public Call<List<Search>> getSearch(@Path("type") String type, @Query("page") String page,
			@Query("limit") String limit, @Query("extended") String extended, @Query("query") String query,
			@Query("fields") String fields);

}
