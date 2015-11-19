package ite.librarymaster;

import ite.librarymaster.model.*;
import ite.librarymaster.service.*;

import java.util.*;

import org.springframework.context.support.*;

/**
 * Application entry point.
 * 
 * @author macalak@itexperts.sk
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:ite/librarymaster/application-config.xml");
		context.refresh();
		// Register shutdown hook to destroy container gracefully
        ((AbstractApplicationContext)context).registerShutdownHook();
		LibraryService libraryService=context.getBean(LibraryService.class);
		List<Book> books = libraryService.getAllBooks();
		for(Book book:books){
			System.out.println(book);
		}
	}

}
