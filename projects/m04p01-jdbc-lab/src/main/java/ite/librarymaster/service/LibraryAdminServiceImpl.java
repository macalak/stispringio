package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryAdminServiceImpl implements LibraryAdminService{
	
	@Autowired
	@Qualifier("jdbcBookRepository")
	private BookRepository bookRepository;

	@Override
	@Transactional
	public void addBook(Book book) {
		bookRepository.saveBook(book);
	}

	@Override
	@Transactional
	public void addBooks(List<Book> books) {
		for(Book book : books){
			bookRepository.saveBook(book);
		}
	}
}
