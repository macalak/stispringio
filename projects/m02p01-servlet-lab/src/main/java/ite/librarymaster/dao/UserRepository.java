package ite.librarymaster.dao;

import ite.librarymaster.model.User;

import java.util.List;

/**
 * User Repository interface defines operations to
 * access and manipulate Users.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface UserRepository {
	
	/**
	 * Finds all Library users.
	 * @return - all Library users
	 */
	List<User> findAll();
	
	/**
	 * Finds Active Library users. 
	 * @return - Active Library users only
	 */
	List<User> findActive();

}
