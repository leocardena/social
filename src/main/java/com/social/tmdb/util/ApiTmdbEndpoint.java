package com.social.tmdb.util;

/**
 * Interface responsável por guardar as urls utilizadas para requisitar os
 * serviços da API do TMDB
 * 
 * @author Leonardo Cardena
 *
 */
public interface ApiTmdbEndpoint {
	
	public final String MOVIE = "/api/rest/tmdb/movies";
	public final String SHOW = "/api/rest/tmdb/shows";
	public final String PERSON = "/api/rest/tmdb/persons";
	
}