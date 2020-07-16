package com.capgemini.bookStore.dao;

import com.capgemini.bookStore.entity.BookInformation;

public interface BookInformationDao {

	BookInformation findBookId(int bookId);

}
