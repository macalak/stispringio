package ite.librarymaster;

import ite.librarymaster.dao.InMemoryBookRepository;
import ite.librarymaster.dao.InMemoryUserRepository;
import ite.librarymaster.service.LibraryService;
import ite.librarymaster.service.LibraryServiceImpl;
import ite.librarymaster.service.UserService;
import ite.librarymaster.service.UserServiceImpl;

public class ServiceLocator {

    private static ServiceLocator instance = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return instance;
    }

    protected ServiceLocator() {
    }


    private LibraryService libraryService;
    private UserService userService;

    public synchronized LibraryService getLibraryService() {
        if (libraryService == null) {
            InMemoryBookRepository bookRepository = new InMemoryBookRepository();
            bookRepository.initialize();
            LibraryServiceImpl service = new LibraryServiceImpl();
            service.setBookRepository(bookRepository);
            libraryService = service;
        }
        return libraryService;
    }

    public synchronized UserService getUserService() {
        if (userService == null) {
            InMemoryUserRepository userRepository = new InMemoryUserRepository();
            userRepository.initialize();
            UserServiceImpl service = new UserServiceImpl();
            service.setUserRepository(userRepository);
            userService = service;
        }
        return userService;
    }


}
