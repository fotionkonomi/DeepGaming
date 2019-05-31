package al.edu.fti.gaming.dto;

public class GpuBenchmarkDTO {

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

}
