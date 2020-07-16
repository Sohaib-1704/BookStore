package com.capgemini.bookStore.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.capgemini.bookStore.entity.BookInformation;

@Repository("BookInformationDao")
public class BookInformationDaoImplementation implements BookInformationDao {
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public BookInformation findBookId(int bookId) {
			return entityManager.find(BookInformation.class, bookId);
		}
}
