package ite.librarymaster.model;

import javax.persistence.Entity;

/**
 * This class models general textual media types.
 * 
 * @author ivan.macalak@posam.sk
 *
 */

@Entity
public abstract class Text extends Medium {
	
	private String publisher;

	public Text() {
		super();
	}

	public Text(Long id, String catId, String title, String publisher, MediumAvailability availability) {
		super(id, catId, title, availability);
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		Text other = (Text) obj;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text [getPublisher()=" + getPublisher() + ", getId()=" + getId()
				+ ", getCatId()=" + getCatId() + ", getTitle()=" + getTitle()
				+ ", getAvailability()="+ getAvailability()
				+ "]";
	}
	
}
