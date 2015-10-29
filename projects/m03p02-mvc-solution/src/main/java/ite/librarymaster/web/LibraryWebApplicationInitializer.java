package ite.librarymaster.web;

import ite.librarymaster.LibraryApplicationConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring way, how to initialize the Web application without web.xml.
 * It utilizes the Servlet 3.0 ServletContainerInitializer.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class LibraryWebApplicationInitializer implements WebApplicationInitializer{
	final Logger logger = LoggerFactory.getLogger(LibraryWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("Registering Servlet context listener ...");
		registerListener(servletContext);
		logger.info("Registering Spring Dispatcher servlet ...");
		registerDispatcherServlet(servletContext);
	}
	
    private void registerListener(ServletContext servletContext) {
    	WebApplicationContext rootContext = createContext(LibraryApplicationConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

    }

	private void registerDispatcherServlet(final ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(LibraryWebApplicationConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		ServletRegistration.Dynamic dispatcher;
		dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/library/*");
		}
	
	private WebApplicationContext createContext(final Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}
}
