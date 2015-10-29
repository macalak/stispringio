package ite.librarymaster.dao;

import ite.librarymaster.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the UserRepository.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Repository("jpaUserRepository")
public class JpaUserRepository  implements UserRepository{
	 final Logger logger = LoggerFactory.getLogger(JpaUserRepository.class);

	@PersistenceContext
	EntityManager entityManager; 
	
	@Override
	public User findByUsername(String username) {
		User result=null;
		TypedQuery<User> namedQuery = entityManager.createNamedQuery("user.findByUsername",User.class);
		namedQuery.setParameter("username", username);
		try{
			result=namedQuery.getSingleResult();
			logger.info("USER found {}",result);
		} catch(NoResultException exception){
			logger.warn("No USER found for provided username {}",username);
		}
		return result;
	}
}
