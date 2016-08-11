package com.social.rest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.social.model.ErrorDetail;

@RestController
public class ErrorREST implements ErrorController {

	@RequestMapping(value = "/error")
	public ResponseEntity<?> error() {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(404L);
		error.setTitulo("Página não encontrada");
		error.setMensagem("A página requisitada não foi encontrada");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
