package com.capgemini.bookStore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookStore.dao.BookInformationDao;
import com.capgemini.bookStore.entity.BookInformation;
import com.capgemini.bookStore.exception.BookInformationException;
/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a service class that provides the business logic 
 *          Version          1.0
 *          Created Date     16-JULY-2020
 ************************************************************************************/
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
