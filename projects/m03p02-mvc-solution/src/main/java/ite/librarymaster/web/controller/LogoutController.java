package ite.librarymaster.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User logout handler. 
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Controller
public class LogoutController {
	final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
		logger.info("Invalidating current session ...");
        session.invalidate();
        return "redirect:/library/login";
    }
	
}
