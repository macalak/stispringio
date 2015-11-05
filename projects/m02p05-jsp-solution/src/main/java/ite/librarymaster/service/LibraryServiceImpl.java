package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.model.Book;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Default implementation of the LibraryService interface.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class LibraryServiceImpl implements LibraryService{
	final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		logger.info("<-");
		return bookRepository.findAll();
	}

    @Override
    public Book getBook(String isbn) throws ItemNotFoundException {
    	logger.info("<-");
        Book book = bookRepository.findByIsbn(isbn);
        if(book == null){
            throw new ItemNotFoundException("Book with isbn="+isbn+" not found.");
        }
        return book;
    }


	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
}
