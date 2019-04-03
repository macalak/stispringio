package ite.librarymaster.service;

import ite.librarymaster.model.Book;

import java.util.List;

public interface LibraryService {
	
	List<Book> getAllBooks();
	Book getBook(Long id) throws ItemNotFoundException;
	Book addBook(Book book);
}
