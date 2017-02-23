package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.business.interfaces.EpisodeBusiness;
import com.social.business.interfaces.RatingEpisodeBusiness;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.EpisodeRatingVM;
import com.social.web.rest.vm.RatingVM;

/**
 * Camada REST responsável por expor os serviços do recurso Episode
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.SHOW)
public class EpisodeREST {

	@Autowired
	private EpisodeBusiness episodeBusiness;

	@Autowired
	private RatingEpisodeBusiness ratingEpisodeBusiness;

	/**
	 * Retorna as informacoes de um epidode em especifico
	 * 
	 * @param showId
	 *            O id do show que sera pesquisado
	 * 
	 * @param seasonNumber
	 *            O numero da season que sera pesquisada
	 * 
	 * @param episodeNumber
	 *            O numero do epidode que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o episodio pesquisada caso seja
	 *         encontrada ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele episodio nao foi encontrado
	 */
	@GetMapping(value = "/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") Integer seasonNumber, @PathVariable("episodeNumber") Integer episodeNumber) {
		return ResponseEntity.ok(episodeBusiness.getEpisode(seasonNumber, showId, episodeNumber));
	}

	/**
	 * Retorna o rating dado pelo usuario logado ao epidode em questão
	 * 
	 * @param showId
	 *            O id do show que sera pesquisado
	 * 
	 * @param seasonNumber
	 *            O numero da season que sera pesquisada
	 * 
	 * @param episodeNumber
	 *            O numero do episodio que sera pesquisado
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 * 
	 * @return O objeto ResponseEntity contendo o rating pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que o rating para determinad episode nao foi
	 *         encontrado
	 */
	@GetMapping(value = "/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/user-ratings")
	public ResponseEntity<?> getUserRating(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") Integer seasonNumber, @RequestParam("idRatingParent") Long idRatingParent,
			@PathVariable("episodeNumber") Integer episodeNumber) {
		return ResponseEntity
				.ok(ratingEpisodeBusiness.getUserRatingForEpisode(showId, seasonNumber, episodeNumber, idRatingParent));
	}

	/**
	 * Insere o rating dado pelo usuario logado ao episode em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserida
	 * 
	 * @param episodeNumber
	 *            O numero do episodio que sera pesquisado
	 * 
	 * @param rating
	 *            O objeto do tipo rating contendo as informacoes necessarias
	 *            para a insercao do rating
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o episode
	 *         o nao foi encontrado
	 */
	@PostMapping(value = "/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/user-ratings")
	public ResponseEntity<?> postUserRating(@PathVariable("showId") String showId, @RequestBody EpisodeRatingVM rating,
			@PathVariable("seasonNumber") Integer seasonNumber, @PathVariable("episodeNumber") Integer episodeNumber) {
		return ResponseEntity
				.ok(ratingEpisodeBusiness.postUserRatingForEpisode(showId, seasonNumber, episodeNumber, rating));
	}

	/**
	 * Edita o rating dado pelo usuario logado ao episode em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserido
	 * 
	 * @param episodeNumber
	 *            O numero do episodio que sera pesquisado
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 * 
	 * @param rating
	 *            O objeto do tipo rating contendo as informacoes necessarias
	 *            para a edicao do rating
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o episode
	 *         com o id informado nao foi encontrado
	 */
	@PutMapping(value = "/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/user-ratings/{userRatingId}")
	public ResponseEntity<?> putUserRating(@PathVariable("showId") String showId,
			@PathVariable("userRatingId") Long userRatingId, @RequestBody RatingVM rating,
			@PathVariable("seasonNumber") Integer seasonNumber, @PathVariable("episodeNumber") Integer episodeNumber) {
		return ResponseEntity.ok(ratingEpisodeBusiness.putUserRatingForEpisode(showId, seasonNumber, userRatingId,
				episodeNumber, rating));
	}

	/**
	 * Deleta o rating dado pelo usuario logado ao episode em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserido
	 * 
	 * @param episodeNumber
	 *            O numero do episodio que sera pesquisado
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 *
	 * @return O objeto ResponseEntity contendo o rating inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o episode
	 *         com o id informado nao foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/seasons/{seasonNumber}/episodes/{episodeNumber}/user-ratings/{userRatingId}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("showId") String showId,
			@PathVariable("userRatingId") Long userRatingId, @PathVariable("seasonNumber") Integer seasonNumber,
			@PathVariable("episodeNumber") Integer episodeNumber) {
		ratingEpisodeBusiness.deleteUserRatingForEpisode(showId, seasonNumber, episodeNumber, userRatingId);
		return ResponseEntity.ok().build();
	}

}
