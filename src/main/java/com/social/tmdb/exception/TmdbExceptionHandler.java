package com.social.tmdb.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.social.web.rest.dto.ErrorDetailDTO;

@ControllerAdvice
public class TmdbExceptionHandler {
	
	@ExceptionHandler(TMDBImageSizeNotContains.class)
	public ResponseEntity<ErrorDetailDTO> handleRetrofitException(TMDBImageSizeNotContains exception,
			HttpServletRequest request) {
		
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(500L);
		error.setTitulo("Erro na API Retrofit");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		
	}
	
	@ExceptionHandler(TMDBBackdropImageNotContains.class)
	public ResponseEntity<ErrorDetailDTO> handleTMDBBackdropImageNotContains(TMDBBackdropImageNotContains exception,
			HttpServletRequest request) {
		
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(404L);
		error.setTitulo("Imagem do tipo backdrop não encontrada.");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(TMDBPosterImageNotContains.class)
	public ResponseEntity<ErrorDetailDTO> handleTMDBPosterImageNotContains(TMDBPosterImageNotContains exception,
			HttpServletRequest request) {
		
		ErrorDetailDTO error = new ErrorDetailDTO();
		
		error.setStatus(404L);
		error.setTitulo("Imagem do tipo poster não encontrada.");
		error.setMensagem(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}
