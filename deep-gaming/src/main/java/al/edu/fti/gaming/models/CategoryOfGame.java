package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_of_name")
public class CategoryOfGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146154205332373434L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category", nullable = false)
	private Integer idCategory;

	@Column(name = "category_name", unique = true, nullable = false, length = 50)
	private String categoryName;

	@Column(name = "category_description", nullable = false, length = 65535)
	private String categoryDescription;

	@ManyToMany(mappedBy = "categoriesOfThisGame")
	private Set<Game> gamesOfThisCategory = new HashSet<Game>();

	public CategoryOfGame(Integer idCategory, String categoryName, String categoryDescription,
			Set<Game> gamesOfThisCategory) {
		super();
		this.idCategory = idCategory;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.gamesOfThisCategory = gamesOfThisCategory;
	}

	public CategoryOfGame() {

	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Set<Game> getGamesOfThisCategory() {
		return gamesOfThisCategory;
	}

	public void setGamesOfThisCategory(Set<Game> gamesOfThisCategory) {
		this.gamesOfThisCategory = gamesOfThisCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryDescription == null) ? 0 : categoryDescription.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((gamesOfThisCategory == null) ? 0 : gamesOfThisCategory.hashCode());
		result = prime * result + ((idCategory == null) ? 0 : idCategory.hashCode());
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
		CategoryOfGame other = (CategoryOfGame) obj;
		if (categoryDescription == null) {
			if (other.categoryDescription != null)
				return false;
		} else if (!categoryDescription.equals(other.categoryDescription))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (gamesOfThisCategory == null) {
			if (other.gamesOfThisCategory != null)
				return false;
		} else if (!gamesOfThisCategory.equals(other.gamesOfThisCategory))
			return false;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
			return false;
		return true;
	}
	
	

}
