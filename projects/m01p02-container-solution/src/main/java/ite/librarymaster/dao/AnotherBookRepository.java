package ite.librarymaster.dao;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.model.MediumAvailability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;

/**
 * Another implementation of the BookRepository to try combination of
 * Java with XML, or Annotation configuration. 
 * Uncomment bookRepository bean definition in ite/librarymaster/application-config.xml
 * in order to override Java based definition of bookRepository.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
// Enable to try Java with combination of Annotation configuration. 
// @Component("bookRepository")
public class AnotherBookRepository implements BookRepository {
	final Logger logger = LoggerFactory.getLogger(AnotherBookRepository.class);
	
	private Map<String,Book> books = new TreeMap<String,Book>();

	@PostConstruct
	public void initialize(){
		logger.info("initialize() <-");
		books.put("9780006479888", new Book(1L,"LM-000001","A Game of Thrones","HarperCollins Publishers","George R. R. Martin","9780006479888",BookGenre.Fantasy, MediumAvailability.Available));
		books.put("9780345538376", new Book(2L,"LM-000002","The Hobbit","Random House Inc","J.R.R. Tolkien","9780345538376",BookGenre.Fantasy, MediumAvailability.Available));
		books.put("9781849162883", new Book(3L,"LM-000003","The Girl with the Dragon Tattoo","Quercus Publishing Plc","Stieg Larsson","9781849162883",BookGenre.Crime, MediumAvailability.Available));
		books.put("9780553382563", new Book(4L,"LM-000004","I, Robot","Random House Inc","Isaac Asimov","9780553382563",BookGenre.Scifi, MediumAvailability.Available));
	}
	
	@Override
	public List<Book> findAll() {
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Book findByIsbn(String isbn) {
		return books.get(isbn);
	}
	
	@Override
	public void close(){
	    logger.info("close() <-");
	}

}
