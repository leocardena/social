package com.social.trakt.util;

/**
 * Interface responsável por guardar as urls utilizadas para requisitar os
 * serviços da API do Trakt.tv
 * 
 * @author Leonardo Cardena
 *
 */
public interface APITraktEndpoint {

	public final String MOVIE = "/api/rest/trakt/movies";
	public final String SHOW = "/api/rest/trakt/shows";
	public final String SEARCH = "/api/rest/trakt/search";
	public final String PERSON = "/api/rest/trakt/persons";
	
}
