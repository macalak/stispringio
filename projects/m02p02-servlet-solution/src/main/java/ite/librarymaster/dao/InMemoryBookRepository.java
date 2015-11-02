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
 * \u017E - ž
 * \u0161 - š
 * \u010D - ?
 * \u00FD - ý
 * \u00E1 - á
 * \u00ED - í
 * \u00F4 - ô
 * \u00FA - ú
 * \u00E9 - é
 * \u0148 - ?
 */
public class InMemoryBookRepository implements BookRepository {
	final Logger logger = LoggerFactory.getLogger(InMemoryBookRepository.class);
	private Map<String,Book> books = new TreeMap<String,Book>();

	public void initialize(){
		logger.info("initialize() <-");
		books.put("9788055143033", new Book(1L,"LM-000001","Mu\u017Ei, ktor\u00ED nen\u00E1vidia \u017Eeny","Ikar","Stieg Larsson","9788055143033",BookGenre.Crime, MediumAvailability.Available));
		books.put("9788055143040", new Book(2L,"LM-000002","Diev\u010Da, ktor\u00E9 sa hralo s oh\u0148om","Ikar","Stieg Larsson","9788055143040",BookGenre.Crime, MediumAvailability.Available));
		books.put("9788055143057", new Book(3L,"LM-000003","Vzdu\u0161n\u00FD z\u00E1mok, ktor\u00FD vybuchol","Ikar","Stieg Larsson","9788055143057",BookGenre.Crime, MediumAvailability.Available));
		books.put("9788055143804", new Book(4L,"LM-000004","Diev\u010Da, ktor\u00E9 uviazlo v pav\u00FA\u010Dej sieti ","Ikar","David Lagercrantz","9788055143804",BookGenre.Crime, MediumAvailability.Available));
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
