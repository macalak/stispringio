package ite.librarymaster.service;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.User;

import java.util.List;

/**
 * This interface defines the Library functions.
 * It acts as main interface to the Library Master application.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface LibraryService {
	
	/**
	 * Retrieves all Books in the Library.
	 * @return All books in the Library
	 */
	List<Book> getAllBooks();
	
	/**
	 * Retrieves all registered Library users.
	 * @return All registered Library users
	 */
	List<User> getAllUsers();

}
