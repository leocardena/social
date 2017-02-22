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
import com.social.business.interfaces.RatingSeasonBusiness;
import com.social.business.interfaces.SeasonBusiness;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

/**
 * Camada REST responsável por expor os serviços do recurso Season
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.SHOW)
public class SeasonREST {

	@Autowired
	private SeasonBusiness seasonBusiness;

	@Autowired
	private RatingSeasonBusiness ratingSeasonBusiness;

	/**
	 * Retorna as informacoes de uma season em especifico
	 * 
	 * @param showId
	 *            O id do show que sera pesquisado
	 * 
	 * @param seasonNumber
	 *            O numero da season que sera pesquisada
	 * 
	 * @return O objeto ResponseEntity contendo a season pesquisada caso seja
	 *         encontrada ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquela season nao foi encontrada
	 */
	@GetMapping(value = "/{showId}/seasons/{seasonNumber}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") Integer seasonNumber) {
		return ResponseEntity.ok(seasonBusiness.getSeason(seasonNumber, showId));
	}

	/**
	 * Retorna o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 *            O id do show que sera pesquisado
	 * 
	 * @param seasonNumber
	 *            O numero da season que sera pesquisada
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 * 
	 * @return O objeto ResponseEntity contendo o rating pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que o rating para determinada season nao foi
	 *         encontrado
	 */
	@GetMapping(value = "/{showId}/seasons/{seasonNumber}/user-ratings")
	public ResponseEntity<?> getUserRating(@PathVariable("showId") String showId,
			@PathVariable("seasonNumber") Integer seasonNumber, @RequestParam("idRatingParent") Long idRatingParent) {
		return ResponseEntity
				.ok(ratingSeasonBusiness.getUserRatingForSeasonBySlug(showId, seasonNumber, idRatingParent));
	}

	/**
	 * Insere o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserida
	 * 
	 * @param rating
	 *            O objeto do tipo rating contendo as informacoes necessarias
	 *            para a insercao do rating
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o show com
	 *         o id informado nao foi encontrado
	 */
	@PostMapping(value = "/{showId}/seasons/{seasonNumber}/user-ratings")
	public ResponseEntity<?> postUserRating(@PathVariable("showId") String showId, @RequestBody TitleRatingVM rating,
			@PathVariable("seasonNumber") Integer seasonNumber) {
		return ResponseEntity.ok(ratingSeasonBusiness.postUserRatingForSeason(showId, seasonNumber, rating));
	}

	/**
	 * Edita o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserido
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 * 
	 * @param rating
	 *            O objeto do tipo rating contendo as informacoes necessarias
	 *            para a edicao do rating
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o show com
	 *         o id informado nao foi encontrado
	 */
	@PutMapping(value = "/{showId}/seasons/{seasonNumber}/user-ratings/{userRatingId}")
	public ResponseEntity<?> putUserRating(@PathVariable("showId") String showId,
			@PathVariable("userRatingId") Long userRatingId, @RequestBody RatingVM rating,
			@PathVariable("seasonNumber") Integer seasonNumber) {
		return ResponseEntity
				.ok(ratingSeasonBusiness.putUserRatingForSeason(showId, seasonNumber, userRatingId, rating));
	}

	/**
	 * Deleta o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 *            O id do show no qual o rating sera inserido
	 * 
	 * @param seasonNumber
	 *            O numero da season no qual o rating sera inserido
	 * 
	 * @param userRatingId
	 *            O id do rating do usuario
	 *
	 * @return O objeto ResponseEntity contendo o rating inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o show com
	 *         o id informado nao foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/seasons/{seasonNumber}/user-ratings/{userRatingId}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("showId") String showId,
			@PathVariable("userRatingId") Long userRatingId, @PathVariable("seasonNumber") Integer seasonNumber) {
		ratingSeasonBusiness.deleteUserRatingForSeason(showId, seasonNumber, userRatingId);
		return ResponseEntity.ok().build();
	}

}
