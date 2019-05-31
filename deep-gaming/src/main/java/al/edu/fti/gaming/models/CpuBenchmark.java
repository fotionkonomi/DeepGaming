package al.edu.fti.gaming.models;

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
@Table(name = "cpu_benchmark")
public class CpuBenchmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_benchmark", nullable = false)
	private Integer idCpuBenchmark;

	@Column(name = "value", nullable = false)
	private Integer value;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu", nullable = false)
	private CPU cpuThatHasBeenTested;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_benchmark_type", nullable = false)
	private CpuBenchmarkType typeOfBenchmark;

	public CpuBenchmark(Integer idCpuBenchmark, Integer value, CPU cpuThatHasBeenTested,
			CpuBenchmarkType typeOfBenchmark) {
		super();
		this.idCpuBenchmark = idCpuBenchmark;
		this.value = value;
		this.cpuThatHasBeenTested = cpuThatHasBeenTested;
		this.typeOfBenchmark = typeOfBenchmark;
	}

	public CpuBenchmark() {

	}

	public Integer getIdCpuBenchmark() {
		return idCpuBenchmark;
	}

	public void setIdCpuBenchmark(Integer idCpuBenchmark) {
		this.idCpuBenchmark = idCpuBenchmark;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public CPU getCpuThatHasBeenTested() {
		return cpuThatHasBeenTested;
	}

	public void setCpuThatHasBeenTested(CPU cpuThatHasBeenTested) {
		this.cpuThatHasBeenTested = cpuThatHasBeenTested;
	}

	public CpuBenchmarkType getTypeOfBenchmark() {
		return typeOfBenchmark;
	}

	public void setTypeOfBenchmark(CpuBenchmarkType typeOfBenchmark) {
		this.typeOfBenchmark = typeOfBenchmark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuThatHasBeenTested == null) ? 0 : cpuThatHasBeenTested.hashCode());
		result = prime * result + ((idCpuBenchmark == null) ? 0 : idCpuBenchmark.hashCode());
		result = prime * result + ((typeOfBenchmark == null) ? 0 : typeOfBenchmark.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		CpuBenchmark other = (CpuBenchmark) obj;
		if (cpuThatHasBeenTested == null) {
			if (other.cpuThatHasBeenTested != null)
				return false;
		} else if (!cpuThatHasBeenTested.equals(other.cpuThatHasBeenTested))
			return false;
		if (idCpuBenchmark == null) {
			if (other.idCpuBenchmark != null)
				return false;
		} else if (!idCpuBenchmark.equals(other.idCpuBenchmark))
			return false;
		if (typeOfBenchmark == null) {
			if (other.typeOfBenchmark != null)
				return false;
		} else if (!typeOfBenchmark.equals(other.typeOfBenchmark))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
