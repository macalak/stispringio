package ite.librarymaster.dao;

import ite.librarymaster.model.*;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

@Repository("jdbcBookRepository")
public class JdbcBookRepository implements BookRepository {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Book> rowMapper = new BookRowMapper();
	
	// TODO 1: Add appropriate annotation to inject data source 
	public JdbcBookRepository(DataSource dataSource) {
		super();
		// TODO 2: Create new instance of JdbcTemplate using provided DataSource
	}

	@Override
	public List<Book> findAll() {
		String sql = "select * from MEDIUM_TBL";
		List<Book> books  = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Book.class));
		return books;	
	}

	@Override
	public Book findByIsbn(String isbn) {
		String sql = "select * from MEDIUM_TBL where ISBN = ?";
		// Example with BeanPropertyRowMapper
		// TODO 5: Use BeanPropertyRowMapper in jdbcTemplate.queryForObject(...)
		return null;
	}
	
    @Override
    public Book findById(Long id) {
        String sql = "select * from MEDIUM_TBL where ID = ?";
        //Example with custom RowMapper
        // TODO 4: Use jdbcTemplate to query for Book with rowMapper  
        return null;
    }

	
	@Override
	public void saveBook(Book book){
		if(book != null){
			if(book.getId()!= null){
				update(book);
			} else{
				insert(book);
			}
		}
	}
	
	private int insert(Book book){
		String sql = "insert into MEDIUM_TBL (ID, CATID, TITLE, PUBLISHER, AUTHOR, ISBN, GENRE, AVAILABILITY) " +
				     "values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,generateBookId(),
				                book.getCatId(),
				                book.getTitle(),
				                book.getPublisher(),
				                book.getAuthor(),
				                book.getIsbn(),
				                book.getGenre().toString(),
				                book.getAvailability().toString());
	}
	
	private int update(Book book){
		String sql = "update MEDIUM_TBL set CATID=?, TITLE=?, PUBLISHER=?, AUTHOR=?, ISBN=?, GENRE=?, AVAILABILITY=?, where ID=?";
		return jdbcTemplate.update(sql,
			                book.getCatId(),
			                book.getTitle(),
			                book.getPublisher(),
			                book.getAuthor(),
			                book.getIsbn(),
			                book.getGenre().toString(),
			                book.getAvailability(),
			                book.getId());
	}
	
	
	private long generateBookId(){
	    String sql = "select MAX(ID) from MEDIUM_TBL";
	    Long actialId=jdbcTemplate.queryForObject(sql,Long.class);
	    return ++actialId;
	}
	
	/**
	 * Maps a row returned from a query to a Book object.
	 * 
	 * @param rs the result set with its cursor positioned at the current row
	 */
	private Book mapBook(ResultSet rs) throws SQLException {
		Long id = rs.getLong("ID");
		String catId = rs.getString("CATID");
		String title = rs.getString("TITLE");
		String publisher = rs.getString("PUBLISHER");
		String author = rs.getString("AUTHOR");
		String isbn = rs.getString("ISBN");
		BookGenre genre = BookGenre.valueOf(rs.getString("GENRE"));
		MediumAvailability availability = MediumAvailability.valueOf(rs.getString("AVAILABILITY"));
		
		Book mappedBook= new Book(id,catId,title,publisher,author,isbn,genre,availability);
		return mappedBook;
		
	}
	
	private class BookRowMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO 3: Use mapBook(...) method to map ResultSet to Book object
			return null;
		}
	}
}
