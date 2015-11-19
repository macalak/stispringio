package ite.librarymaster.service;

import ite.librarymaster.model.Book;

import java.util.List;

public interface LibraryAdminService {
	
	void addBook(Book book);
	void addBooks(List<Book> books);

}
