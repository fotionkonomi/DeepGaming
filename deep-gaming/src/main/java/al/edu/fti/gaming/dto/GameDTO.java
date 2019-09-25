package al.edu.fti.gaming.dto;

import java.io.Serializable;
import java.util.Set;

public class GameDTO extends ProductDTO implements IDto, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9205214149864597479L;

	private Double ramLow;

	private Double ramMedium;

	private Double ramHigh;

	private CpuDTO cpuLow;

	private CpuDTO cpuMedium;

	private CpuDTO cpuHigh;

	private GpuDTO gpuLow;

	private GpuDTO gpuMedium;

	private GpuDTO gpuHigh;

	private DirectXDTO directXMinimum;

	private EsrbRatingsDTO esrbRating;

	private Set<CategoryOfGameDTO> categoryOfGames;
	
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

	public CpuDTO getCpuLow() {
		return cpuLow;
	}

	public void setCpuLow(CpuDTO cpuLow) {
		this.cpuLow = cpuLow;
	}

	public CpuDTO getCpuMedium() {
		return cpuMedium;
	}

	public void setCpuMedium(CpuDTO cpuMedium) {
		this.cpuMedium = cpuMedium;
	}

	public CpuDTO getCpuHigh() {
		return cpuHigh;
	}

	public void setCpuHigh(CpuDTO cpuHigh) {
		this.cpuHigh = cpuHigh;
	}

	public GpuDTO getGpuLow() {
		return gpuLow;
	}

	public void setGpuLow(GpuDTO gpuLow) {
		this.gpuLow = gpuLow;
	}

	public GpuDTO getGpuMedium() {
		return gpuMedium;
	}

	public void setGpuMedium(GpuDTO gpuMedium) {
		this.gpuMedium = gpuMedium;
	}

	public GpuDTO getGpuHigh() {
		return gpuHigh;
	}

	public void setGpuHigh(GpuDTO gpuHigh) {
		this.gpuHigh = gpuHigh;
	}

	public DirectXDTO getDirectXMinimum() {
		return directXMinimum;
	}

	public void setDirectXMinimum(DirectXDTO directXMinimum) {
		this.directXMinimum = directXMinimum;
	}

	public EsrbRatingsDTO getEsrbRating() {
		return esrbRating;
	}

	public void setEsrbRating(EsrbRatingsDTO esrbRating) {
		this.esrbRating = esrbRating;
	}

	public Set<CategoryOfGameDTO> getCategoryOfGames() {
		return categoryOfGames;
	}

	public void setCategoryOfGames(Set<CategoryOfGameDTO> categoryOfGames) {
		this.categoryOfGames = categoryOfGames;
	}

}
