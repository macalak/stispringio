package ite.librarymaster;

import ite.librarymaster.model.Book;
import ite.librarymaster.service.LibraryService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.*;

/**
 * Application entry point.
 * 
 * @author ivan.macalak@posam.sk
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        // Register shutdown hook to destroy container gracefully
        ((AbstractApplicationContext)context).registerShutdownHook();
		LibraryService libraryService=context.getBean(LibraryService.class);
		List<Book> books = libraryService.getAllBooks();
		for(Book book:books){
			System.out.println(book);
		}
	}

}
