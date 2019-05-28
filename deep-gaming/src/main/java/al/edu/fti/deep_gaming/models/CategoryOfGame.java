package al.edu.fti.deep_gaming.models;

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
public class CategoryOfGame {

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
}
