package ite.librarymaster.dao;

import ite.librarymaster.model.User;

/**
 * User Repository interface defines operations to
 * access and manipulate library Users.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public interface UserRepository {
	
	User findByUsername(String username);

}
