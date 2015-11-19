package ite.librarymaster;

import ite.librarymaster.dao.*;
import ite.librarymaster.model.*;

import java.util.*;

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
	    
	    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		// Set Configuration profile
		context.getEnvironment().setActiveProfiles("production");
		context.load("classpath:ite/librarymaster/application-config.xml");
		context.refresh();
		// Register shutdown hook to destroy container gracefully
        ((AbstractApplicationContext)context).registerShutdownHook();
		BookRepository bookRepository=context.getBean(BookRepository.class);
		// Inserting new Book into library database
//		Book newOne=new Book(null,"LM-000005","A Clash of Kings","HarperCollins Publishers","George R. R. Martin","9780006479895",BookGenre.Fantasy);
//		bookRepository.saveBook(newOne);
		List<Book> books = bookRepository.findAll();
		for(Book book:books){
			System.out.println(book);
		}
	}

}
