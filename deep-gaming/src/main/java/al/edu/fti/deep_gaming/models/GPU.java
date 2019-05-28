package al.edu.fti.deep_gaming.models;

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
	
}
