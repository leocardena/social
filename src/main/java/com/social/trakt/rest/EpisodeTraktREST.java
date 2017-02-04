package com.social.trakt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.trakt.business.interfaces.EpisodeTraktAPIBusiness;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.SHOW)
public class EpisodeTraktREST {

	@Autowired
	private EpisodeTraktAPIBusiness business;
	
	/**
	 * Retorna os detalhes de um unico episodio
	 * 
	 * @param showId
	 *        O id da serie
	 *        
	 * @param seasonNumber
	 *        O numero da temporada
	 * 
	 * @param episodeNumber
	 * 		  O numero do episodio
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes
	 * 
	 * @return O objeto do tipo ResponseEntity contendo as informacoes do
	 * episodio pesquisado
	 * 
	 */
	@GetMapping("/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") String seasonNumber, @PathVariable("episodeNumber") String episodeNumber,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(business.getSummaryEpisode(showId, seasonNumber, episodeNumber, extended));
	}
	
	/**
	 * Retorna os detalhes de um unico episodio
	 * 
	 * @param showId
	 *        O id da serie
	 *        
	 * @param seasonNumber
	 *        O numero da temporada
	 * 
	 * @param episodeNumber
	 * 		  O numero do episodio
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes
	 *
	 * @param language
	 * 		  O idioma no qual sera buscado a traducao
	 * 
	 * @return O objeto do tipo ResponseEntity contendo as informacoes do
	 * episodio pesquisado
	 * 
	 */
	@GetMapping("/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/translations/{language}")
	public ResponseEntity<?> getTranslationsForAEpisode(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") String seasonNumber, @PathVariable("episodeNumber") String episodeNumber,
			@PathVariable("language") String language) {
		return ResponseEntity
				.ok(business.getTranslationsForAEpisode(showId, seasonNumber, episodeNumber, language));
	}

}
