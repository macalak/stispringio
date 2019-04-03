package ite.librarymaster.dao;

import ite.librarymaster.model.Book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("jpaBookRepository")
public class JpaBookRepository implements BookRepository {
	
	@PersistenceContext
	EntityManager entityManager; 

	@Override
	public List<Book> findAll() {
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
        return entityManager.find(Book.class, id);
    }

	@Override
	public Book saveBook(Book book) {
		entityManager.persist(book);
		return book;
	}


}
