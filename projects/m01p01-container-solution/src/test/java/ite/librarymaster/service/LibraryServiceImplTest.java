package ite.librarymaster.service;

import static org.junit.Assert.*;
import ite.librarymaster.model.*;

import java.util.*;

import org.junit.*;
import org.slf4j.*;
import org.springframework.context.*;
import org.springframework.context.support.*;


/**
 * This test verifies functionality of LibraryService implementation.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class LibraryServiceImplTest {
    final Logger logger = LoggerFactory.getLogger(LibraryServiceImplTest.class);
	
	/**
	 * The object being tested.
	 */
	private LibraryService libraryService;
	
	@Before
	public void setUp() {
		// Create the test configuration for the application
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/ite/librarymaster/application-config.xml");
		// Get the tested bean
		libraryService = context.getBean(LibraryService.class);
	}

	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = libraryService.getAllBooks();
		assertNotNull(allBooks);
		// Verify number of books returned
		assertEquals(4,allBooks.size());
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> allUsers = libraryService.getAllUsers();
		assertNotNull(allUsers);
		// Verify number of books returned
		assertEquals(10,allUsers.size());
	}
}
