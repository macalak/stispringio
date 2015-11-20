package ite.librarymaster.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.web.context.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:ite/librarymaster/weblayer-config.xml",
                                 "classpath:ite/librarymaster/servicelayer-config.xml",
                                 })
public class BookControllerTest {
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        mockMvc=webAppContextSetup(wac).build();
    }
    
    @Test
    public void testAllBook() throws Exception{
        this.mockMvc.perform(get("/books").accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk()).
        andExpect(view().name("books")).
        andExpect(model().attribute("books", hasSize(4))).
        andExpect(model().attribute("books", hasItem(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("title", is("A Game of Thrones")),
                        hasProperty("author", is("George R. R. Martin")),
                        hasProperty("publisher", is("HarperCollins Publishers")),
                        hasProperty("isbn", is("9780006479888"))
                )
        )));
    }
    
    
    @Test
    public void testBookDetail() throws Exception{
        this.mockMvc.perform(get("/book/1").accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk())
        .andExpect(view().name("bookDetail"))
        .andExpect(model().attribute("book", hasProperty("id", is(1L))))
        .andExpect(model().attribute("book", hasProperty("title", is("A Game of Thrones"))))
        .andExpect(model().attribute("book", hasProperty("author", is("George R. R. Martin"))))
        .andExpect(model().attribute("book", hasProperty("publisher", is("HarperCollins Publishers"))))
        .andExpect(model().attribute("book", hasProperty("isbn", is("9780006479888"))));
    }
    
    @Test
    public void testNonExistentBookDetail() throws Exception{
        this.mockMvc.perform(get("/book/99").accept(MediaType.TEXT_HTML))
        .andExpect(status().isNotFound())
        .andExpect(view().name("error/404"));
    }

    
    
}
