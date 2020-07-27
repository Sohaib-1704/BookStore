package com.cg.onlinebook.contoller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.book.exceptions.BookInformationException;
import com.cg.book.exceptions.CustomerEmailIdnotFound;
import com.cg.book.exceptions.CustomerException;
import com.cg.book.exceptions.CustomerIdNotFoundException;
import com.cg.book.exceptions.UpdateCustomerErrorMessage;
import com.cg.book.exceptions.UpdatecustomerinformationException;


@RestControllerAdvice
public class CustomerExceptionAdvice {
	
	Logger logger = LoggerFactory.getLogger(CustomerExceptionAdvice.class);
	
	@ExceptionHandler(value = {CustomerException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException1(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}
	
	@ExceptionHandler(value = {CustomerIdNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException2(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}

	@ExceptionHandler(value = {CustomerEmailIdnotFound.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND )
	@ResponseBody
	public Map<String, String> handlerException3(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return map;
	}
	
	@ExceptionHandler(value = BookInformationException.class)
	public ResponseEntity<Object> handleException1(BookInformationException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value= {UpdatecustomerinformationException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public UpdateCustomerErrorMessage handleServiceException(UpdatecustomerinformationException ex)
	{
		return new UpdateCustomerErrorMessage(ex.getMessage());
	}
}
