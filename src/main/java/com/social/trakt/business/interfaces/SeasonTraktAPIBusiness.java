package com.social.trakt.business.interfaces;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Episode;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Season;

public interface SeasonTraktAPIBusiness {
	
	/**
	 * Retorna todas as temporadas da serie
	 * 
	 * @param id
	 * 		  O id da serie
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes
	 * 
	 * @return As temporadas da serie requisitada
	 */
	@PreAuthorize("permitAll")
	public List<Season> getSummarySeason(String id, String extended);
	
	/**
	 * Retorna todos os episodios de uma temporada especifica
	 * 
	 * @param showId
	 * 		  O id da serie
	 * 
	 * @param seasonNumber
	 * 		  O numero da temporada
	 * 
	 * @param translations
	 * 		  O idioma no qual serao traduzidas as informacoes
	 * 
	 * @return Todos os episodios da temporada
	 */
	@PreAuthorize("permitAll")
	List<Episode> getSingleSeasonForAShow(String showId, String seasonNumber, String translations, String extended);
	
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
	@PreAuthorize("permitAll")
	public List<FirstAired> getAllSeasonPremieres(String start_date, String days, String extended, String query,
			String genres);

}