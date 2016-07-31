package com.social.retrofit.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.social.model.ErrorDetail;
import com.social.retrofit.exception.RetrofitException;

@ControllerAdvice
public class RetrofitExceptionHandler {

	@ExceptionHandler(RetrofitException.class)
	public ResponseEntity<ErrorDetail> handleRetrofitException(RetrofitException exception,
			HttpServletRequest request) {
		
		ErrorDetail error = new ErrorDetail();
		
		error.setStatus(500L);
		error.setTitulo("Erro na API Retrofit");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		
	}

}
