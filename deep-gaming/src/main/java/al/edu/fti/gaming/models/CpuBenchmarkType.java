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
@Table(name = "cpu_benchmark_type")
/**
 * This class is mapped to the cpu_benchmark_type table in the database which
 * contains information regarding different types of benchmarks for CPUs
 * 
 * @author kfotj
 *
 */
public class CpuBenchmarkType implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6656834983499564352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_benchmark_type", nullable = false)
	/**
	 * This variable is mapped to the primary key of "cpu_benchmark_type" table in
	 * the database
	 */
	private Integer idCpuBenchmarkType;

	@Column(name = "cpu_benchmark_type_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "cpu_benchmark_type_name" field in the
	 * "cpu_benchmark_type" table in the database which contains information
	 * regarding the names different types of CPU benchmarks
	 */
	private String cpuBenchmarkTypeName;

	@Column(name = "cpu_benchmark_type_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "cpu_benchmark_type_description" field in the
	 * "cpu_benchmark_type" table in the database which contains generic information
	 * regarding different types of CPU benchmarks
	 */
	private String cpuBenchmarkTypeDescription;

	@OneToMany(mappedBy = "typeOfBenchmark")
	private List<CpuBenchmark> benchmarksOfThisBenchmarkType = new ArrayList<CpuBenchmark>();

	public CpuBenchmarkType(Integer idCpuBenchmarkType, String cpuBenchmarkTypeName, String cpuBenchmarkTypeDescription,
			List<CpuBenchmark> benchmarksOfThisBenchmarkType) {
		super();
		this.idCpuBenchmarkType = idCpuBenchmarkType;
		this.cpuBenchmarkTypeName = cpuBenchmarkTypeName;
		this.cpuBenchmarkTypeDescription = cpuBenchmarkTypeDescription;
		this.benchmarksOfThisBenchmarkType = benchmarksOfThisBenchmarkType;
	}

	public CpuBenchmarkType() {

	}

	public Integer getIdCpuBenchmarkType() {
		return idCpuBenchmarkType;
	}

	public void setIdCpuBenchmarkType(Integer idCpuBenchmarkType) {
		this.idCpuBenchmarkType = idCpuBenchmarkType;
	}

	public String getCpuBenchmarkTypeName() {
		return cpuBenchmarkTypeName;
	}

	public void setCpuBenchmarkTypeName(String cpuBenchmarkTypeName) {
		this.cpuBenchmarkTypeName = cpuBenchmarkTypeName;
	}

	public String getCpuBenchmarkTypeDescription() {
		return cpuBenchmarkTypeDescription;
	}

	public void setCpuBenchmarkTypeDescription(String cpuBenchmarkTypeDescription) {
		this.cpuBenchmarkTypeDescription = cpuBenchmarkTypeDescription;
	}

	public List<CpuBenchmark> getBenchmarksOfThisBenchmarkType() {
		return benchmarksOfThisBenchmarkType;
	}

	public void setBenchmarksOfThisBenchmarkType(List<CpuBenchmark> benchmarksOfThisBenchmarkType) {
		this.benchmarksOfThisBenchmarkType = benchmarksOfThisBenchmarkType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((benchmarksOfThisBenchmarkType == null) ? 0 : benchmarksOfThisBenchmarkType.hashCode());
		result = prime * result + ((cpuBenchmarkTypeDescription == null) ? 0 : cpuBenchmarkTypeDescription.hashCode());
		result = prime * result + ((cpuBenchmarkTypeName == null) ? 0 : cpuBenchmarkTypeName.hashCode());
		result = prime * result + ((idCpuBenchmarkType == null) ? 0 : idCpuBenchmarkType.hashCode());
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
		CpuBenchmarkType other = (CpuBenchmarkType) obj;
		if (benchmarksOfThisBenchmarkType == null) {
			if (other.benchmarksOfThisBenchmarkType != null)
				return false;
		} else if (!benchmarksOfThisBenchmarkType.equals(other.benchmarksOfThisBenchmarkType))
			return false;
		if (cpuBenchmarkTypeDescription == null) {
			if (other.cpuBenchmarkTypeDescription != null)
				return false;
		} else if (!cpuBenchmarkTypeDescription.equals(other.cpuBenchmarkTypeDescription))
			return false;
		if (cpuBenchmarkTypeName == null) {
			if (other.cpuBenchmarkTypeName != null)
				return false;
		} else if (!cpuBenchmarkTypeName.equals(other.cpuBenchmarkTypeName))
			return false;
		if (idCpuBenchmarkType == null) {
			if (other.idCpuBenchmarkType != null)
				return false;
		} else if (!idCpuBenchmarkType.equals(other.idCpuBenchmarkType))
			return false;
		return true;
	}

}
