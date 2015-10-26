package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.dao.UserRepository;
import ite.librarymaster.model.Book;
import ite.librarymaster.model.User;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryServiceImpl implements LibraryService{
	final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	private BookRepository bookRepository;
	private UserRepository userRepository;

	public LibraryServiceImpl(UserRepository userRepository) {
		super();
		logger.info("LibraryServiceImpl() <-");
		this.userRepository = userRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void setBookRepository(BookRepository bookRepository) {
		logger.info("setBookRepository() <-");
		this.bookRepository = bookRepository;
	}

}
