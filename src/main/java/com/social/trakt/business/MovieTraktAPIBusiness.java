package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

import com.social.trakt.model.Movie;
import com.social.trakt.model.Released;
import com.social.web.rest.response.ResponseAPI;

public interface MovieTraktAPIBusiness {
	
	/**
	 * Retorna os filmes populares no trakt.tv
	 * 
	 * @param page a pagina requisitada
	 * @param limit o limite de informacoes por pagina
	 * @param extended o detalhamento de informacoes
	 * @param query o texto de pesquisa
	 * @param genres os generos
	 * @return os filmes populares do trakt.tv
	 */
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Movie>> getPopularMovies(String page, String limit, String extended, String query,
			String genres);
	
	/**
	 * Retorna o resumo do filme
	 * @param id o id do filme
	 * @param extended a quantidade de detalhamento das informacoes retornadas
	 * @return o resumo do filme
	 */
	@PreAuthorize("permitAll")
	public Movie getSummaryMovie(String id, String extended);
	
	/**
	 * Retorna a traducao das informacoes de determinado filme
	 * @param id o id do filme a ser traduzido
	 * @param language a lingua na qual a traducao sera feita
	 * @return as informacoes do filme traduzidas
	 */
	@PreAuthorize("permitAll")
	public List<Movie> getMovieTranslation(String id, String language);
	
	/**
	 * Retorna todos os filmes relacionados a um filme em especifico
	 * 
	 * @param id o id do filme
	 * @param page a pagina solicitada
	 * @param limit a quantidade de resultados por pagina
	 * @param extended o detalhamento de informacoes
	 * @return os filmes relacionados
	 */
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Movie>> getRelatedMovies(String id, String page, String limit, String extended);
	
	/**
	 * Retorna todos os filmes a partir de determinada data
	 * 
	 * @param start_date data de inicio
	 * @param days numero de dias
	 * @param extended detalhamento de informacoes
	 * @param query texto de pesquisa
	 * @param genres os generos
	 * @return os lancamentos para aquela pesquisa
	 */
	@PreAuthorize("permitAll")
	public List<Released> getAllMovies(String start_date, int days, String extended, String query, String genres);
	
}