package ite.librarymaster.ws;


import ite.librarymaster.model.Book;
import ite.librarymaster.service.ItemNotFoundException;
import ite.librarymaster.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * LibraryService REST API implementation.
 * 
 * @author ivan.macalak@posam.sk
 *
 */

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryRestService {
	final Logger LOGGER = LoggerFactory.getLogger(LibraryRestService.class);
    
    @Autowired
    LibraryService libraryService;

    //http://localhost:8080/m05p01-rest-solution/library/api/books
    @GET
    @Path("/books")
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
    @GET
    @Path("/book/{id}")
    public Book bookDetail(@PathParam("id") Long id) throws ItemNotFoundException{
    	LOGGER.info("bookDetail() <-"); 
        return libraryService.getBook(id);
    }
   
}
