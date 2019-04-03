package ite.librarymaster.service;

import static org.junit.Assert.*;
import ite.librarymaster.model.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
/*
 * Note that if no file is specified to @ContextConfiguration, it is derived as
 * <classname>-context.xml, so in this case, it expects to find
 * LibraryServiceImplTest-context.xml in the current directory
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryServiceImplTest {

    @Autowired
    private LibraryService libraryService;

    @Test
    @DirtiesContext
    public void testGetAllBooks() {
        List<Book> allBooks = libraryService.getAllBooks();
        assertNotNull(allBooks);
        // Verify number of books returned
        assertEquals(4, allBooks.size());
    }

    @Test
    public void testGetBook() {
        Book book = libraryService.getBook(1L);
        assertNotNull(book);
    }

}
