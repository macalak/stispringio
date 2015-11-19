package ite.librarymaster.service;

import ite.librarymaster.dao.BookRepository;
import ite.librarymaster.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	@Qualifier("jpaBookRepository")
	private BookRepository bookRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

    @Override
    @Transactional(readOnly=true)
    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

}
