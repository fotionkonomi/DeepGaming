package al.edu.fti.gaming.dto;

public class CpuBenchmarkDTO implements IDto {

	private Integer idCpuBenchmark;

	private Integer value;

	private CpuDTO cpuThatHasBeenTested;

	private CpuBenchmarkTypeDTO typeOfBenchmark;

	public CpuBenchmarkDTO() {
		super();
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

	public CpuDTO getCpuThatHasBeenTested() {
		return cpuThatHasBeenTested;
	}

	public void setCpuThatHasBeenTested(CpuDTO cpuThatHasBeenTested) {
		this.cpuThatHasBeenTested = cpuThatHasBeenTested;
	}

	public CpuBenchmarkTypeDTO getTypeOfBenchmark() {
		return typeOfBenchmark;
	}

	public void setTypeOfBenchmark(CpuBenchmarkTypeDTO typeOfBenchmark) {
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
		CpuBenchmarkDTO other = (CpuBenchmarkDTO) obj;
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
