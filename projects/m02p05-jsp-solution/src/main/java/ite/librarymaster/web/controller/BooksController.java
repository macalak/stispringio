package ite.librarymaster.web.controller;

import ite.librarymaster.ServiceLocator;
import ite.librarymaster.model.Book;
import ite.librarymaster.model.User;

import java.util.List;

/**
 * @author ivan.macalak@posam.sk
 */
public class BooksController {

    public List<Book> getBooks(){
        return ServiceLocator.getInstance().getLibraryService().getAllBooks();
    }
}
