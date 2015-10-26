package ite.librarymaster.web;

import ite.librarymaster.service.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

/**
 * A Spring MVC @Controller controller handling requests for the
 * list of books page.   
 */
@Controller
public class BookController {
    final Logger logger = LoggerFactory.getLogger(BookController.class);

	
	private LibraryService libraryService;
	
	@Autowired
	public BookController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}
	
	@RequestMapping("/books")
	public ModelAndView allBook() {
	    logger.info("allBook() <-");
	    ModelAndView modelAndView = new ModelAndView("books");
	    modelAndView.addObject("books", libraryService.getAllBooks());
	    return modelAndView;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public ModelAndView bookDetail(@PathVariable Long id) throws ItemNotFoundException{
	    logger.info("bookDetail() <-");
	    ModelAndView modelAndView = new ModelAndView("bookDetail");
	    modelAndView.addObject("book",libraryService.getBook(id));
	    return modelAndView;
	}
	
}
