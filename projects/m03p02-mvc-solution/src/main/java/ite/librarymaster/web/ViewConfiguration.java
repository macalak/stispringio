package ite.librarymaster.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Spring MVC configuration for the View Technologies.
 * 
 * @author ivan.macalak@posam.sk
 * 
 */
@Configuration
public class ViewConfiguration {
	final Logger logger = LoggerFactory.getLogger(ViewConfiguration.class);

    @Bean
    public TilesConfigurer tilesConfigurer() {
    	logger.info("Initializing TilesConfigurer ...");
        return new TilesConfigurer();
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
    	logger.info("Initializing TilesViewResolver ...");
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(2);
        return tilesViewResolver;
    }
}
