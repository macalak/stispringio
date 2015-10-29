package ite.librarymaster.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * This class models general Medium, which can be stored in Library.
 * 
 * @author ivan.macalak@posam.sk
 *
 */
@Entity
@Table(name="MEDIUM_TBL")
public abstract class Medium {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String catId;
	
	private String title;
	
	@Enumerated(EnumType.STRING)
	private MediumAvailability availability;
	
	public Medium() {
		super();
	}
	
	public Medium(Long id, String catId, String title, MediumAvailability availability) {
		super();
		this.id = id;
		this.catId = catId;
		this.title = title;
		this.availability = availability;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public MediumAvailability getAvailability() {
		return availability;
	}

	public void setAvailability(MediumAvailability availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medium other = (Medium) obj;
		if (availability != other.availability)
			return false;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medium [id=" + id + ", catId=" + catId + ", title=" + title
				+ ", availability=" + availability + "]";
	}


}
