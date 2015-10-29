package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.model.Book;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

/**
 * Default implementation of the LibraryService interface.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Service
@Transactional(readOnly=true)
public class LibraryServiceImpl implements LibraryService{
	final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	@Autowired
	@Qualifier("jpaBookRepository")
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		logger.info("<-");
		return bookRepository.findAll();
	}

    @Override
    public Book getBook(Long id) throws ItemNotFoundException {
    	logger.info("<-");
        Book book = bookRepository.findById(id);
        if(book == null){
            throw new ItemNotFoundException("Book with id="+id+" not found.");
        }
        return book;
    }
}
