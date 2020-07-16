package com.capgemini.bookStore.service;

import com.capgemini.bookStore.entity.BookInformation;
import com.capgemini.bookStore.exception.BookInformationException;

public interface BookInformationService {

	BookInformation findById(int bookId) throws BookInformationException;

}
