package al.edu.fti.gaming.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gpu")
public class GPU extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3142222506850335006L;

	@Column(name = "tmu", nullable = false)
	private Integer tmu;

	@Column(name = "texture_rate", nullable = false)
	private Integer textureRate;

	@Column(name = "rop", nullable = false)
	private Integer rop;

	@Column(name = "pixel_rate", nullable = false)
	private Integer pixelRate;

	@Column(name = "shader_processing_units", nullable = false)
	private Integer shaderProcessingUnits;

	@Column(name = "ray_tracing_cores")
	private Integer rayTracingCores;

	@Column(name = "tensor_cores")
	private Integer tensorCores;

	@Column(name = "driver_support", nullable = false)
	private Double driverSupport;

	@Column(name = "memory_size", nullable = false)
	private Integer memorySize;

	@Column(name = "memory_speed", nullable = false)
	private Integer memorySpeed;

	@Column(name = "memory_bus", nullable = false)
	private Integer memoryBus;

	@Column(name = "memory_bandwidth", nullable = false)
	private Integer memoryBandwidth;

	@Column(name = "cache", nullable = false)
	private Integer cache;

	@Column(name = "core_speed", nullable = false)
	private Integer coreSpeed;

	@Column(name = "boost_clock", nullable = false)
	private Integer boostClock;

	@Column(name = "tdp", nullable = false)
	private Integer tdp;

	@Column(name = "shader", nullable = false)
	private Double shader;

	@Column(name = "open_gl", nullable = false)
	private Double openGL;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_family", nullable = false)
	private GpuFamily familyOfThisGpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_architecture", nullable = false)
	private GpuArchitecture architectureOfThisGpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_memory_technology", nullable = false)
	private GpuMemoryTechnology memoryTechnologyOfThisGpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_direct_x", nullable = false)
	private DirectX maximumDirectXSupportedByThisGpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_slot", nullable = false)
	private GpuSlot gpuSlotOfThisGpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_recommended")
	private CPU cpuRecommendedForThisGpu;

	@OneToMany(mappedBy = "gpuOfHisComputer")
	private List<User> usersThatHaveThisGpu = new ArrayList<User>();

	@OneToMany(mappedBy = "gpuThatHasBeenTested")
	private List<GpuBenchmark> benchmarksOfThisGpu = new ArrayList<GpuBenchmark>();

	@OneToMany(mappedBy = "gpuLow")
	private List<Game> gamesWhereThisGpuIsLow = new ArrayList<Game>();

	@OneToMany(mappedBy = "gpuMedium")
	private List<Game> gamesWhereThisGpuIsMedium = new ArrayList<Game>();

	@OneToMany(mappedBy = "gpuHigh")
	private List<Game> gamesWhereThisGpuIsHigh = new ArrayList<Game>();

	public GPU() {
		super();
	}

	public Integer getTmu() {
		return tmu;
	}

	public void setTmu(Integer tmu) {
		this.tmu = tmu;
	}

	public Integer getTextureRate() {
		return textureRate;
	}

	public void setTextureRate(Integer textureRate) {
		this.textureRate = textureRate;
	}

	public Integer getRop() {
		return rop;
	}

	public void setRop(Integer rop) {
		this.rop = rop;
	}

	public Integer getPixelRate() {
		return pixelRate;
	}

	public void setPixelRate(Integer pixelRate) {
		this.pixelRate = pixelRate;
	}

	public Integer getShaderProcessingUnits() {
		return shaderProcessingUnits;
	}

	public void setShaderProcessingUnits(Integer shaderProcessingUnits) {
		this.shaderProcessingUnits = shaderProcessingUnits;
	}

	public Integer getRayTracingCores() {
		return rayTracingCores;
	}

	public void setRayTracingCores(Integer rayTracingCores) {
		this.rayTracingCores = rayTracingCores;
	}

	public Integer getTensorCores() {
		return tensorCores;
	}

	public void setTensorCores(Integer tensorCores) {
		this.tensorCores = tensorCores;
	}

	public Double getDriverSupport() {
		return driverSupport;
	}

	public void setDriverSupport(Double driverSupport) {
		this.driverSupport = driverSupport;
	}

	public Integer getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}

	public Integer getMemorySpeed() {
		return memorySpeed;
	}

	public void setMemorySpeed(Integer memorySpeed) {
		this.memorySpeed = memorySpeed;
	}

	public Integer getMemoryBus() {
		return memoryBus;
	}

	public void setMemoryBus(Integer memoryBus) {
		this.memoryBus = memoryBus;
	}

	public Integer getMemoryBandwidth() {
		return memoryBandwidth;
	}

	public void setMemoryBandwidth(Integer memoryBandwidth) {
		this.memoryBandwidth = memoryBandwidth;
	}

	public Integer getCache() {
		return cache;
	}

	public void setCache(Integer cache) {
		this.cache = cache;
	}

	public Integer getCoreSpeed() {
		return coreSpeed;
	}

	public void setCoreSpeed(Integer coreSpeed) {
		this.coreSpeed = coreSpeed;
	}

	public Integer getBoostClock() {
		return boostClock;
	}

	public void setBoostClock(Integer boostClock) {
		this.boostClock = boostClock;
	}

	public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

	public Double getShader() {
		return shader;
	}

	public void setShader(Double shader) {
		this.shader = shader;
	}

	public Double getOpenGL() {
		return openGL;
	}

	public void setOpenGL(Double openGL) {
		this.openGL = openGL;
	}

	public GpuFamily getFamilyOfThisGpu() {
		return familyOfThisGpu;
	}

	public void setFamilyOfThisGpu(GpuFamily familyOfThisGpu) {
		this.familyOfThisGpu = familyOfThisGpu;
	}

	public GpuArchitecture getArchitectureOfThisGpu() {
		return architectureOfThisGpu;
	}

	public void setArchitectureOfThisGpu(GpuArchitecture architectureOfThisGpu) {
		this.architectureOfThisGpu = architectureOfThisGpu;
	}

	public GpuMemoryTechnology getMemoryTechnologyOfThisGpu() {
		return memoryTechnologyOfThisGpu;
	}

	public void setMemoryTechnologyOfThisGpu(GpuMemoryTechnology memoryTechnologyOfThisGpu) {
		this.memoryTechnologyOfThisGpu = memoryTechnologyOfThisGpu;
	}

	public DirectX getMaximumDirectXSupportedByThisGpu() {
		return maximumDirectXSupportedByThisGpu;
	}

	public void setMaximumDirectXSupportedByThisGpu(DirectX maximumDirectXSupportedByThisGpu) {
		this.maximumDirectXSupportedByThisGpu = maximumDirectXSupportedByThisGpu;
	}

	public GpuSlot getGpuSlotOfThisGpu() {
		return gpuSlotOfThisGpu;
	}

	public void setGpuSlotOfThisGpu(GpuSlot gpuSlotOfThisGpu) {
		this.gpuSlotOfThisGpu = gpuSlotOfThisGpu;
	}

	public CPU getCpuRecommendedForThisGpu() {
		return cpuRecommendedForThisGpu;
	}

	public void setCpuRecommendedForThisGpu(CPU cpuRecommendedForThisGpu) {
		this.cpuRecommendedForThisGpu = cpuRecommendedForThisGpu;
	}

	public List<User> getUsersThatHaveThisGpu() {
		return usersThatHaveThisGpu;
	}

	public void setUsersThatHaveThisGpu(List<User> usersThatHaveThisGpu) {
		this.usersThatHaveThisGpu = usersThatHaveThisGpu;
	}

	public List<GpuBenchmark> getBenchmarksOfThisGpu() {
		return benchmarksOfThisGpu;
	}

	public void setBenchmarksOfThisGpu(List<GpuBenchmark> benchmarksOfThisGpu) {
		this.benchmarksOfThisGpu = benchmarksOfThisGpu;
	}

	public List<Game> getGamesWhereThisGpuIsLow() {
		return gamesWhereThisGpuIsLow;
	}

	public void setGamesWhereThisGpuIsLow(List<Game> gamesWhereThisGpuIsLow) {
		this.gamesWhereThisGpuIsLow = gamesWhereThisGpuIsLow;
	}

	public List<Game> getGamesWhereThisGpuIsMedium() {
		return gamesWhereThisGpuIsMedium;
	}

	public void setGamesWhereThisGpuIsMedium(List<Game> gamesWhereThisGpuIsMedium) {
		this.gamesWhereThisGpuIsMedium = gamesWhereThisGpuIsMedium;
	}

	public List<Game> getGamesWhereThisGpuIsHigh() {
		return gamesWhereThisGpuIsHigh;
	}

	public void setGamesWhereThisGpuIsHigh(List<Game> gamesWhereThisGpuIsHigh) {
		this.gamesWhereThisGpuIsHigh = gamesWhereThisGpuIsHigh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((architectureOfThisGpu == null) ? 0 : architectureOfThisGpu.hashCode());
		result = prime * result + ((benchmarksOfThisGpu == null) ? 0 : benchmarksOfThisGpu.hashCode());
		result = prime * result + ((boostClock == null) ? 0 : boostClock.hashCode());
		result = prime * result + ((cache == null) ? 0 : cache.hashCode());
		result = prime * result + ((coreSpeed == null) ? 0 : coreSpeed.hashCode());
		result = prime * result + ((cpuRecommendedForThisGpu == null) ? 0 : cpuRecommendedForThisGpu.hashCode());
		result = prime * result + ((driverSupport == null) ? 0 : driverSupport.hashCode());
		result = prime * result + ((familyOfThisGpu == null) ? 0 : familyOfThisGpu.hashCode());
		result = prime * result + ((gamesWhereThisGpuIsHigh == null) ? 0 : gamesWhereThisGpuIsHigh.hashCode());
		result = prime * result + ((gamesWhereThisGpuIsLow == null) ? 0 : gamesWhereThisGpuIsLow.hashCode());
		result = prime * result + ((gamesWhereThisGpuIsMedium == null) ? 0 : gamesWhereThisGpuIsMedium.hashCode());
		result = prime * result + ((gpuSlotOfThisGpu == null) ? 0 : gpuSlotOfThisGpu.hashCode());
		result = prime * result
				+ ((maximumDirectXSupportedByThisGpu == null) ? 0 : maximumDirectXSupportedByThisGpu.hashCode());
		result = prime * result + ((memoryBandwidth == null) ? 0 : memoryBandwidth.hashCode());
		result = prime * result + ((memoryBus == null) ? 0 : memoryBus.hashCode());
		result = prime * result + ((memorySize == null) ? 0 : memorySize.hashCode());
		result = prime * result + ((memorySpeed == null) ? 0 : memorySpeed.hashCode());
		result = prime * result + ((memoryTechnologyOfThisGpu == null) ? 0 : memoryTechnologyOfThisGpu.hashCode());
		result = prime * result + ((openGL == null) ? 0 : openGL.hashCode());
		result = prime * result + ((pixelRate == null) ? 0 : pixelRate.hashCode());
		result = prime * result + ((rayTracingCores == null) ? 0 : rayTracingCores.hashCode());
		result = prime * result + ((rop == null) ? 0 : rop.hashCode());
		result = prime * result + ((shader == null) ? 0 : shader.hashCode());
		result = prime * result + ((shaderProcessingUnits == null) ? 0 : shaderProcessingUnits.hashCode());
		result = prime * result + ((tdp == null) ? 0 : tdp.hashCode());
		result = prime * result + ((tensorCores == null) ? 0 : tensorCores.hashCode());
		result = prime * result + ((textureRate == null) ? 0 : textureRate.hashCode());
		result = prime * result + ((tmu == null) ? 0 : tmu.hashCode());
		result = prime * result + ((usersThatHaveThisGpu == null) ? 0 : usersThatHaveThisGpu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GPU other = (GPU) obj;
		if (architectureOfThisGpu == null) {
			if (other.architectureOfThisGpu != null)
				return false;
		} else if (!architectureOfThisGpu.equals(other.architectureOfThisGpu))
			return false;
		if (benchmarksOfThisGpu == null) {
			if (other.benchmarksOfThisGpu != null)
				return false;
		} else if (!benchmarksOfThisGpu.equals(other.benchmarksOfThisGpu))
			return false;
		if (boostClock == null) {
			if (other.boostClock != null)
				return false;
		} else if (!boostClock.equals(other.boostClock))
			return false;
		if (cache == null) {
			if (other.cache != null)
				return false;
		} else if (!cache.equals(other.cache))
			return false;
		if (coreSpeed == null) {
			if (other.coreSpeed != null)
				return false;
		} else if (!coreSpeed.equals(other.coreSpeed))
			return false;
		if (cpuRecommendedForThisGpu == null) {
			if (other.cpuRecommendedForThisGpu != null)
				return false;
		} else if (!cpuRecommendedForThisGpu.equals(other.cpuRecommendedForThisGpu))
			return false;
		if (driverSupport == null) {
			if (other.driverSupport != null)
				return false;
		} else if (!driverSupport.equals(other.driverSupport))
			return false;
		if (familyOfThisGpu == null) {
			if (other.familyOfThisGpu != null)
				return false;
		} else if (!familyOfThisGpu.equals(other.familyOfThisGpu))
			return false;
		if (gamesWhereThisGpuIsHigh == null) {
			if (other.gamesWhereThisGpuIsHigh != null)
				return false;
		} else if (!gamesWhereThisGpuIsHigh.equals(other.gamesWhereThisGpuIsHigh))
			return false;
		if (gamesWhereThisGpuIsLow == null) {
			if (other.gamesWhereThisGpuIsLow != null)
				return false;
		} else if (!gamesWhereThisGpuIsLow.equals(other.gamesWhereThisGpuIsLow))
			return false;
		if (gamesWhereThisGpuIsMedium == null) {
			if (other.gamesWhereThisGpuIsMedium != null)
				return false;
		} else if (!gamesWhereThisGpuIsMedium.equals(other.gamesWhereThisGpuIsMedium))
			return false;
		if (gpuSlotOfThisGpu == null) {
			if (other.gpuSlotOfThisGpu != null)
				return false;
		} else if (!gpuSlotOfThisGpu.equals(other.gpuSlotOfThisGpu))
			return false;
		if (maximumDirectXSupportedByThisGpu == null) {
			if (other.maximumDirectXSupportedByThisGpu != null)
				return false;
		} else if (!maximumDirectXSupportedByThisGpu.equals(other.maximumDirectXSupportedByThisGpu))
			return false;
		if (memoryBandwidth == null) {
			if (other.memoryBandwidth != null)
				return false;
		} else if (!memoryBandwidth.equals(other.memoryBandwidth))
			return false;
		if (memoryBus == null) {
			if (other.memoryBus != null)
				return false;
		} else if (!memoryBus.equals(other.memoryBus))
			return false;
		if (memorySize == null) {
			if (other.memorySize != null)
				return false;
		} else if (!memorySize.equals(other.memorySize))
			return false;
		if (memorySpeed == null) {
			if (other.memorySpeed != null)
				return false;
		} else if (!memorySpeed.equals(other.memorySpeed))
			return false;
		if (memoryTechnologyOfThisGpu == null) {
			if (other.memoryTechnologyOfThisGpu != null)
				return false;
		} else if (!memoryTechnologyOfThisGpu.equals(other.memoryTechnologyOfThisGpu))
			return false;
		if (openGL == null) {
			if (other.openGL != null)
				return false;
		} else if (!openGL.equals(other.openGL))
			return false;
		if (pixelRate == null) {
			if (other.pixelRate != null)
				return false;
		} else if (!pixelRate.equals(other.pixelRate))
			return false;
		if (rayTracingCores == null) {
			if (other.rayTracingCores != null)
				return false;
		} else if (!rayTracingCores.equals(other.rayTracingCores))
			return false;
		if (rop == null) {
			if (other.rop != null)
				return false;
		} else if (!rop.equals(other.rop))
			return false;
		if (shader == null) {
			if (other.shader != null)
				return false;
		} else if (!shader.equals(other.shader))
			return false;
		if (shaderProcessingUnits == null) {
			if (other.shaderProcessingUnits != null)
				return false;
		} else if (!shaderProcessingUnits.equals(other.shaderProcessingUnits))
			return false;
		if (tdp == null) {
			if (other.tdp != null)
				return false;
		} else if (!tdp.equals(other.tdp))
			return false;
		if (tensorCores == null) {
			if (other.tensorCores != null)
				return false;
		} else if (!tensorCores.equals(other.tensorCores))
			return false;
		if (textureRate == null) {
			if (other.textureRate != null)
				return false;
		} else if (!textureRate.equals(other.textureRate))
			return false;
		if (tmu == null) {
			if (other.tmu != null)
				return false;
		} else if (!tmu.equals(other.tmu))
			return false;
		if (usersThatHaveThisGpu == null) {
			if (other.usersThatHaveThisGpu != null)
				return false;
		} else if (!usersThatHaveThisGpu.equals(other.usersThatHaveThisGpu))
			return false;
		return true;
	}

}
