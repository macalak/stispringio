package ite.librarymaster.web.interceptor;

import ite.librarymaster.model.User;
import ite.librarymaster.service.AuthenticationException;
import ite.librarymaster.web.controller.LoginController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

/**
 * Security cross-cutting concern implementation.
 * It utilizes the Spring MVC interceptor strategy by servlet's HandlerInterceptor.
 * There is convenient HandlerInterceptorAdapter provided by Spring. 
 * 
 * The WebRequestInterceptor strategy can be used as alternative, if we like to
 * be independed from the underlying technology (Servlet, JSF).
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("-> {}",request.getRequestURI());
		
		User loggedUser = (User) WebUtils.getSessionAttribute(request, LoginController.LOGGED_USER_ATTRIBUTE);
		if (loggedUser == null) {
			logger.warn("User not logged-in!");
			//Retrieve and store the original URL.
			String url = request.getRequestURL().toString();
			WebUtils.setSessionAttribute(request, LoginController.REQUESTED_URL, url);
			throw new AuthenticationException("User is not logged-in!");
		}
		return true;
	}

}
