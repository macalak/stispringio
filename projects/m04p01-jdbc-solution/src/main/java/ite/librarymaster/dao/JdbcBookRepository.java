package ite.librarymaster.dao;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.model.MediumAvailability;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("jdbcBookRepository")
public class JdbcBookRepository implements BookRepository {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Book> rowMapper = new BookRowMapper();
	
	@Autowired
	public JdbcBookRepository(DataSource dataSource) {
		super();
		this.jdbcTemplate=new JdbcTemplate(dataSource);
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
		Book book = (Book)jdbcTemplate.queryForObject(
				sql, new Object[] { isbn }, 
				BeanPropertyRowMapper.newInstance(Book.class));
		return book;
	}
	
    @Override
    public Book findById(Long id) {
        String sql = "select * from MEDIUM_TBL where ID = ?";
        //Example with custom RowMapper
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
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
			return mapBook(rs);
		}
	}
}
