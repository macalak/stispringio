package ite.librarymaster.service;

import ite.librarymaster.dao.*;
import ite.librarymaster.model.*;

import java.util.*;

import org.slf4j.*;

public class LibraryServiceImpl implements LibraryService {
	final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	private BookRepository bookRepository;
	private UserRepository userRepository;

	public LibraryServiceImpl(UserRepository userRepository, BookRepository bookRepository) {
		super();
		logger.info("LibraryServiceImpl() <-");
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
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
