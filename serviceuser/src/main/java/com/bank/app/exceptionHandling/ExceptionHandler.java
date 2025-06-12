package com.bank.app.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value=UserNotFound.class)
	public ErrorResponse userNotFound(UserNotFound userNotFound)
	{
		return new ErrorResponse("user not found","404");
	}
	
	//global exception
//	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//	    public ResponseEntity<?> handleGeneralException(Exception ex) {
//	        Map<String, String> error = new HashMap<>();
//	        error.put("error", "Internal Server Error");
//	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
}
