package al.edu.fti.deep_gaming.models;

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
public class GameFranchise {

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
}
