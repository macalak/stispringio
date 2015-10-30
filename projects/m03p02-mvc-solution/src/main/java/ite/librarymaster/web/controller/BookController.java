package ite.librarymaster.web.controller;

import javax.validation.Valid;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.model.MediumAvailability;
import ite.librarymaster.service.*;
import ite.librarymaster.web.validator.BookValidator;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

/**
 * A Spring MVC @Controller controller handling requests for the
 * list of books page.   
 * 
 * @author ivan.macalak@posam.sk
 */
@Controller
public class BookController {
    final Logger logger = LoggerFactory.getLogger(BookController.class);

	
	private LibraryService libraryService;
	@Autowired
	private LibraryAdminService adminService;
	@Autowired
	private BookValidator bookValidator;
	
	@ModelAttribute("genres")
	public BookGenre[] frequencies() {
		return BookGenre.values();
	}
	
	/* Binding bookValidator -> works with @Valid annotation
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		binder.setValidator(bookValidator);
	}*/

	@Autowired
	public BookController(LibraryService libraryService) {
		super();
		logger.info("Initializing ...");
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
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView book() {
	   Book book = new Book();
	   book.setAvailability(MediumAvailability.Available);
	   return new ModelAndView("addBook", "book", book);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	//TODO: Handle exception
    public String addBook(@Valid @ModelAttribute Book book, BindingResult result, ModelMap model) {
		// Spring validation
		bookValidator.validate(book, result);
		if(result.hasErrors()) {
			// if there are validation errors return the same addBook view again
			return "addBook";
		}
		if(book != null){	
		   adminService.addBook(book);
		   logger.info("Book saved");
		   model.addAttribute("result", "Book added successfully");
		}else{
		   model.addAttribute("result", "Book not added!");
		}
		return "addBook";
   }

	@RequestMapping(value = "/book/del/{id}")
	public ModelAndView deleteBook( @PathVariable("id") long id) {
		adminService.deleteBook(id);
		logger.info("Book with id {} deleted",id);
		ModelAndView modelAndView = new ModelAndView("books");
		modelAndView.addObject("books", libraryService.getAllBooks());
		modelAndView.addObject("result", "Book deleted successfully");
		return modelAndView;
	}
}
