package ite.librarymaster.dao;

import ite.librarymaster.model.Book;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository("jpaBookRepository")
public class JpaBookRepository implements BookRepository {
	
	// TODO 1: Instruct container to inject Peristence Context
	EntityManager entityManager; 

	@Override
	public List<Book> findAll() {
		List<Book> result=entityManager.createNamedQuery("book.findAll",Book.class).
		        getResultList();
		return result;
	}

	@Override
	public Book findByIsbn(String isbn) {
		return entityManager.createNamedQuery("book.findByIsbn",Book.class).
		        setParameter("isbn", isbn).
		        getSingleResult();
	}

    @Override
    public Book findById(Long id) {
        // TODO 2: Add missing implementation
        return null;
    }

	@Override
	public void saveBook(Book book) {
		entityManager.persist(book);
	}

}
