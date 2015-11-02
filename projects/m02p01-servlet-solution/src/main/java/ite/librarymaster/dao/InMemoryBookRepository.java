package ite.librarymaster.dao;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.model.MediumAvailability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * In memory implementation of the BookRepository.
 * It keeps books in memory. 
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class InMemoryBookRepository implements BookRepository {
	final Logger logger = LoggerFactory.getLogger(InMemoryBookRepository.class);
	private Map<String,Book> books = new TreeMap<String,Book>();

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

}
