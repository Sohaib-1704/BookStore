package com.cg.onlinebook.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.entity.BookInformation;
import com.cg.book.exceptions.BookException;
import com.cg.book.service.BookService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService book;
	
	@PostMapping("/addbook")
	public ResponseEntity<BookInformation> addBook(@RequestBody BookInformation newbook) throws BookException{
		
		BookInformation obtainedbook;
		
		try {
			 obtainedbook = book.addBook(newbook);
			 System.out.println(obtainedbook.getBookId() + " " + obtainedbook.getTitle());
			 return new ResponseEntity<BookInformation>(obtainedbook,HttpStatus.OK);
		}
		catch(BookException e) {
			return new ResponseEntity<BookInformation>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<BookInformation>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/recentlyPublishedBooks")
	public ResponseEntity<List<BookInformation>> recentlyPublishedBooks(){
		List<BookInformation> books = book.getAllRecentlyPublishedBooks();
		return new ResponseEntity<List<BookInformation>>(books,HttpStatus.OK); 
	}
}

