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

@WebFilter(filterName = "DefaultUtf8Filter", urlPatterns = ("/*") , asyncSupported = true)
public class DefaultUtf8Filter implements Filter {
	final Logger logger = LoggerFactory.getLogger(DefaultUtf8Filter.class);
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	logger.info("Applaying DefaultUtf8Filter Servlet filter...");
        if (request.getCharacterEncoding() == null || request.getCharacterEncoding().isEmpty()) {
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	logger.info("Initializing Servlet filter...");
    }

    @Override
    public void destroy() {
    	logger.info("Destroying Servlet filter...");
    }
}
