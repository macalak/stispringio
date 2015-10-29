package ite.librarymaster.web;

import ite.librarymaster.web.interceptor.RequestMonitorInterceptor;
import ite.librarymaster.web.interceptor.SecurityInterceptor;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring configuration for web layer.
 * It is important to narrow java packages scanning in order to seed-up the application start.
 * 
 * @author ivan.macalak@posam.sk
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "ite.librarymaster.web" }) 
public class LibraryWebApplicationConfig extends WebMvcConfigurerAdapter{
	final Logger logger = LoggerFactory.getLogger(LibraryWebApplicationConfig.class);
	
	@Bean
    public ViewResolver getViewResolver(){
		logger.info("Instantiating InternalResourceViewResolver ...");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		logger.info("Configuring Handler exception resolvers ...");
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties exceptionMappings = new Properties();
		exceptionMappings.put("ite.librarymaster.service.ItemNotFoundException", "error/404");
		exceptionMappings.put("AuthenticationException", "login");
		exceptionResolver.setExceptionMappings(exceptionMappings);

		Properties statusCodes = new Properties();
		statusCodes.put("error/404","404");
		statusCodes.put("error/error","500");
		exceptionResolver.setStatusCodes(statusCodes);

		exceptionResolvers.add(exceptionResolver);
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		logger.info("Configuring interceptors ...");
        registry.addWebRequestInterceptor(requestMonitorInterceptor());
        //Protect all pages except login page
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/books","/book/**");
    }

    @Bean
    public WebRequestInterceptor requestMonitorInterceptor() {
    	logger.info("Instantiating RequestMonitorInterceptor ...");
        return new RequestMonitorInterceptor();
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	
}
