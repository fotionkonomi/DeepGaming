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
}
