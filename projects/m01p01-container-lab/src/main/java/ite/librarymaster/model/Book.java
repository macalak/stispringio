package ite.librarymaster.model;

/**
 * This class models a Book media type.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
public class Book extends Text {
	
	private String author;
	private String isbn;
	private BookGenre genre;
	
	public Book() {
		super();
	}
	
	public Book(Long id, String catId, String title, String publisher, String author, String isbn, BookGenre genre, MediumAvailability availability) {
		super(id, catId, title, publisher, availability);
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BookGenre getGenre() {
		return genre;
	}
	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre != other.genre)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [getAuthor()=" + getAuthor() + ", getIsbn()=" + getIsbn()
				+ ", getGenre()=" + getGenre() + ", getPublisher()=" + getPublisher()
				+ ", getId()=" + getId() + ", getCatId()=" + getCatId()
				+ ", getTitle()=" + getTitle() 
				+ ", getAvailability()=" + getAvailability()
				+ "]";
	}
	
}
