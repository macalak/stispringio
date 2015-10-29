package ite.librarymaster.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Seam MVC request monitor interceptor implementation.
 * It utilizes the Spring MVC interceptor strategy by WebRequestInterceptor.
 *  
 * @author ivan.macalak@posam.sk
 *
 */
public class RequestMonitorInterceptor implements WebRequestInterceptor{
	final Logger logger = LoggerFactory.getLogger(RequestMonitorInterceptor.class);

	@Override
	public void preHandle(WebRequest request) throws Exception {
		logger.debug("preHandle() -> "+request.toString());
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		logger.debug("postHandle() -> " + request.toString());
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		logger.debug("afterCompletion ->");
		
	}
}
