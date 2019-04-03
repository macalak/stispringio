package ite.librarymaster.ws;


import ite.librarymaster.model.Book;
import ite.librarymaster.service.ItemNotFoundException;
import ite.librarymaster.service.LibraryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * LibraryService REST API implementation.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@RestController
public class LibraryRestService {
	final Logger LOGGER = LoggerFactory.getLogger(LibraryRestService.class);
    
    @Autowired
    LibraryService libraryService;

    //http://localhost:8080/m05p01-rest-solution/library/api/books
    @RequestMapping(produces={"application/json"}, value="/api/books", method=RequestMethod.GET )
    public List<Book> getAllBooks() {
    	LOGGER.info("getAllBooks() <-"); 
    	return libraryService.getAllBooks();
    }

    /**
     * Returns xml or json representation of Book identified by id.
     * 
     * @param id - Book ID
     * @return Book instance
     * @throws ItemNotFoundException
     */

    //http://localhost:8080/m05p01-rest-solution/library/api/book/1
    @RequestMapping(produces={"application/json"}, value="/api/book/{id}", method=RequestMethod.GET )
    public Book bookDetail(@PathVariable("id") Long id) throws ItemNotFoundException{
    	LOGGER.info("bookDetail() <-");
        return libraryService.getBook(id);
    }

    @RequestMapping(produces={"application/json"},
                    consumes = {"application/json"},
                    value="/api/book", method=RequestMethod.POST )
    public Book addBook(@RequestBody Book book) throws ItemNotFoundException{
    	LOGGER.info("addDetail() <-");
        return libraryService.addBook(book);
    }

}
