package ite.librarymaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Library application context.
 * 
 * @author ivan.macalak@posam.sk
 */
@Configuration
@ComponentScan(basePackages = { "ite.librarymaster.dao","ite.librarymaster.service"  })
@ImportResource("classpath:ite/librarymaster/application-config.xml")
@EnableTransactionManagement
public class LibraryApplicationConfig {
	final Logger logger = LoggerFactory.getLogger(LibraryApplicationConfig.class);
	
}