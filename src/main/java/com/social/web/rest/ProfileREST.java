package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.business.interfaces.ProfileBusiness;
import com.social.web.rest.util.APIEndpoint;

/**
 * 
 * Camada REST reponsável por expor os serviços do recurso Profile
 * 
 * @author Pedro
 * 
 */
@RestController
@RequestMapping(APIEndpoint.PROFILE)
public class ProfileREST {

	@Autowired
	private ProfileBusiness profileBusiness;
	
	/**
	 * Retorna as informacoes de um profile em especifico
	 * 
	 * @param usernmae
	 *        O username do filme que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o perfil pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele perfil nao foi encontrado
	 */
	@GetMapping(value="/{username}")
	public ResponseEntity<?> get(@PathVariable("username") String username){
		return ResponseEntity.status(HttpStatus.OK).body(profileBusiness.getProfile(username));
	}
	
	/**
	 * Retorna as informacoes de um profile em especifico
	 * 
	 * @param usernmae
	 *        O username do filme que sera pesquisado
	 * 
	 * @return O objeto ResponseEntity contendo o perfil pesquisado caso seja
	 *         encontrado ou um objeto do tipo ErrorDetailDTO com o codigo 404
	 *         informando que aquele perfil nao foi encontrado
	 */
	@GetMapping
	public ResponseEntity<?> getProfile(@RequestParam("username") String username, Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(profileBusiness.getLikeProfile(username, pageable));
	}
	
}
