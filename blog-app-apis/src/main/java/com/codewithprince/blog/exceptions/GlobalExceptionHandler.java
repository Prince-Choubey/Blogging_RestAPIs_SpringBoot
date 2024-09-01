package com.codewithprince.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithprince.blog.payloads.ApiRespnse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<ApiRespnse> resourceNotFoundExceptionHandler(ResouceNotFoundException ex) {
		String message = ex.getMessage();
		ApiRespnse apiRespnse = new ApiRespnse(message, false);
		return new ResponseEntity<ApiRespnse>(apiRespnse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
		
		
	}
	

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiRespnse> handleApiException(ApiException ex) {
		String message = ex.getMessage();
		ApiRespnse apiRespnse = new ApiRespnse(message, true);
		return new ResponseEntity<ApiRespnse>(apiRespnse, HttpStatus.BAD_REQUEST);
	}

}
