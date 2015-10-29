package ite.librarymaster.service;

import ite.librarymaster.dao.UserRepository;
import ite.librarymaster.model.User;
import ite.librarymaster.model.UserState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of the UserService interface.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) throws AuthenticationException {
		logger.info("<-");
		User user= userRepository.findByUsername(username);
		if(user != null && user.getUserState().equals(UserState.Active)){
			if(user.getPassword().equals(password)){
				logger.info("User {} sucessffully authenticated.",username);
				return user;
			}else{
				logger.error("User {} authentification failed.",username);
				throw new AuthenticationException("User authentication failed!");
			}
		}else{
			logger.warn("User {} does not exist, or its account is inactive.",username);
			throw new AuthenticationException("User does not exist, or its account is inactive!");
		}
	}
}
