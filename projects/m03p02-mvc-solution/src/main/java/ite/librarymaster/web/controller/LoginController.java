package ite.librarymaster.web.controller;

import ite.librarymaster.model.User;
import ite.librarymaster.service.AuthenticationException;
import ite.librarymaster.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * User login handler implementation.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	public static final String LOGGED_USER_ATTRIBUTE = "LOGGED_USER";
	public static final String REQUESTED_URL = "REQUESTED_URL";
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleLogin(@RequestParam String username, @RequestParam String password,
            RedirectAttributes redirect, HttpSession session) throws AuthenticationException {
    	
        try {
            User user = this.userService.login(username, password);
            session.setAttribute(LOGGED_USER_ATTRIBUTE, user);
            String url = (String) session.getAttribute(REQUESTED_URL);
            session.removeAttribute(REQUESTED_URL);
        	if (StringUtils.hasText(url) && !url.contains("login")) { // Prevent loops for the login page.
                return "redirect:" + url;
        	} else {    
        		return "redirect:/library/books";
        	}
        } catch (AuthenticationException ae) {
            redirect.addFlashAttribute("exception", ae);
            return "redirect:/library/login";
        }
    }
}


