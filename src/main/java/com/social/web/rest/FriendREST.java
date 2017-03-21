package com.social.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.FriendVM;

/**
 * 
 * Camada REST reponsável por expor os serviços do recurso Friend
 * 
 * @author Pedro
 * 
 */
@RestController
@RequestMapping(APIEndpoint.FRIEND)
public class FriendREST {

	/**
	 * Retorna as informacoes de um profile em especifico do
	 * 
	 * @param idProfile
	 *        O idProfile do Profile que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o perfil pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele perfil nao foi encontrado
	 */
	@GetMapping(value = "/{idProfile}")
	public ResponseEntity<?> get(@PathVariable("idProfile") Long idProfile){
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Insere um amigo ao perfil logado no sistema
	 * 
	 * @return O objeto ResponseEntity contendo o perfil adicionado, um objeto do
	 * 		   tipo ErrorDetailDTO com o codigo 500 informando que ocorreu um 
	 *         erro na insercao ou um objeto do tipo ErrorDetailDTO com o 
	 *         codigo 404 informando que o perfil com o id informado nao
	 *         foi encontrado
	 */
	@PostMapping
	public ResponseEntity<?> postFriend(@RequestBody FriendVM friendVM){
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Edita o friend para aprovar a solicitacao
	 * 
	 * @param idFriend
	 * 		  O id do Friend no qual será editado
	 * 
	 * @return O objeto ResponseEntity contendo o friend inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o friend com
	 *         o id informado nao foi encontrado
	 */
	@PutMapping(value = "/{idFriend}")
	public ResponseEntity<?> putFriend(@PathVariable("idFriend") Long idFriend) {
		return ResponseEntity.ok(null);
	}
	
	/**
	 * Deleta o rating dado pelo usuario logado a season em questão
	 * 
	 * @param idFriend
	 *            O id do friend no qual será deletado
	 *
	 * @return O objeto ResponseEntity contendo o friend inserido, ou um objeto
	 *         do tipo ErrorDetailDTO com o codigo 404 informando que o friend com
	 *         o id informado nao foi encontrado
	 */
	@DeleteMapping(value = "/{idFriend}")
	public ResponseEntity<?> deleteUserRating(@PathVariable("idFriend") String idFriend) {
		return ResponseEntity.ok().build();
	}
	
	
	
}
