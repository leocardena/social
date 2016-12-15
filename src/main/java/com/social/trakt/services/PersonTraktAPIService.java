package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Movie;
import com.social.trakt.model.Person;
import com.social.trakt.model.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonTraktAPIService {

	/* Returns a single person's details. */
	@GET("/people/{id}")
	public Call<Person> getSummaryPeople(@Path("id") String id, @Query("extended") String extended);

	/* Returns all movies where this person is in the cast or crew. */
	@GET("/people/{id}/movies")
	public Call<List<Movie>> getMoviesPeople(@Path("id") String id, @Query("extended") String extended);

	/* Returns all shows where this person is in the cast or crew. */
	@GET("/people/{id}/shows")
	public Call<List<Show>> getShowsPeople(@Path("id") String id, @Query("extended") String extended);

	/* Returns all cast and crew for a movie. */
	@GET("/movies/{id}/people")
	public Call<List<Person>> getPeopleMovie(@Path("id") String id, @Query("extended") String extended);

	/* Returns all cast and crew for a show. */
	@GET("/shows/{id}/people")
	public Call<List<Person>> getPeopleShow(@Path("id") String id, @Query("extended") String extended);

}
