package al.edu.fti.deep_gaming.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gpu_benchmark_type")
public class GpuBenchmarkType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_benchmark_type", nullable = false)
	private Integer idGpuBenchmarkType;

	@Column(name = "gpu_benchmark_type_name", nullable = false, length = 50)
	private String gpuBenchmarkTypeName;

	@Column(name = "gpu_benchmark_type_description", nullable = false, length = 65535)
	private String gpuBenchmarkTypeDescription;

}
