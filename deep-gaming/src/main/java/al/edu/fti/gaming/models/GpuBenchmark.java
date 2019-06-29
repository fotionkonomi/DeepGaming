package al.edu.fti.gaming.models;

import java.io.Serializable;

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
@Table(name = "gpu_benchmark")
public class GpuBenchmark implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6192788256506868854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_benchmark", nullable = false)
	private Integer gpuBenchmark;

	@Column(name = "value", nullable = false)
	private Integer value;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu", nullable = false)
	private GPU gpuThatHasBeenTested;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_benchmark_type", nullable = false)
	private GpuBenchmarkType typeOfBenchmark;

	public GpuBenchmark() {
		super();
	}

	public GpuBenchmark(Integer gpuBenchmark, Integer value, GPU gpuThatHasBeenTested,
			GpuBenchmarkType typeOfBenchmark) {
		super();
		this.gpuBenchmark = gpuBenchmark;
		this.value = value;
		this.gpuThatHasBeenTested = gpuThatHasBeenTested;
		this.typeOfBenchmark = typeOfBenchmark;
	}

	public Integer getGpuBenchmark() {
		return gpuBenchmark;
	}

	public void setGpuBenchmark(Integer gpuBenchmark) {
		this.gpuBenchmark = gpuBenchmark;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public GPU getGpuThatHasBeenTested() {
		return gpuThatHasBeenTested;
	}

	public void setGpuThatHasBeenTested(GPU gpuThatHasBeenTested) {
		this.gpuThatHasBeenTested = gpuThatHasBeenTested;
	}

	public GpuBenchmarkType getTypeOfBenchmark() {
		return typeOfBenchmark;
	}

	public void setTypeOfBenchmark(GpuBenchmarkType typeOfBenchmark) {
		this.typeOfBenchmark = typeOfBenchmark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gpuBenchmark == null) ? 0 : gpuBenchmark.hashCode());
		result = prime * result + ((gpuThatHasBeenTested == null) ? 0 : gpuThatHasBeenTested.hashCode());
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
		GpuBenchmark other = (GpuBenchmark) obj;
		if (gpuBenchmark == null) {
			if (other.gpuBenchmark != null)
				return false;
		} else if (!gpuBenchmark.equals(other.gpuBenchmark))
			return false;
		if (gpuThatHasBeenTested == null) {
			if (other.gpuThatHasBeenTested != null)
				return false;
		} else if (!gpuThatHasBeenTested.equals(other.gpuThatHasBeenTested))
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
