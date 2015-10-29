package ite.librarymaster.service;

import ite.librarymaster.model.Book;

import java.util.List;

/**
 * Library service interface definition.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface LibraryService {
	
	List<Book> getAllBooks();
	Book getBook(Long id) throws ItemNotFoundException;

}
