package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.business.interfaces.ActorBusiness;
import com.social.business.interfaces.RatingActorBusiness;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.ActorRatingVM;
import com.social.web.rest.vm.RatingVM;

/**
 * 
 * Camada REST responsavel por expor os serviços do recurso Actor
 * 
 * @author Pedro
 *
 */
@RestController
@RequestMapping(APIEndpoint.ACTOR)
public class ActorREST {
	
	@Autowired
	private ActorBusiness actorBusiness;
	
	@Autowired
	private RatingActorBusiness ratingActorBusiness;
	
	/**
	 * Retorna as informacoes de um ator especifico
	 * 
	 * @param actorId
	 *        O id do filme que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o ator pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele ator nao foi encontrado.
	 */
	@GetMapping(value = "/{actorId}")
	public ResponseEntity<?> get(@PathVariable("actorId") String actorId){
		return ResponseEntity.status(HttpStatus.OK).body(actorBusiness.getActor(actorId));
	}
	
	/**
	 * Retorna o rating dado pelo usuario logado ao ator em questão
	 * 
	 * @param actorId
	 * 		  O id do ator que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o rating pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que o rating para determinado ator nao foi encontrado
	 */
	@GetMapping(value = "/{actorId}/user-rating/{ratingId}")
	public ResponseEntity<?> getUserRating(@PathVariable("actorId") String actorId,
			@PathVariable("idRatingParent") Long idRatingParent) {
		return ResponseEntity.ok(ratingActorBusiness.getUserRatingForActor(actorId, idRatingParent));
	}
	
	/**
	 * Insere o rating dado pelo usuario logado ao ator em questão
	 * 
	 * @param actorId
	 * 		  O id do ator no qual o rating sera inserido
	 * 
	 * @param rating
	 *        O objeto do tipo rating contendo as informacoes necessarias
	 *        para a insercao do rating
	 *        
	 * @return O objeto ResponseEntity contendo o rating inserido, um objeto do 
	 *         tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o ator com o id informado nao
	 *         foi encontrado
	 */
	@PostMapping(value = "/{actorId}/user-ratings")
	public ResponseEntity<?> postUserRating(@PathVariable("actorId") String actorId, 
			@RequestBody ActorRatingVM rating) {
		return ResponseEntity.ok(ratingActorBusiness.postRatingForActor(actorId, rating));
	}
	
	/**
	 * Edita o rating dado pelo usuario logado ao ator em questão
	 * 
	 * @param actorId
	 * 		  O id do ator no qual o rating sera inserido
	  
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
	 *         codigo 404 informando que o ator com o id informado nao
	 *         foi encontrado
	 */
	@PutMapping(value = "/{actorId}/user-ratings/{ratingId}")
	public ResponseEntity<?> putUserRating(@PathVariable("actorId") String actorId, 
			@PathVariable("ratingId") Long ratingId, @RequestBody RatingVM rating) {
		return ResponseEntity.ok(ratingActorBusiness.putRatingForActor(ratingId, rating, actorId));
	}
	
	/**
	 * Deleta o rating dado pelo usuario logado ao ator em questão
	 * 
	 * @param actorId
	 * 		  O id do ator no qual o rating sera inserido
	 * 
	 * @param ratingId
	 * 		  O id do rating que sera editado
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido, um objeto do 
	 *         tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o ator com o id informado nao
	 *         foi encontrado
	 */
	@DeleteMapping(value = "/{actorId}/user-rating/{ratingId}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("actorId") String actorId, 
			@PathVariable("ratingId") Long ratingId) {
		ratingActorBusiness.deleteRatingForActor(ratingId, actorId);
		return ResponseEntity.ok().build();
	}
}
