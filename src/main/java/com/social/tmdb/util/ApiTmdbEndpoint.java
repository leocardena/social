package com.social.tmdb.util;

/**
 * Interface responsável por guardar as urls utilizadas para requisitar os
 * serviços da API do TMDB
 * 
 * @author Leonardo Cardena
 *
 */
public interface ApiTmdbEndpoint {
	
	public final String MOVIE = "/api/rest/tmdb/movie";
	public final String SHOW = "/api/rest/tmdb/show";
	public final String PERSON = "/api/rest/tmdb/person";
	
}
