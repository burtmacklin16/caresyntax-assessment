package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rockpaperscissorsws.rest.controllers.GlobalExceptionHandler;

public class GlobalExceptionHandlerTests {
	
	private GlobalExceptionHandler classUnderTest = new GlobalExceptionHandler();

	@Test
	public void confirmOkHttpStatusWithBodyReturned() {
		
		final ResponseEntity<Void> response = classUnderTest.handleAllUncaughtExceptions(new RuntimeException("An uncaught runtime error occurred"));
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
}