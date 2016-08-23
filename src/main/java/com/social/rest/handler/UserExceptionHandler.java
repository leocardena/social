package com.social.rest.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.social.rest.dto.ErrorDetailDTO;
import com.social.rest.exception.EmailAlreadyInUseException;
import com.social.rest.exception.LoginAlreadyInUseException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(LoginAlreadyInUseException.class)
	public ResponseEntity<?> handleLoginAlreadyInUseException(LoginAlreadyInUseException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();

		error.setStatus(400L);
		error.setTitulo("Login em uso");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(EmailAlreadyInUseException.class)
	public ResponseEntity<?> handleEmailAlreadyInUseException(EmailAlreadyInUseException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();

		error.setStatus(400L);
		error.setTitulo("Email em uso");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
