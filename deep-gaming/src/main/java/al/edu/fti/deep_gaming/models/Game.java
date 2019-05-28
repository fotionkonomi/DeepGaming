package al.edu.fti.deep_gaming.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game extends Product{

	@Column(name = "ram_low", nullable = false)
	private Double ramLow;
	
	@Column(name = "ram_medium", nullable = false)
	private Double ramMedium;
	
	@Column(name = "ram_high", nullable = false)
	private Double ramHigh;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_game_franchise", nullable = false)
	private GameFranchise franchiseOfThisGame;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_low", nullable = false)
	private CPU cpuLow;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_medium", nullable = false)
	private CPU cpuMedium;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_high", nullable = false)
	private CPU cpuHigh;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_low", nullable = false)
	private GPU gpuLow;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_medium", nullable = false)
	private GPU gpuMedium;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_high", nullable = false)
	private GPU gpuHigh;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_direct_x_low", nullable = false)
	private DirectX directXMinimum;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_esrb_rating", nullable = false)
	private EsrbRatings esrbRating;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "game_category", joinColumns = { @JoinColumn(name = "id_gane") }, inverseJoinColumns = {
			@JoinColumn(name = "id_category") })
	private Set<CategoryOfGame> categoriesOfThisGame = new HashSet<CategoryOfGame>();
	
	
}
