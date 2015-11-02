package ite.librarymaster.dao;

import ite.librarymaster.model.User;
import ite.librarymaster.model.UserState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In memory implementation of the UserRepository.
 * It keeps users in memory. 
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class InMemoryUserRepository implements UserRepository {
	final Logger logger = LoggerFactory.getLogger(InMemoryUserRepository.class);
	private Map<Long,User> users = new TreeMap<Long,User>();

	public void initialize(){
		logger.info("initialize() <-");
		users.put(1L, new User(1L,"Tyrion","Lannister",UserState.Active));
		users.put(2L, new User(2L,"Daenerys","Targaryen",UserState.Active));
		users.put(3L, new User(3L,"Jon","Snow",UserState.Active));
		users.put(4L, new User(4L,"Theon","Greyjoy",UserState.Blocked));
		users.put(5L, new User(5L,"Robb","Stark",UserState.Inactive));
		users.put(6L, new User(6L,"Sansa","Stark",UserState.Active));
		users.put(7L, new User(7L,"Stannis","Baratheon",UserState.Active));
		users.put(8L, new User(8L,"Samwell","Tarly",UserState.Active));
		users.put(9L, new User(9L,"Khal","Drogo",UserState.Inactive));
		users.put(10L, new User(10L,"Margaery","Tyrell",UserState.Active));
	}
	
	@Override
	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}

	@Override
	public List<User> findActive() {
		ArrayList<User> activeUsers = new ArrayList<User>(7);
		for(User user:users.values()){
			if(user.getUserState().equals(UserState.Active)){
				activeUsers.add(user);
			}
		}
		return activeUsers;
	}
}
