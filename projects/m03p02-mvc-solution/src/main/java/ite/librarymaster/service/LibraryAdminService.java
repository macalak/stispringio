package ite.librarymaster.service;

import ite.librarymaster.model.Book;

import java.util.List;

/**
 * Library Administration service interface definition.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface LibraryAdminService {
	
	void addBook(Book book);
	void addBooks(List<Book> books);

}
