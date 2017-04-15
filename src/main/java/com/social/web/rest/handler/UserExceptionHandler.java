package com.social.web.rest.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.social.web.rest.dto.ErrorDetailDTO;
import com.social.web.rest.exception.EmailAlreadyInUseException;
import com.social.web.rest.exception.FriendStatusBadGatewayException;
import com.social.web.rest.exception.KeyNotFoundException;
import com.social.web.rest.exception.LoginAlreadyInUseException;
import com.social.web.rest.exception.LoginNotFoundException;
import com.social.web.rest.exception.PasswordDoenstMatchException;
import com.social.web.rest.exception.ResourceNotFoundException;

/**
 * Classe responsável por manipular as excetions da camada REST
 * 
 * @author Leonardo Cardena
 *
 */
@ControllerAdvice
public class UserExceptionHandler {

	/**
	 * @param exception
	 *            a exception gerada
	 * @param request
	 *            a request que ocasionou a exception
	 * @return response contendo a causa da exception
	 */
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

	/**
	 * @param exception
	 *            a exception gerada
	 * @param request
	 *            a request que ocasionou a exception
	 * @return response contendo a causa da exception
	 */
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

	/**
	 * @param exception
	 *            a exception gerada
	 * @param request
	 *            a request que ocasionou a exception
	 * @return response contendo a causa da exception
	 */
	@ExceptionHandler(KeyNotFoundException.class)
	public ResponseEntity<?> handleKeyNotFoundException(KeyNotFoundException exception, HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();

		error.setStatus(404L);
		error.setTitulo("Chave inválida");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	/**
	 * @param exception
	 *            a exception gerada
	 * @param request
	 *            a request que ocasionou a exception
	 * @return response contendo a causa da exception
	 */
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<?> handleLoginNotFoundException(LoginNotFoundException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();

		error.setStatus(404L);
		error.setTitulo("Login Inválido");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	/**
	 * @param exception
	 *            a exception gerada
	 * @param request
	 *            a request que ocasionou a exception
	 * @return response contendo a causa da exception
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundExceptionException(ResourceNotFoundException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(404L);
		error.setTitulo("Recurso nao encontrado");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(FriendStatusBadGatewayException.class)
	public ResponseEntity<?> handleFriendStatusBadGatewayException(FriendStatusBadGatewayException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(400L);
		error.setTitulo("FriendStatus incorreto");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(PasswordDoenstMatchException.class)
	public ResponseEntity<?> handlePasswordDoenstMatchException(PasswordDoenstMatchException exception,
			HttpServletRequest request) {
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(400L);
		error.setTitulo("Password nao confere com o atual.");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
