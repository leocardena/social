package com.social.retrofit.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.social.rest.dto.ErrorDetailDTO;
import com.social.retrofit.exception.RetrofitException;

@ControllerAdvice
public class RetrofitExceptionHandler {

	@ExceptionHandler(RetrofitException.class)
	public ResponseEntity<ErrorDetailDTO> handleRetrofitException(RetrofitException exception,
			HttpServletRequest request) {
		
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(500L);
		error.setTitulo("Erro na API Retrofit");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		
	}

}
