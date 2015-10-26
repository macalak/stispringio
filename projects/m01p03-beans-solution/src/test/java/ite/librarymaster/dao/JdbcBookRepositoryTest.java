package ite.librarymaster.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcBookRepositoryTest {
	
	private BookRepository bookRepository;
	private ApplicationContext context;

	@Before
	public void setUp() {
		// Create the test configuration for the application
		context = new ClassPathXmlApplicationContext(
				"classpath:/ite/librarymaster/dao/JdbcBookRepositoryTest-context.xml");
		// Get the tested bean
		bookRepository = context.getBean(BookRepository.class);
	}
	
	@After 
	public void tearDown(){
		if(context != null){
			// Close Spring application context after test execution
			((ConfigurableApplicationContext)context).close();				
		}
	}

	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = bookRepository.findAll();
		assertNotNull(allBooks);
		// Verify number of books returned
		assertEquals(4,allBooks.size());
	}

	@Test
	public void testFindByIsbn() {
		Book book = bookRepository.findByIsbn("9780553382563");
	    assertNotNull(book);
		assertEquals("I, Robot",book.getTitle());
		assertEquals("Random House Inc",book.getPublisher());
		assertEquals("Isaac Asimov",book.getAuthor());
		assertEquals(BookGenre.Scifi,book.getGenre());
	}

}
