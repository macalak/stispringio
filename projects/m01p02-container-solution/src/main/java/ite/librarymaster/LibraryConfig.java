package ite.librarymaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.dao.InMemoryBookRepository;
import ite.librarymaster.dao.InMemoryUserRepository;
import ite.librarymaster.dao.UserRepository;
import ite.librarymaster.service.LibraryService;
import ite.librarymaster.service.LibraryServiceImpl;

/**
 * Spring Java based application configuration.
 * 
 * @author ivan.macalak@posam.sk
 *
 */

@Configuration
//@ComponentScan
@ImportResource("classpath:ite/librarymaster/application-config.xml")
public class LibraryConfig {
	final Logger logger = LoggerFactory.getLogger(LibraryConfig.class);
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{T(java.lang.Math).random() * 100.0}")
	private float randomNumber;
	
	@Bean
	public LibraryService libraryService() {
		logger.info("libraryService() <-");
		logger.info("OS name is .... {}",osName);
		logger.info("Random number =  {}", randomNumber);
		LibraryServiceImpl service = new LibraryServiceImpl(userRepository());
		service.setBookRepository(bookRepository());
		return service;
	}

	// You can define destroy method
	@Bean(destroyMethod="close")
	public BookRepository bookRepository() {
		logger.info("bookRepository() <-");
		InMemoryBookRepository bookRepository = new InMemoryBookRepository();
		//bookRepository.initialize();
		return bookRepository;
	}
	
	@Bean
	public UserRepository userRepository() {
		logger.info("userRepository() <-");
		InMemoryUserRepository userRepository= new InMemoryUserRepository();
		userRepository.initialize();
		return userRepository;
	}

}
