package al.edu.fti.deep_gaming.models;

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
public class GpuBenchmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gpu_benchmark", nullable = false)
	private Integer gpuBenchmark;

	@Column(name = "value", nullable = false)
	private Integer value;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu", nullable = false)
	private GPU gpuThatHasBeenTested;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_benchmark_type", nullable = false)
	private GpuBenchmarkType typeOfBenchmark;
}
