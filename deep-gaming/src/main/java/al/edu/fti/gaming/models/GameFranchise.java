package al.edu.fti.gaming.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game_franchise")
public class GameFranchise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7117571706819527479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_game_franchise", nullable = false)
	private Integer idGameFranchise;

	@Column(name = "game_franchise_name", unique = true, nullable = false, length = 50)
	private String gameFranchiseName;

	@Column(name = "game_franchise_description", nullable = false, length = 65535)
	private String gameFrachiseDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisGameFranchise;

	public GameFranchise() {

	}

	public GameFranchise(Integer idGameFranchise, String gameFranchiseName, String gameFrachiseDescription,
			Company companyOfThisGameFranchise) {
		super();
		this.idGameFranchise = idGameFranchise;
		this.gameFranchiseName = gameFranchiseName;
		this.gameFrachiseDescription = gameFrachiseDescription;
		this.companyOfThisGameFranchise = companyOfThisGameFranchise;
	}

	public Integer getIdGameFranchise() {
		return idGameFranchise;
	}

	public void setIdGameFranchise(Integer idGameFranchise) {
		this.idGameFranchise = idGameFranchise;
	}

	public String getGameFranchiseName() {
		return gameFranchiseName;
	}

	public void setGameFranchiseName(String gameFranchiseName) {
		this.gameFranchiseName = gameFranchiseName;
	}

	public String getGameFrachiseDescription() {
		return gameFrachiseDescription;
	}

	public void setGameFrachiseDescription(String gameFrachiseDescription) {
		this.gameFrachiseDescription = gameFrachiseDescription;
	}

	public Company getCompanyOfThisGameFranchise() {
		return companyOfThisGameFranchise;
	}

	public void setCompanyOfThisGameFranchise(Company companyOfThisGameFranchise) {
		this.companyOfThisGameFranchise = companyOfThisGameFranchise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyOfThisGameFranchise == null) ? 0 : companyOfThisGameFranchise.hashCode());
		result = prime * result + ((gameFrachiseDescription == null) ? 0 : gameFrachiseDescription.hashCode());
		result = prime * result + ((gameFranchiseName == null) ? 0 : gameFranchiseName.hashCode());
		result = prime * result + ((idGameFranchise == null) ? 0 : idGameFranchise.hashCode());
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
		GameFranchise other = (GameFranchise) obj;
		if (companyOfThisGameFranchise == null) {
			if (other.companyOfThisGameFranchise != null)
				return false;
		} else if (!companyOfThisGameFranchise.equals(other.companyOfThisGameFranchise))
			return false;
		if (gameFrachiseDescription == null) {
			if (other.gameFrachiseDescription != null)
				return false;
		} else if (!gameFrachiseDescription.equals(other.gameFrachiseDescription))
			return false;
		if (gameFranchiseName == null) {
			if (other.gameFranchiseName != null)
				return false;
		} else if (!gameFranchiseName.equals(other.gameFranchiseName))
			return false;
		if (idGameFranchise == null) {
			if (other.idGameFranchise != null)
				return false;
		} else if (!idGameFranchise.equals(other.idGameFranchise))
			return false;
		return true;
	}

}
