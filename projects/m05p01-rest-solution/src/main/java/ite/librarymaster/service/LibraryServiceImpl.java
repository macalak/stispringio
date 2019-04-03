package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service
@Transactional(readOnly=true)
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	@Qualifier("jpaBookRepository")
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

    @Override
    public Book getBook(Long id) throws ItemNotFoundException {
        Book book = bookRepository.findById(id);
        if(book == null){
            throw new ItemNotFoundException("Book with id="+id+" not found.");
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        return  bookRepository.saveBook(book);
    }
}
