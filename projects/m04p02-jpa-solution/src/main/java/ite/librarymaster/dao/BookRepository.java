package ite.librarymaster.dao;

import ite.librarymaster.model.Book;

import java.util.List;

/**
 * Book Repository interface defines operations to
 * access and manipulate Books.
 * 
 * @author macalak@itexperts.sk
 *
 */
public interface BookRepository {
	
	List<Book> findAll();
	Book findById(Long id);
	Book findByIsbn(String isbn);
	void saveBook(Book book);

}
