package ite.librarymaster.controller;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.dao.InMemoryBookRepository;
import ite.librarymaster.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Simple Java Servlet example.
 * It renders the HTML page, which contains list of all books.
 * The PrintWriter is used to directly write HTML page content into HTTP response.
 * The web (servlet) container calls the init() lifecycle callback after servlet is
 * instantiated.    
 *
 */
@SuppressWarnings("serial")
@WebServlet("/books/all.html")
public class ListBookServlet extends HttpServlet {
	final Logger logger = LoggerFactory.getLogger(ListBookServlet.class);
	
	private BookRepository bookRepository;
	
    @Override
    public void init() {
    	logger.info("Initializing ListBookServlet...");
		bookRepository = new InMemoryBookRepository();
		((InMemoryBookRepository)bookRepository).initialize();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("Processing HTTP {} request...",request.getMethod());
    	
        List<Book> allBooks = bookRepository.findAll();
        
        response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html");
		writer.println("<head><title> All Books Servlet Example </title></head>");
		writer.println("<body>");
		writer.println("<h1> List of all Books</h1>");
		writer.println("<lu>");
		for(Book book : allBooks){
			writer.println("<li>"+book+"</li>");
		}
		writer.println("</lu>");
		writer.println("</p>");
		writer.println("<h1> Customer Table</h1>");
		writer.println("<table border=\"1\" style=\"width:100%\">");
		for(Book book : allBooks){
			writer.println("<tr>");
			writer.println("<td>"+book.getId()+"</td>");
			writer.println("<td>"+book.getTitle()+"</td>");
			writer.println("<td>"+book.getAuthor()+"</td>");
			writer.println("<td>"+book.getGenre()+"</td>");
			writer.println("</tr>");
		}
		writer.println("</table>");
		
		writer.println("</body>");
		writer.println("</html>");

    }

}
