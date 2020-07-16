package com.capgemini.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookStore.dao.BookInformationDao;
import com.capgemini.bookStore.entity.BookInformation;
import com.capgemini.bookStore.exception.BookInformationException;

@Transactional
@Service("BookInformationService")	
public class BookInformationServiceImplementation implements BookInformationService {
	@Autowired
	private BookInformationDao bookInformationDao;

	@Override
	public BookInformation findById(int bookId) throws BookInformationException {
		if (bookInformationDao.findBookId(bookId) == null) {
			throw new BookInformationException("Book does not exist");
		}
		return bookInformationDao.findBookId(bookId);
	}
}
