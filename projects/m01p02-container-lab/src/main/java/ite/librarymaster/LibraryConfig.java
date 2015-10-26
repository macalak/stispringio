package ite.librarymaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.dao.UserRepository;
import ite.librarymaster.service.LibraryService;
import ite.librarymaster.service.LibraryServiceImpl;

/**
 * Spring Java based application configuration.
 * 
 * @author ivan.macalak@posam.sk
 *
 */

// TODO 2: Annotate class to instruct Spring treat it as Container configuration class
public class LibraryConfig {
	final Logger logger = LoggerFactory.getLogger(LibraryConfig.class);
	
	// TODO 2: Annotate method to instruct Spring treat it as Bean factory method
	public LibraryService libraryService() {
		logger.info("libraryService() <-");
		LibraryServiceImpl service = new LibraryServiceImpl(userRepository());
		service.setBookRepository(bookRepository());
		return service;
	}

	// TODO 2: Annotate method to instruct Spring treat it as Bean factory method
	public BookRepository bookRepository() {
		logger.info("bookRepository() <-");
		// TODO 1: Implement BookRepository instantiation
		return null;
	}
	
	// TODO 2: Annotate method to instruct Spring treat it as Bean factory method
	public UserRepository userRepository() {
		logger.info("userRepository() <-");
 		// TODO 1: Implement UserRepository instantiation
		return null;
	}

}
