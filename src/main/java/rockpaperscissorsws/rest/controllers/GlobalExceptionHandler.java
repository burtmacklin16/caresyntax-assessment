package rockpaperscissorsws.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Void> handleAllUncaughtExceptions(final Exception uncaughtException) {
		
		log.error("An uncaught exeption occurred while processing a request", uncaughtException);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				             .build();
	}
}