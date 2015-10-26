package ite.librarymaster.dao;

import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;
import ite.librarymaster.model.MediumAvailability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;

public class JdbcBookRepository implements BookRepository {
	final Logger logger = LoggerFactory.getLogger(JdbcBookRepository.class);
	 
	private DataSource dataSource;
	
	
	public JdbcBookRepository() {
		super();
		logger.info("JdbcBookRepository() <-");
	}

	@PostConstruct
	public void initialize(){
		logger.info("initialize() <-");
	}
	
	@PreDestroy
	public void cleanup(){
		logger.info("cleanup() <-");
	}
	
	@Required
	public void setDataSource(DataSource dataSource) {
		logger.info("setDataSource() <-");
		this.dataSource=dataSource;
	}

	@Override
	public List<Book> findAll() {
		String sql = "select * from BOOK";
		List<Book> books  = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				books.add(mapBook(rs));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQL exception occurred ...", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return books;	
	}

	@Override
	public Book findByIsbn(String isbn) {
		String sql = "select * from BOOK where ISBN = ?";
		Book book  = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if( rs.next()){
				book=mapBook(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQL exception occurred ...", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return book;
	}
	
	private Book mapBook(ResultSet rs) throws SQLException{
		Long id = rs.getLong("ID");
		String catId = rs.getString("CATID");
		String title = rs.getString("TITLE");
		MediumAvailability availability = MediumAvailability.valueOf(rs.getString("AVAILABILITY"));
		String publisher= rs.getString("PUBLISHER");
		String author= rs.getString("AUTHOR");
		String isbn= rs.getString("ISBN");
		BookGenre genre= BookGenre.valueOf(rs.getString("GENRE"));
		return new Book(id,catId,title,publisher,author,isbn,genre,availability);
	}
}
