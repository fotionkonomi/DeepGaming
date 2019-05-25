package al.edu.fti.deep_gaming.models;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cpu")
public class CPU extends Product {

	@Column(name = "cpu_speed", nullable = false)
	private Double cpuSpeed;

	@Column(name = "turbo_speed", nullable = false)
	private Double turboSpeed;

	@Column(name = "physical_cores", nullable = false)
	private Byte physicalCores;

	@Column(name = "threads", nullable = false)
	private Byte threads;

	@Column(name = "tdp", nullable = false)
	private Integer tdp;

	@Column(name = "bit_width", nullable = false)
	private Integer bitWidth;

	@Column(name = "l1_cache", nullable = false)
	private Integer l1Cache;

	@Column(name = "l2_cache", nullable = false)
	private Integer l2Cache;

	@Column(name = "l3_cache", nullable = false)
	private Integer l3Cache;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_family", nullable = false)
	private CpuFamily familyOfThisCpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_socket", nullable = false)
	private CpuSocket socketForThisCpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_architecture", nullable = false)
	private CpuArchitecture architectureOfThisCpu;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_integrated_gpu")
	private GPU integratedGpuOfThisCpu;

	@OneToMany(mappedBy = "cpuRecommendedForThisGpu")
	private List<GPU> gpusThatRecommendThisCpu = new ArrayList<GPU>();

	@OneToMany(mappedBy = "cpuOfHisComputer")
	private List<User> usersThatHaveThisCpu = new ArrayList<User>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "cpu_chipset", joinColumns = { @JoinColumn(name = "id_cpu") }, inverseJoinColumns = {
			@JoinColumn(name = "id_chipset") })
	private Set<Chipset> chipsetsThatSupportThisCpu = new HashSet<Chipset>();

	@OneToMany(mappedBy = "cpuThatHasBeenTested")
	private List<CpuBenchmark> benchmarksOfThisCpu = new ArrayList<CpuBenchmark>();
}
