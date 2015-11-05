package ite.librarymaster.web.controller;

import ite.librarymaster.ServiceLocator;
import ite.librarymaster.model.User;

import java.util.List;

/**
 * @author ivan.macalak@posam.sk
 */
public class UsersController {

    public List<User> getUsers(){
        return ServiceLocator.getInstance().getUserService().getAllUsers();
    }
}
