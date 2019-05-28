package al.edu.fti.deep_gaming.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "esrb_ratings")
public class EsrbRatings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_esrb_rating", nullable = false)
	private Integer idEsrbRating;
	
	@Column(name = "esrb_rating_name",unique = true, nullable = false, length = 10)
	private String esrbRatingName;
	
	@Column(name = "esrb_rating_description", nullable = false, length = 65535)
	private String esrbRatingDescription;
	
	@OneToMany(mappedBy = "esrbRating")
	private List<Game> gamesWithThisEsrbRating = new ArrayList<Game>();
	
	
}
