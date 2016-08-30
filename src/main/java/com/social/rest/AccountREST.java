package com.social.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.rest.business.AccountBusiness;
import com.social.rest.dto.UserDTO;
import com.social.rest.util.APIEndpoint;

@RestController
@RequestMapping(value = APIEndpoint.ACCOUNT)
public class AccountREST {

	@Autowired
	private AccountBusiness accountBusiness;

	@PostMapping
	public ResponseEntity<?> post(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountBusiness.createNewUser(userDTO));
	}
	
	@GetMapping(value = "/activate")
	public ResponseEntity<?> activate(@RequestParam(value = "key") String key) {
		accountBusiness.activateRegistration(key);
		return ResponseEntity.ok().build();
	}

}
