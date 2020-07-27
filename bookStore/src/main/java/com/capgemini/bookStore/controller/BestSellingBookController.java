package com.cg.onlinebook.contoller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.entity.BookInformation;
import com.cg.book.service.BestSellingBookService;


@RestController
public class BestSellingBookController {

	@Autowired
	private BestSellingBookService service;

	@CrossOrigin
	@GetMapping("/getBestSellingBooks/")
	public List<BookInformation> getBestSellingBooks (HttpServletRequest request) {
		List<BookInformation> list = service.getBestSellingBooks();
		return list;
	}
}