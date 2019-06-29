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
@Table(name = "gpu_benchmark_type")
public class GpuBenchmarkType implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8094059459043421862L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_benchmark_type", nullable = false)
	private Integer idGpuBenchmarkType;

	@Column(name = "gpu_benchmark_type_name", unique = true, nullable = false, length = 50)
	private String gpuBenchmarkTypeName;

	@Column(name = "gpu_benchmark_type_description", nullable = false, length = 65535)
	private String gpuBenchmarkTypeDescription;

	@OneToMany(mappedBy = "typeOfBenchmark")
	private List<GpuBenchmark> benchmarksOfThisBenchmarkType = new ArrayList<GpuBenchmark>();

	public GpuBenchmarkType() {

	}

	public GpuBenchmarkType(Integer idGpuBenchmarkType, String gpuBenchmarkTypeName, String gpuBenchmarkTypeDescription,
			List<GpuBenchmark> benchmarksOfThisBenchmarkType) {
		super();
		this.idGpuBenchmarkType = idGpuBenchmarkType;
		this.gpuBenchmarkTypeName = gpuBenchmarkTypeName;
		this.gpuBenchmarkTypeDescription = gpuBenchmarkTypeDescription;
		this.benchmarksOfThisBenchmarkType = benchmarksOfThisBenchmarkType;
	}

	public Integer getIdGpuBenchmarkType() {
		return idGpuBenchmarkType;
	}

	public void setIdGpuBenchmarkType(Integer idGpuBenchmarkType) {
		this.idGpuBenchmarkType = idGpuBenchmarkType;
	}

	public String getGpuBenchmarkTypeName() {
		return gpuBenchmarkTypeName;
	}

	public void setGpuBenchmarkTypeName(String gpuBenchmarkTypeName) {
		this.gpuBenchmarkTypeName = gpuBenchmarkTypeName;
	}

	public String getGpuBenchmarkTypeDescription() {
		return gpuBenchmarkTypeDescription;
	}

	public void setGpuBenchmarkTypeDescription(String gpuBenchmarkTypeDescription) {
		this.gpuBenchmarkTypeDescription = gpuBenchmarkTypeDescription;
	}

	public List<GpuBenchmark> getBenchmarksOfThisBenchmarkType() {
		return benchmarksOfThisBenchmarkType;
	}

	public void setBenchmarksOfThisBenchmarkType(List<GpuBenchmark> benchmarksOfThisBenchmarkType) {
		this.benchmarksOfThisBenchmarkType = benchmarksOfThisBenchmarkType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((benchmarksOfThisBenchmarkType == null) ? 0 : benchmarksOfThisBenchmarkType.hashCode());
		result = prime * result + ((gpuBenchmarkTypeDescription == null) ? 0 : gpuBenchmarkTypeDescription.hashCode());
		result = prime * result + ((gpuBenchmarkTypeName == null) ? 0 : gpuBenchmarkTypeName.hashCode());
		result = prime * result + ((idGpuBenchmarkType == null) ? 0 : idGpuBenchmarkType.hashCode());
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
		GpuBenchmarkType other = (GpuBenchmarkType) obj;
		if (benchmarksOfThisBenchmarkType == null) {
			if (other.benchmarksOfThisBenchmarkType != null)
				return false;
		} else if (!benchmarksOfThisBenchmarkType.equals(other.benchmarksOfThisBenchmarkType))
			return false;
		if (gpuBenchmarkTypeDescription == null) {
			if (other.gpuBenchmarkTypeDescription != null)
				return false;
		} else if (!gpuBenchmarkTypeDescription.equals(other.gpuBenchmarkTypeDescription))
			return false;
		if (gpuBenchmarkTypeName == null) {
			if (other.gpuBenchmarkTypeName != null)
				return false;
		} else if (!gpuBenchmarkTypeName.equals(other.gpuBenchmarkTypeName))
			return false;
		if (idGpuBenchmarkType == null) {
			if (other.idGpuBenchmarkType != null)
				return false;
		} else if (!idGpuBenchmarkType.equals(other.idGpuBenchmarkType))
			return false;
		return true;
	}

}
