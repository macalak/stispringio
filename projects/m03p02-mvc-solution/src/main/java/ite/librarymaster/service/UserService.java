package ite.librarymaster.service;

import ite.librarymaster.model.User;

/**
 * Library User service interface definition.
 *  
 * @author ivan.macalak@posam.sk
 *
 */
public interface UserService {
	
	User login(String username, String password) throws AuthenticationException;
	
}
