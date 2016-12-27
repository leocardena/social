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
import com.social.business.MovieBusiness;
import com.social.web.rest.dto.CommentDTO;
import com.social.web.rest.util.APIEndpoint;

/**
 * Camada REST responsável por expor os serviços do recurso Movie
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.MOVIE)
public class MovieREST {
	
	@Autowired
	private MovieBusiness movieBusiness;

	/**
	 * Retorna as informacoes de um filme em especifico
	 * 
	 * @param movieId
	 *        O id do filme que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o filme pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele filme nao foi encontrado
	 */
	@GetMapping(value = "/{movieId}")
	public ResponseEntity<?> get(@PathVariable("movieId") String movieId) {
		return ResponseEntity.ok().build();
	}

	/**
	 * Retorna os comentarios de um filme em especifico
	 * 
	 * @param movieId
	 *        O id do filme que serao pesquisados os comentarios
	 * 
	 * @param page
	 *        A pagina que sera pesquisada contendo os filmes
	 * 
	 * @param limit
	 *        O limite de itens por pagina
	 * 
	 * @return O objeto ResponseEntity contendo os comentarios do filme
	 *         pesquisado ou um objeto do tipo ErrorDetailDTO contendo o codigo
	 *         404 informando que aquele filme nao foi encontrado
	 */
	@GetMapping(value = "/{movieId}/comments")
	public ResponseEntity<?> getMovieComments(@PathVariable("movieId") String movieId,
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "limit", defaultValue = "5") String limit) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna um comentario (incluindo as respostas daquele comentario)
	 * de um filme em especifico
	 * 
	 * @param movieId
	 *        O id do filme que sera pesquisado o comentario
	 *        
	 * @param commentId
	 *        O id do comentario daquele filme
	 *        
	 * @return O objeto ResponseEntity contendo o comentario especifico do filme
	 *         pesquisado ou um objeto do tipo ErrorDetailDTO contendo o codigo
	 *         404 informando que aquele filme nao foi encontrado
	 */
	@GetMapping(value = "/{movieId}/comments/{commentId}")
	public ResponseEntity<?> getMovieComment(@PathVariable("movieId") String movieId, 
			@PathVariable("commentId") String commentId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Insere um comentario para determinado filme
	 * 
	 * @param movieId
	 *         O id do filme que sera inserido o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera inserido
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado filme,
	 *         que acabou de ser inserido ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele filme nao foi encontrado
	 */
	@PostMapping(value = "/{movieId}/comments")
	public ResponseEntity<?> postMovieComment(@PathVariable("movieId") String movieId, 
			@RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Edita um comentario para determinado filme
	 * 
	 * @param movieId
	 *         O id do filme que sera editado o comentario
	 *         
	 * @param comment
	 *        O objeto do tipo comentario contendo as informacoes do comentario
	 *        que sera editado
	 *        
	 * @param commentId
	 *        O id do comentario daquele filme      
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado filme,
	 *         que acabou de ser editado ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele filme nao foi encontrado
	 */
	@PutMapping(value = "/{movieId}/comments/{commentId}")
	public ResponseEntity<?> putMovieComment(@PathVariable("movieId") String movieId, 
			@PathVariable("commentId") String commentId, @RequestBody CommentDTO comment) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Deleta um comentario para determinado filme
	 * 
	 * @param movieId
	 *        O id do filme que sera deletado o comentario
	 *        
	 * @param commentId
	 *        O id do comentario daquele filme      
	 * 
	 * @return O objeto ResponseEntity contendo o comentario, de determinado filme,
	 *         que acabou de ser excluido ou um objeto do tipo ErrorDetailDTO 
	 *         contendo o codigo 404 informando que aquele filme nao foi encontrado
	 */
	@DeleteMapping(value = "/{movieId}/comments/{commentId}")
	public ResponseEntity<?> deleteMovieComment(@PathVariable("movieId") String movieId, 
			@PathVariable("commentId") String commentId) {
		return ResponseEntity.ok().build();
	}

}
