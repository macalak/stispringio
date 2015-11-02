package ite.librarymaster.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO 2: Implement the Servlet's Filter interface
// TODO 3: Annotate class by correct annotation to configure it as Servlet filter
public class DefaultUtf8Filter {
	final Logger logger = LoggerFactory.getLogger(DefaultUtf8Filter.class);
	
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	logger.info("Applaying DefaultUtf8Filter Servlet filter...");
        if (request.getCharacterEncoding() == null || request.getCharacterEncoding().isEmpty()) {
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }
}
