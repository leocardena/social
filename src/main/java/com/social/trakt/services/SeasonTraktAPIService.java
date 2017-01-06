package com.social.trakt.services;

import java.util.List;

import com.social.trakt.model.Episode;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Season;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SeasonTraktAPIService {

	/**
	 * Returns all seasons for a show including the number of episodes in each season.
	 * 
	 * @param id 
	 * 		  O id da serie
	 * 
	 * @param extended 
	 * 		  O detalhamento das informacoes
	 * 
	 * @return Todas as temporadas da serie
	 */
	@GET("/shows/{id}/seasons")
	public Call<List<Season>> getSummarySeason(@Path("id") String id, @Query("extended") String extended);
	
	/**
	 * Retorna todos os episodios de uma temporada em especifico
	 * 
	 * @param showId
	 * 	 	  O id da serie
	 * 
	 * @param seasonNumber
	 * 		  O numero da temporada
	 * 
	 * @param translations
	 * 		  O idioma no qual a serie sera traduzida
	 * 
	 * @return Os episodios da serie
	 */
	@GET("/shows/{showId}/seasons/{seasonNumber}")
	public Call<List<Episode>> getSingleSeasonForAShow(@Path("showId") String showId, @Path("seasonNumber") String seasonNumber, 
			@Query("translations") String translations);
	
	/**
	 *  Returns all show premieres airing during the time period specified.
	 *  
	 * @param start_date
	 * 	      Data inicial
	 * 
	 * @param days
	 *  	  Quantidade de dias
	 *  
	 * @param extended
	 * 		  O detalhamento das informacoes
	 * 
	 * @param query
	 * 		  O texto de pesquisa
	 * 
	 * @param genres
	 * 		  O generos
	 * 
	 * @return Os lancamentos de series durante o intervalo especificado
	 */
	@GET("/calendars/all/shows/premieres/{start_date}/{days}")
	public Call<List<FirstAired>> getAllSeasonPremieres(@Path("start_date") String start_date, @Path("days") String days,
			@Query("extended") String extended, @Query("query") String query, @Query("genres") String genres);

}
