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

	/**
	 * Retorna as pessoas relacionadas ao filme
	 * 
	 * @param movieId o id do filme
	 * @param extended o detalhamento de informacoes
	 * @return as pessoas relacionadas ao filme
	 */
	@GET("/movies/{movieId}/people")
	public Call<Movie> getAllPeopleForAMovie(@Path("movieId") String movieId, @Query("extended") String extended);

	/**
	 * Retorna as pessoas relacionadas a serie
	 * 
	 * @param showId 
	 *        o id da serie
	 *        
	 * @param extended 
	 *        o detalhamento de informacoes
	 *        
	 * @return as pessoas relacionadas ao filme
	 */
	@GET("/shows/{showId}/people")
	public Call<Show> getAllPeopleForAShow(@Path("showId") String showId, @Query("extended") String extended);

}
