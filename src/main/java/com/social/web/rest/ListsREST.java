package com.social.web.rest;

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
import com.social.web.rest.dto.ListsDTO;
import com.social.web.rest.util.APIEndpoint;

/**
 * Camada REST responsável por expor os serviços do recurso Lists
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.LISTS)
public class ListsREST {
	
	/**
	 * Retorna todas as listas do usuario logado
	 * 
	 * @param page
	 *        A pagina requisitada
	 *        
	 * @param limit
	 * 		  A quantidade de itens por pagina
	 * 	
	 * @return As listas do usuario logado
	 */
	@GetMapping
	public ResponseEntity<?> get(@RequestParam(value = "page") String page, 
			@RequestParam(value = "limit") String limit) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Insere uma lista para o usuario logado
	 * 
	 * @param listsDTO
	 *        A lista que sera inserida
	 * 
	 * @return A lista que acabou de ser inserida
	 */
	@PostMapping
	public ResponseEntity<?> post(@RequestBody ListsDTO listsDTO) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna uma lista especifica do usuario logado
	 * 
	 * @param listId
	 *        O id da lista que sera pesquisada
	 *        
	 * @return A lista pesquisada
	 */
	@GetMapping(value = "/{listId}")
	public ResponseEntity<?> get(@PathVariable("listId") String listId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna a listas de determinado filme do usuario logado
	 * 
	 * @param slug
	 * 		  o slug do filme requisitado
	 * 
	 * @param listType
	 * 		  o tipo da lista que sera pesquisada
	 * 
	 * @return A lista que foi pesquisada
	 */
	@GetMapping(value = "/movie/{slug}")
	public ResponseEntity<?> getMovieLists(@PathVariable("slug") String slug,
			@RequestParam("listType") String listType) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna a listas de determinada serie do usuario logado
	 * 
	 * @param slug
	 * 		  o slug da serie requisitada
	 * 
	 * @param listType
	 * 		  o tipo da lista que sera pesquisada
	 * 
	 * @return A lista que foi pesquisada
	 */
	@GetMapping(value = "/show/{slug}")
	public ResponseEntity<?> getShowLists(@PathVariable("slug") String slug,
			@RequestParam("listType") String listType) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Edita a lista do usuario logado
	 * 
	 * @param listId
	 * 	      O id da lista que sera editada
	 * 
	 * @param listsDTO
	 * 		  Objeto contendo as alteracoes da lista
	 * 
	 * @return A lista que foi editada
	 */
	@PutMapping(value = "/{listId}")
	public ResponseEntity<?> put(@PathVariable("listId") String listId, @RequestBody ListsDTO listsDTO) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Deleta a lista do usuario logado
	 * 
	 * @param listId
	 *        O id da lista que sera deletada
	 *        
	 * @return A lista que foi deletada
	 */
	@DeleteMapping(value = "/{listId}")
	public ResponseEntity<?> delete(@PathVariable("listId") String listId) {
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Retorna as listas do usuario requisitado
	 * 
	 * @param username
	 *        O nome do usuario que possui as listas que serao pesquisadas
	 *        
	 * @param page
	 * 		  A pagina requisitada
	 * 
	 * @param limit
	 *        O limite de itens por pagina
	 *        
	 * @param listAccess
	 *        O tipo de acesso por pagina (as listas privadas serao excluidas quando
	 *        o usuario requisitado nao e o mesmo do logado)
	 *
	 * @return As listas do usuario requisitado
	 */
	@GetMapping(value = "/user/{username}")
	public ResponseEntity<?> getUserLists(@PathVariable("username") String username,
			@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit,
			@RequestParam(value = "listAccess") String listAccess) {
		return ResponseEntity.ok().build();
	}

}
