package al.edu.fti.gaming.dto;

public class GpuBenchmarkDTO implements IDto{

	private Integer idGpuBenchmark;

	private Integer value;

	private GpuDTO gpuThatHasBeenTested;

	private GpuBenchmarkTypeDTO typeOfBenchmark;

	public GpuBenchmarkDTO() {
		super();
	}

	public Integer getIdGpuBenchmark() {
		return idGpuBenchmark;
	}

	public void setIdGpuBenchmark(Integer idGpuBenchmark) {
		this.idGpuBenchmark = idGpuBenchmark;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public GpuDTO getGpuThatHasBeenTested() {
		return gpuThatHasBeenTested;
	}

	public void setGpuThatHasBeenTested(GpuDTO gpuThatHasBeenTested) {
		this.gpuThatHasBeenTested = gpuThatHasBeenTested;
	}

	public GpuBenchmarkTypeDTO getTypeOfBenchmark() {
		return typeOfBenchmark;
	}

	public void setTypeOfBenchmark(GpuBenchmarkTypeDTO typeOfBenchmark) {
		this.typeOfBenchmark = typeOfBenchmark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gpuThatHasBeenTested == null) ? 0 : gpuThatHasBeenTested.hashCode());
		result = prime * result + ((idGpuBenchmark == null) ? 0 : idGpuBenchmark.hashCode());
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
		GpuBenchmarkDTO other = (GpuBenchmarkDTO) obj;
		if (gpuThatHasBeenTested == null) {
			if (other.gpuThatHasBeenTested != null)
				return false;
		} else if (!gpuThatHasBeenTested.equals(other.gpuThatHasBeenTested))
			return false;
		if (idGpuBenchmark == null) {
			if (other.idGpuBenchmark != null)
				return false;
		} else if (!idGpuBenchmark.equals(other.idGpuBenchmark))
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
