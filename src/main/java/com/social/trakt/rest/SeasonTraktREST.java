package com.social.trakt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.trakt.business.interfaces.SeasonTraktAPIBusiness;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.SHOW)
public class SeasonTraktREST {

	@Autowired
	private SeasonTraktAPIBusiness seasonBusiness;
	
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
	 * @return Um objeto do tipo ResponseEntity contendo a lista de espisodios
	 * 	       da temporada pesquisada
	 */
	@GetMapping(value = "/{showId}/seasons/{seasonNumber}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId, @PathVariable("seasonNumber") String seasonNumber,
			@RequestParam(value = "translations", required = false) String translations,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(seasonBusiness.getSingleSeasonForAShow(showId, seasonNumber, translations, extended));
	}

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
	 * @return Um objeto do tipo ResponseEntity contendo os lancamentos de series 
	 *         durante o intervalo especificado
	 */
	@GetMapping(value = "/calendars/all/shows/premieres/{start_date}/{days}")
	public ResponseEntity<?> getShowTranslation(@PathVariable("start_date") String startDate,
			@PathVariable("days") String days, @RequestParam(value = "extended", required = false) String extended,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "genres", required = false) String genres) {
		return ResponseEntity.ok(seasonBusiness.getAllSeasonPremieres(startDate, days, extended, query, genres));
	}
	
}
