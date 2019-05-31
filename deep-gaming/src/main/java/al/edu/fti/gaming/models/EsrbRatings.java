package al.edu.fti.gaming.models;

import java.io.Serializable;
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
public class EsrbRatings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8261369097758438673L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_esrb_rating", nullable = false)
	private Integer idEsrbRating;

	@Column(name = "esrb_rating_name", unique = true, nullable = false, length = 10)
	private String esrbRatingName;

	@Column(name = "esrb_rating_description", nullable = false, length = 65535)
	private String esrbRatingDescription;

	@OneToMany(mappedBy = "esrbRating")
	private List<Game> gamesWithThisEsrbRating = new ArrayList<Game>();

	public EsrbRatings(Integer idEsrbRating, String esrbRatingName, String esrbRatingDescription,
			List<Game> gamesWithThisEsrbRating) {
		super();
		this.idEsrbRating = idEsrbRating;
		this.esrbRatingName = esrbRatingName;
		this.esrbRatingDescription = esrbRatingDescription;
		this.gamesWithThisEsrbRating = gamesWithThisEsrbRating;
	}

	public EsrbRatings() {
		super();
	}

	public Integer getIdEsrbRating() {
		return idEsrbRating;
	}

	public void setIdEsrbRating(Integer idEsrbRating) {
		this.idEsrbRating = idEsrbRating;
	}

	public String getEsrbRatingName() {
		return esrbRatingName;
	}

	public void setEsrbRatingName(String esrbRatingName) {
		this.esrbRatingName = esrbRatingName;
	}

	public String getEsrbRatingDescription() {
		return esrbRatingDescription;
	}

	public void setEsrbRatingDescription(String esrbRatingDescription) {
		this.esrbRatingDescription = esrbRatingDescription;
	}

	public List<Game> getGamesWithThisEsrbRating() {
		return gamesWithThisEsrbRating;
	}

	public void setGamesWithThisEsrbRating(List<Game> gamesWithThisEsrbRating) {
		this.gamesWithThisEsrbRating = gamesWithThisEsrbRating;
	}

}
