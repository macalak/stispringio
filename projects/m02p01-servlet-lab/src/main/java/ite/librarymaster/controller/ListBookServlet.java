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
// TODO 5: Add metadata to configure this servlet with servlet container
// TODO 2: Extend this class from correct Java Servlet API class to turn it into Java Servlet
public class ListBookServlet  {
	final Logger logger = LoggerFactory.getLogger(ListBookServlet.class);
	
	private BookRepository bookRepository;

	// TODO 3: Override the Servlet's init() method and set the customerDao property.

	// TODO 2: Override HttpServlet's method to handle HTTP Requests
	// TODO 4: Implement the HTML (all.html) page generation with list of all customers

}
