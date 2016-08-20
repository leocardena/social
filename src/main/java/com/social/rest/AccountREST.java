package com.social.rest;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.rest.dto.UserDTO;
import com.social.rest.util.APIEndpoint;

@RestController
@RequestMapping(value = APIEndpoint.ACCOUNT)
public class AccountREST {
	
	@PostMapping
	public ResponseEntity<?> post (@Valid @RequestBody UserDTO userDTO) {
		//System.out.println(userDTO.toString());
		return ResponseEntity.ok().build();
	} 

}
