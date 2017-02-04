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
import com.social.business.RatingBusiness;
import com.social.business.TvShowBusiness;
import com.social.web.rest.dto.CommentDTO;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.TitleRatingVM;

/**
 * Camada REST responsável por expor os serviços do recurso Show
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.SHOW)
public class ShowREST {
	
	@Autowired
	private TvShowBusiness showBusiness;
	
	@Autowired
	private RatingBusiness ratingBusiness;

	/**
	 * Retorna as informacoes de um show em especifico
	 * 
	 * @param showId
	 *        O id do show que sera pesquisadoshowId
	 * 
	 * @return O objeto ResponseEntity contendo o show pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele show nao foi encontrado
	 */
	@GetMapping(value = "/{showId}")
	public ResponseEntity<?> get(@PathVariable("showId") String showId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 * 		  O id do show que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o rating pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que o rating para determinado show nao foi encontrado
	 */
	@GetMapping(value = "/{showId}/user-rating")
	public ResponseEntity<?> getUserRating(@PathVariable("showId") String showId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Insere o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
	 * 
	 * @param rating
	 *        O objeto do tipo rating contendo as informacoes necessarias
	 *        para a insercao do rating
	 *        
	 * @return O objeto ResponseEntity contendo o rating inserido, um objeto do 
	 *         tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o show com o id informado nao
	 *         foi encontrado
	 */
	@PostMapping(value = "/{showId}/user-rating")
	public ResponseEntity<?> postUserRating(@PathVariable("showId") String showId, 
			@RequestBody TitleRatingVM rating) {
		return ResponseEntity.ok(ratingBusiness.postRatingForTvShow(showId, rating));
	}
	
	/**
	 * Edita o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
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
	@PutMapping(value = "/{showId}/user-rating/{ratingId}")
	public ResponseEntity<?> putUserRating(@PathVariable("showId") String showId, 
			@PathVariable("ratingId") String ratingId, @RequestBody TitleRatingVM rating) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Deleta o rating dado pelo usuario logado ao show em questão
	 * 
	 * @param showId
	 * 		  O id do show no qual o rating sera inserido
	 * 
	 * @param ratingId
	 * 		  O id do rating que sera editado
	 * 
	 * @return O objeto ResponseEntity contendo o rating inserido, um objeto do 
	 *         tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o show com o id informado nao
	 *         foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/user-rating/{ratingId}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("showId") String showId, 
			@PathVariable("ratingId") String ratingId) {
		return ResponseEntity.ok().build();
	}

	/**
	 * Retorna os comentarios de um show em especifico
	 * 
	 * @param showId
	 *        O id do show que sera pesquisados os comentarios
	 * 
	 * @param page
	 *        A pagina que sera pesquisada contendo os shows
	 * 
	 * @param limit
	 *        O limite de itens por pagina
	 * 
	 * @return O objeto ResponseEntity contendo os comentarios do show
	 *         pesquisado ou um objeto do tipo ErrorDetailDTO contendo o codigo
	 *         404 informando que aquele show nao foi encontrado
	 */
	@GetMapping(value = "/{showId}/comments")
	public ResponseEntity<?> getShowComments(@PathVariable("showId") String showId,
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "limit", defaultValue = "5") String limit) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Insere um comentario para determinado show
	 * 
	 * @param showId
	 *         O id do show que sera inserido o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera inserido
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser inserido ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show nao foi encontrado
	 */
	@PostMapping(value = "/{showId}/comments")
	public ResponseEntity<?> postShowComment(@PathVariable("showId") String showId, 
			@RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Deleta um comentario para determinado show
	 * 
	 * @param showId
	 *         O id do show que sera deletado o comentario
	 *         
     * @param commentId
	 *         O id do comentario que sera deletado o comentario
	 *         
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser deletado ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show nao foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/comments/{commentId}")
	public ResponseEntity<?> deleteShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Edita um comentario para determinado show
	 * 
	 * @param showId
	 *         O id do show que sera editado o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera editado
	 * 
	 * @param comment
	 *        O id do comentario que sera editado
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser inserido ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show nao foi encontrado
	 */
	@PutMapping(value = "/{showId}/comments/{commentId}")
	public ResponseEntity<?> putShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId, @RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna os subcomentarios de um comentario de um show em especifico
	 * 
	 * @param movieId
	 *        O id do show que sera pesquisado o comentario
	 *        
	 * @param commentId
	 *        O id do comentario daquele show
	 *        
	 * @param page
	 *        A pagina que sera pesquisada contendo os shows
	 * 
	 * @param limit
	 *        O limite de itens por pagina
	 *        
	 * @return O objeto ResponseEntity contendo o comentario especifico do show
	 *         pesquisado ou um objeto do tipo ErrorDetailDTO contendo o codigo
	 *         404 informando que aquele show/comentario nao foi encontrado
	 */
	@GetMapping(value = "/{showId}/comment/{commentId}/comments")
	public ResponseEntity<?> getShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId, 
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "limit", defaultValue = "5") String limit) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Insere um subcomentario para um comentario de um determinado filme
	 * 
	 * @param showId
	 *         O id do show que sera inserido o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera inserido
	 *        
	 * @param commentId
	 *        O id do comentario daquele show      
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser inserido ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show/comentario nao foi 
	 *         encontrado
	 */
	@PostMapping(value = "/{showId}/comment/{commentId}/comments")
	public ResponseEntity<?> postShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId, @RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Edita um comentario para determinado show
	 * 
	 * @param showId
	 *         O id do show que sera editado o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera editado
	 *        
	 * @param commentId
	 *        O id do comentario daquele show      
	 *        
	 * @param subCommentId
	 *        O id do subcomentario daquele comentario pertencente a um show   
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser editado ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show nao foi encontrado
	 */
	@PutMapping(value = "/{showId}/comment/{commentId}/comments/{subCommentId}")
	public ResponseEntity<?> putShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId, @PathVariable("subCommentId") String subCommentId, 
			@RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Deleta um subcomentario para determinado show
	 * 
	 * @param showId
	 *         O id do show que sera editado o comentario
	 *         
	 * @param commentId
	 *        O id do comentario daquele show      
	 *        
	 * @param subCommentId
	 *        O id do subcomentario daquele comentario pertencente a um show   
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado show,
	 *         que acabou de ser editado ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele show nao foi encontrado
	 */
	@DeleteMapping(value = "/{showId}/comment/{commentId}/comments/{subCommentId}")
	public ResponseEntity<?> deleteShowComment(@PathVariable("showId") String showId, 
			@PathVariable("commentId") String commentId, @PathVariable("subCommentId") String subCommentId) {
		return ResponseEntity.ok().build();
	}
	
}
