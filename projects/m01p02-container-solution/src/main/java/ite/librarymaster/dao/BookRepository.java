package ite.librarymaster.dao;

import ite.librarymaster.model.Book;

import java.util.List;

/**
 * Book Repository interface defines operations to
 * access and manipulate Books.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface BookRepository {
	
	/**
	 * Finds all Books in the Library.
	 * @return - All books from Library
	 */
	List<Book> findAll();

	/**
	 * Find book according isbn number.
	 * @param isbn - book isbn number
	 * @return Book with given isbn, or null if no such book exists in the Library
	 */
	Book findByIsbn(String isbn);
	
	void close();

}
