package com.capgemini.bookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookInformationExceptionController {
		@ExceptionHandler(value = BookInformationException.class)
		public ResponseEntity<Object> handleException1(BookInformationException exception) {
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
		}
}
