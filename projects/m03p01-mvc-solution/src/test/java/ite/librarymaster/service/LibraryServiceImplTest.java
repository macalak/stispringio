package ite.librarymaster.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import ite.librarymaster.model.Book;
import ite.librarymaster.service.LibraryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
/* Note that if no file is specified to @ContextConfiguration, it is derived as <classname>-context.xml, 
 * so in this case, it expects to find LibraryServiceImplTest-context.xml in the current directory */
@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryServiceImplTest {
	
	@Autowired
	private LibraryService libraryService;

	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = libraryService.getAllBooks();
		assertNotNull(allBooks);
		// Verify number of books returned
		assertEquals(4,allBooks.size());
	}

}
