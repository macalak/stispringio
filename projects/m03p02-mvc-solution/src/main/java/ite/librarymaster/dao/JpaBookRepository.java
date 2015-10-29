package ite.librarymaster.dao;

import ite.librarymaster.model.Book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the BookRepository.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Repository("jpaBookRepository")
public class JpaBookRepository implements BookRepository {
	final Logger logger = LoggerFactory.getLogger(BookRepository.class);
	
	@PersistenceContext
	EntityManager entityManager; 

	@Override
	public List<Book> findAll() {
		logger.info("Searching for all books in the library...");
		List<Book> result=entityManager.createNamedQuery("book.findAll",Book.class).getResultList();
		return result;
	}

	@Override
	public Book findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Book findById(Long id) {
    	logger.info("Searching book by its ID...");
        return entityManager.find(Book.class, id);
    }

	@Override
	public void saveBook(Book book) {
		logger.info("Saving book ...");
		entityManager.persist(book);
	}


}
