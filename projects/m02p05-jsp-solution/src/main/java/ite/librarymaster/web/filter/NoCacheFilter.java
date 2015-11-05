package ite.librarymaster.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "NoCacheFilter", urlPatterns = ("/*") ,asyncSupported = true)
public class NoCacheFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(NoCacheFilter.class);
	
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    	logger.info("Applaying NoCacheFilter Servlet filter...");
        if (resp instanceof HttpServletResponse) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "must-revalidate");
            response.addHeader("Expires", "Mon, 1 Jan 1970 10:00:00 GMT");
        }
        chain.doFilter(req, resp);
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
