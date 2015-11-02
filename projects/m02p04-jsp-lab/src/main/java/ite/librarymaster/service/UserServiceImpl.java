package ite.librarymaster.service;

import ite.librarymaster.dao.UserRepository;
import ite.librarymaster.model.User;

import java.util.List;

/**
 * @author ivan.macalak@posam.sk
 *
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
