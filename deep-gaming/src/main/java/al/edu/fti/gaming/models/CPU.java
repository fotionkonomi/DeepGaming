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
@Table(name = "cpu")
public class CPU extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6350914002623455349L;

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

	@Column(name = "cpu_benchmark", nullable = false)
	private Integer cpuBenchmark;

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

	@OneToMany(mappedBy = "cpuLow")
	private List<Game> gamesWhereThisCpuIsLow = new ArrayList<Game>();

	@OneToMany(mappedBy = "cpuMedium")
	private List<Game> gamesWhereThisCpuIsMedium = new ArrayList<Game>();

	@OneToMany(mappedBy = "cpuHigh")
	private List<Game> gamesWhereThisCpuIsHigh = new ArrayList<Game>();

	public CPU() {
		super();
	}

	public Double getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(Double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public Double getTurboSpeed() {
		return turboSpeed;
	}

	public void setTurboSpeed(Double turboSpeed) {
		this.turboSpeed = turboSpeed;
	}

	public Byte getPhysicalCores() {
		return physicalCores;
	}

	public void setPhysicalCores(Byte physicalCores) {
		this.physicalCores = physicalCores;
	}

	public Byte getThreads() {
		return threads;
	}

	public void setThreads(Byte threads) {
		this.threads = threads;
	}

	public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

	public Integer getBitWidth() {
		return bitWidth;
	}

	public void setBitWidth(Integer bitWidth) {
		this.bitWidth = bitWidth;
	}

	public Integer getL1Cache() {
		return l1Cache;
	}

	public void setL1Cache(Integer l1Cache) {
		this.l1Cache = l1Cache;
	}

	public Integer getL2Cache() {
		return l2Cache;
	}

	public void setL2Cache(Integer l2Cache) {
		this.l2Cache = l2Cache;
	}

	public Integer getL3Cache() {
		return l3Cache;
	}

	public void setL3Cache(Integer l3Cache) {
		this.l3Cache = l3Cache;
	}

	public Integer getCpuBenchmark() {
		return cpuBenchmark;
	}

	public void setCpuBenchmark(Integer cpuBenchmark) {
		this.cpuBenchmark = cpuBenchmark;
	}

	public CpuFamily getFamilyOfThisCpu() {
		return familyOfThisCpu;
	}

	public void setFamilyOfThisCpu(CpuFamily familyOfThisCpu) {
		this.familyOfThisCpu = familyOfThisCpu;
	}

	public CpuSocket getSocketForThisCpu() {
		return socketForThisCpu;
	}

	public void setSocketForThisCpu(CpuSocket socketForThisCpu) {
		this.socketForThisCpu = socketForThisCpu;
	}

	public CpuArchitecture getArchitectureOfThisCpu() {
		return architectureOfThisCpu;
	}

	public void setArchitectureOfThisCpu(CpuArchitecture architectureOfThisCpu) {
		this.architectureOfThisCpu = architectureOfThisCpu;
	}

	public GPU getIntegratedGpuOfThisCpu() {
		return integratedGpuOfThisCpu;
	}

	public void setIntegratedGpuOfThisCpu(GPU integratedGpuOfThisCpu) {
		this.integratedGpuOfThisCpu = integratedGpuOfThisCpu;
	}

	public List<GPU> getGpusThatRecommendThisCpu() {
		return gpusThatRecommendThisCpu;
	}

	public void setGpusThatRecommendThisCpu(List<GPU> gpusThatRecommendThisCpu) {
		this.gpusThatRecommendThisCpu = gpusThatRecommendThisCpu;
	}

	public List<User> getUsersThatHaveThisCpu() {
		return usersThatHaveThisCpu;
	}

	public void setUsersThatHaveThisCpu(List<User> usersThatHaveThisCpu) {
		this.usersThatHaveThisCpu = usersThatHaveThisCpu;
	}

	public List<Game> getGamesWhereThisCpuIsLow() {
		return gamesWhereThisCpuIsLow;
	}

	public void setGamesWhereThisCpuIsLow(List<Game> gamesWhereThisCpuIsLow) {
		this.gamesWhereThisCpuIsLow = gamesWhereThisCpuIsLow;
	}

	public List<Game> getGamesWhereThisCpuIsMedium() {
		return gamesWhereThisCpuIsMedium;
	}

	public void setGamesWhereThisCpuIsMedium(List<Game> gamesWhereThisCpuIsMedium) {
		this.gamesWhereThisCpuIsMedium = gamesWhereThisCpuIsMedium;
	}

	public List<Game> getGamesWhereThisCpuIsHigh() {
		return gamesWhereThisCpuIsHigh;
	}

	public void setGamesWhereThisCpuIsHigh(List<Game> gamesWhereThisCpuIsHigh) {
		this.gamesWhereThisCpuIsHigh = gamesWhereThisCpuIsHigh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((architectureOfThisCpu == null) ? 0 : architectureOfThisCpu.hashCode());
		result = prime * result + ((bitWidth == null) ? 0 : bitWidth.hashCode());
		result = prime * result + ((cpuBenchmark == null) ? 0 : cpuBenchmark.hashCode());
		result = prime * result + ((cpuSpeed == null) ? 0 : cpuSpeed.hashCode());
		result = prime * result + ((familyOfThisCpu == null) ? 0 : familyOfThisCpu.hashCode());
		result = prime * result + ((gamesWhereThisCpuIsHigh == null) ? 0 : gamesWhereThisCpuIsHigh.hashCode());
		result = prime * result + ((gamesWhereThisCpuIsLow == null) ? 0 : gamesWhereThisCpuIsLow.hashCode());
		result = prime * result + ((gamesWhereThisCpuIsMedium == null) ? 0 : gamesWhereThisCpuIsMedium.hashCode());
		result = prime * result + ((gpusThatRecommendThisCpu == null) ? 0 : gpusThatRecommendThisCpu.hashCode());
		result = prime * result + ((integratedGpuOfThisCpu == null) ? 0 : integratedGpuOfThisCpu.hashCode());
		result = prime * result + ((l1Cache == null) ? 0 : l1Cache.hashCode());
		result = prime * result + ((l2Cache == null) ? 0 : l2Cache.hashCode());
		result = prime * result + ((l3Cache == null) ? 0 : l3Cache.hashCode());
		result = prime * result + ((physicalCores == null) ? 0 : physicalCores.hashCode());
		result = prime * result + ((socketForThisCpu == null) ? 0 : socketForThisCpu.hashCode());
		result = prime * result + ((tdp == null) ? 0 : tdp.hashCode());
		result = prime * result + ((threads == null) ? 0 : threads.hashCode());
		result = prime * result + ((turboSpeed == null) ? 0 : turboSpeed.hashCode());
		result = prime * result + ((usersThatHaveThisCpu == null) ? 0 : usersThatHaveThisCpu.hashCode());
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
		CPU other = (CPU) obj;
		if (architectureOfThisCpu == null) {
			if (other.architectureOfThisCpu != null)
				return false;
		} else if (!architectureOfThisCpu.equals(other.architectureOfThisCpu))
			return false;
		if (bitWidth == null) {
			if (other.bitWidth != null)
				return false;
		} else if (!bitWidth.equals(other.bitWidth))
			return false;
		if (cpuBenchmark == null) {
			if (other.cpuBenchmark != null)
				return false;
		} else if (!cpuBenchmark.equals(other.cpuBenchmark))
			return false;
		if (cpuSpeed == null) {
			if (other.cpuSpeed != null)
				return false;
		} else if (!cpuSpeed.equals(other.cpuSpeed))
			return false;
		if (familyOfThisCpu == null) {
			if (other.familyOfThisCpu != null)
				return false;
		} else if (!familyOfThisCpu.equals(other.familyOfThisCpu))
			return false;
		if (gamesWhereThisCpuIsHigh == null) {
			if (other.gamesWhereThisCpuIsHigh != null)
				return false;
		} else if (!gamesWhereThisCpuIsHigh.equals(other.gamesWhereThisCpuIsHigh))
			return false;
		if (gamesWhereThisCpuIsLow == null) {
			if (other.gamesWhereThisCpuIsLow != null)
				return false;
		} else if (!gamesWhereThisCpuIsLow.equals(other.gamesWhereThisCpuIsLow))
			return false;
		if (gamesWhereThisCpuIsMedium == null) {
			if (other.gamesWhereThisCpuIsMedium != null)
				return false;
		} else if (!gamesWhereThisCpuIsMedium.equals(other.gamesWhereThisCpuIsMedium))
			return false;
		if (gpusThatRecommendThisCpu == null) {
			if (other.gpusThatRecommendThisCpu != null)
				return false;
		} else if (!gpusThatRecommendThisCpu.equals(other.gpusThatRecommendThisCpu))
			return false;
		if (integratedGpuOfThisCpu == null) {
			if (other.integratedGpuOfThisCpu != null)
				return false;
		} else if (!integratedGpuOfThisCpu.equals(other.integratedGpuOfThisCpu))
			return false;
		if (l1Cache == null) {
			if (other.l1Cache != null)
				return false;
		} else if (!l1Cache.equals(other.l1Cache))
			return false;
		if (l2Cache == null) {
			if (other.l2Cache != null)
				return false;
		} else if (!l2Cache.equals(other.l2Cache))
			return false;
		if (l3Cache == null) {
			if (other.l3Cache != null)
				return false;
		} else if (!l3Cache.equals(other.l3Cache))
			return false;
		if (physicalCores == null) {
			if (other.physicalCores != null)
				return false;
		} else if (!physicalCores.equals(other.physicalCores))
			return false;
		if (socketForThisCpu == null) {
			if (other.socketForThisCpu != null)
				return false;
		} else if (!socketForThisCpu.equals(other.socketForThisCpu))
			return false;
		if (tdp == null) {
			if (other.tdp != null)
				return false;
		} else if (!tdp.equals(other.tdp))
			return false;
		if (threads == null) {
			if (other.threads != null)
				return false;
		} else if (!threads.equals(other.threads))
			return false;
		if (turboSpeed == null) {
			if (other.turboSpeed != null)
				return false;
		} else if (!turboSpeed.equals(other.turboSpeed))
			return false;
		if (usersThatHaveThisCpu == null) {
			if (other.usersThatHaveThisCpu != null)
				return false;
		} else if (!usersThatHaveThisCpu.equals(other.usersThatHaveThisCpu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CPU [cpuSpeed=" + cpuSpeed + ", turboSpeed=" + turboSpeed + ", physicalCores=" + physicalCores
				+ ", threads=" + threads + ", tdp=" + tdp + ", bitWidth=" + bitWidth + ", l1Cache=" + l1Cache
				+ ", l2Cache=" + l2Cache + ", l3Cache=" + l3Cache + ", cpuBenchmark=" + cpuBenchmark
				+ ", familyOfThisCpu=" + familyOfThisCpu + ", socketForThisCpu=" + socketForThisCpu
				+ ", architectureOfThisCpu=" + architectureOfThisCpu + ", integratedGpuOfThisCpu="
				+ integratedGpuOfThisCpu + ", gpusThatRecommendThisCpu=" + gpusThatRecommendThisCpu
				+ ", usersThatHaveThisCpu=" + usersThatHaveThisCpu + ", gamesWhereThisCpuIsLow="
				+ gamesWhereThisCpuIsLow + ", gamesWhereThisCpuIsMedium=" + gamesWhereThisCpuIsMedium
				+ ", gamesWhereThisCpuIsHigh=" + gamesWhereThisCpuIsHigh + "]";
	}

}
