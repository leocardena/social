package com.social.web.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.business.interfaces.AccountBusiness;
import com.social.web.rest.dto.UserDTO;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.AccountVM;
import com.social.web.rest.vm.PasswordVM;

import javax.servlet.http.HttpServletRequest;

/**
 * Camada REST responsável por expor os serviços do recurso Account
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(value = APIEndpoint.ACCOUNT)
public class AccountREST {

	@Autowired
	private AccountBusiness accountBusiness;

	/**
	 * @param userDTO
	 *            objeto recebido através do body da request contendo
	 *            informações do usuário a ser cadastrado
	 * @return O usuário que foi criado
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<?> post(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountBusiness.createNewUser(userDTO));
	}

	/**
	 * @param key
	 *            a key para ativação do cadastro
	 * @return status 200 confirmando o sucesso da operação
	 */
	@GetMapping(value = "/activate")
	public ResponseEntity<?> activate(@RequestParam(value = "key") String key) {
		accountBusiness.activateRegistration(key);
		return ResponseEntity.ok().build();
	}

	/**
	 * @return a conta do usuário junto a suas roles
	 */
	@GetMapping
	public ResponseEntity<?> getAccount() {
		return ResponseEntity.status(HttpStatus.OK).body(accountBusiness.getUserWithAuthorities());
	}

	/**
	 * @param request
	 *            a request a ser enviada como resposta
	 * @return o usuário logado no momento
	 */
	@GetMapping(value = "/authenticate")
	public String isAuthenticated(HttpServletRequest request) {
		return request.getRemoteUser();
	}

	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> put(@RequestBody AccountVM accountVM, @PathVariable(value = "userId") Long userId) {
		return ResponseEntity.ok(accountBusiness.putAccount(accountVM, userId));
	}

	@PutMapping(value = "/credentials/{userId}")
	public ResponseEntity<?> putCredentials(@RequestBody PasswordVM passwordVM,
			@PathVariable(value = "userId") Long userId) {
		accountBusiness.putPassoword(passwordVM, userId);
		return ResponseEntity.ok().build();
	}

}
