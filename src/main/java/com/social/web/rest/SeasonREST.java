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
import org.springframework.web.bind.annotation.RestController;
import com.social.business.interfaces.RatingTvShowBusiness;
import com.social.business.interfaces.TvShowBusiness;
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
	private TvShowBusiness showBusiness;
	
	@Autowired
	private RatingTvShowBusiness ratingBusiness;

	/**
	 * Retorna as informacoes de uma season em especifico
	 * 
	 * @param showId
	 *        O id do show que sera pesquisado
	 *        
	 * @param seasonId
	 *        O id da season que sera pesquisada
	 * 
	 * @return O objeto ResponseEntity contendo a season pesquisada caso seja
	 *         encontrada ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquela season nao foi encontrada
	 */
	@GetMapping(value = "/{showId}/{seasonId}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId,
			@PathVariable("seasonId") String seasonId) {
		return ResponseEntity.ok(showBusiness.getTvShow(showId));
	}
	
	/**
	 * Retorna o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 *        O id do show que sera pesquisado
	 * 
	 * @param season
	 * 		  O id da season que sera pesquisada
	 * 
	 * @return O objeto ResponseEntity contendo o rating pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que o rating para determinada season nao foi encontrado
	 */
	@GetMapping(value = "/{showId}/{seasonId}/user-rating/{ratingId}")
	public ResponseEntity<?> getUserRating(@PathVariable("showId") String showId, 
			@PathVariable("ratingId") Long ratingId, @PathVariable("seasonId") String seasonId) {
		return ResponseEntity.ok(ratingBusiness.getUserRatingForTvShowBySlug(showId, ratingId));
	}
	
	/**
	 * Insere o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
	 * 
	 * @param seasonId
	 * 		  O id da season no qual o rating sera inserido
	 * 
	 * @param rating
	 *        O objeto do tipo rating contendo as informacoes necessarias
	 *        para a insercao do rating
	 *        
	 * @return O objeto ResponseEntity contendo o rating inserido ou um objeto
	 * 		   do tipo ErrorDetailDTO com o codigo 404 informando que o show 
	 *         com o id informado nao foi encontrado
	 */
	@PostMapping(value = "/{showId}/{seasonId}/user-rating")
	public ResponseEntity<?> postUserRating(@PathVariable("showId") String showId, 
			@RequestBody TitleRatingVM rating, @PathVariable("seasonId") String seasonId) {
		return ResponseEntity.ok(ratingBusiness.postRatingForTvShow(showId, rating));
	}
	
	/**
	 * Edita o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
	 * 
	  @param seasonId
	 * 	      O id da season no qual o rating sera inserido
	 * 
	 * @param ratingId
	 * 		  O id do rating que sera editado
	 * 
	 * @param rating
	 *        O objeto do tipo rating contendo as informacoes necessarias
	 *        para a edicao do rating
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido, um objeto do 
	 *         tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o show com o id informado nao
	 *         foi encontrado
	 */
	@PutMapping(value = "/{showId}/{seasonId}/user-rating/{ratingId}")
	public ResponseEntity<?> putUserRating(@PathVariable("showId") String showId, 
			@PathVariable("ratingId") Long ratingId, @RequestBody RatingVM rating,
			@PathVariable("seasonId") String seasonId) {
		return ResponseEntity.ok(ratingBusiness.putRatingForTvShow(ratingId, rating, showId));
	}
	
	/**
	 * Deleta o rating dado pelo usuario logado a season em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
	 * 
	 * @param seasonId
	 * 		  O id da season no qual o rating sera inserido
	 * 
	 * @param ratingId
	 * 		  O id do rating que sera editado
	 *
	 * @return O objeto ResponseEntity contendo o rating inserido, ou um objeto do tipo 
	 * 		   ErrorDetailDTO com o codigo 404 informando que o show com o id informado nao
	 *         foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/{seasonId}/user-rating/{ratingId}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("showId") String showId, 
			@PathVariable("ratingId") Long ratingId, @PathVariable("seasonId") String seasonId) {
		ratingBusiness.deleteRatingForTvShow(ratingId, showId);
		return ResponseEntity.ok().build();
	}
	
}
