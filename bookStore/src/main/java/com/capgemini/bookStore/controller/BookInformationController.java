package com.capgemini.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookStore.entity.BookInformation;
import com.capgemini.bookStore.exception.BookInformationException;
import com.capgemini.bookStore.service.BookInformationService;

@CrossOrigin
@RestController
public class BookInformationController {
	
	@Autowired
	private BookInformationService bookInformationService;
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<Object> getBookInformationById(@PathVariable("bookId") int bookId) throws BookInformationException {
		BookInformation book = bookInformationService.findById(bookId);
		if (book != null) {
			return new ResponseEntity<Object>(book, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
}
