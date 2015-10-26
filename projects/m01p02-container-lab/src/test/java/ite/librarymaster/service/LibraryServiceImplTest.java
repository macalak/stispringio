package ite.librarymaster.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ite.librarymaster.model.Book;
import ite.librarymaster.model.User;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * This test verifies functionality of LibraryService implementation.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@ContextConfiguration(value="classpath:ite/librarymaster/application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryServiceImplTest {
	
	/**
	 * The object being tested.
	 */
	@Autowired
	private LibraryService libraryService;
	
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
