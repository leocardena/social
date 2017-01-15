package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.social.business.AccountBusiness;
import com.social.web.rest.util.APIEndpoint;

/**
 * Camada REST responsável por expor os serviços do recurso Avatar
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.AVATAR)
public class AvatarREST {

	@Autowired
	private AccountBusiness accountBusiness;
	
	/**
	 * @param codigo código do avatar
	 * @param files o arquivo
	 * @return o caminho onde o avatar foi salvo
	 */
	@PostMapping
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(accountBusiness.saveAvatar(file));
	}
	
	/**
	 * Delete o avatar do usuario
	 * 
	 * @return codigo 200 informando que o avatar foi deletado
	 */
	@DeleteMapping
	public ResponseEntity<?> delete() {
		accountBusiness.deleteAvatar();
		return ResponseEntity.ok().build();
	}

}
