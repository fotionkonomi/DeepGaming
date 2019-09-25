package al.edu.fti.gaming.models;

import java.util.HashSet;
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
public class Game extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251428386518626719L;

	@Column(name = "ram_low", nullable = false)
	private Double ramLow;

	@Column(name = "ram_medium", nullable = false)
	private Double ramMedium;

	@Column(name = "ram_high", nullable = false)
	private Double ramHigh;

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

	public Double getRamLow() {
		return ramLow;
	}

	public void setRamLow(Double ramLow) {
		this.ramLow = ramLow;
	}

	public Double getRamMedium() {
		return ramMedium;
	}

	public void setRamMedium(Double ramMedium) {
		this.ramMedium = ramMedium;
	}

	public Double getRamHigh() {
		return ramHigh;
	}

	public void setRamHigh(Double ramHigh) {
		this.ramHigh = ramHigh;
	}

	public CPU getCpuLow() {
		return cpuLow;
	}

	public void setCpuLow(CPU cpuLow) {
		this.cpuLow = cpuLow;
	}

	public CPU getCpuMedium() {
		return cpuMedium;
	}

	public void setCpuMedium(CPU cpuMedium) {
		this.cpuMedium = cpuMedium;
	}

	public CPU getCpuHigh() {
		return cpuHigh;
	}

	public void setCpuHigh(CPU cpuHigh) {
		this.cpuHigh = cpuHigh;
	}

	public GPU getGpuLow() {
		return gpuLow;
	}

	public void setGpuLow(GPU gpuLow) {
		this.gpuLow = gpuLow;
	}

	public GPU getGpuMedium() {
		return gpuMedium;
	}

	public void setGpuMedium(GPU gpuMedium) {
		this.gpuMedium = gpuMedium;
	}

	public GPU getGpuHigh() {
		return gpuHigh;
	}

	public void setGpuHigh(GPU gpuHigh) {
		this.gpuHigh = gpuHigh;
	}

	public DirectX getDirectXMinimum() {
		return directXMinimum;
	}

	public void setDirectXMinimum(DirectX directXMinimum) {
		this.directXMinimum = directXMinimum;
	}

	public EsrbRatings getEsrbRating() {
		return esrbRating;
	}

	public void setEsrbRating(EsrbRatings esrbRating) {
		this.esrbRating = esrbRating;
	}

	public Set<CategoryOfGame> getCategoriesOfThisGame() {
		return categoriesOfThisGame;
	}

	public void setCategoriesOfThisGame(Set<CategoryOfGame> categoriesOfThisGame) {
		this.categoriesOfThisGame = categoriesOfThisGame;
	}

}
