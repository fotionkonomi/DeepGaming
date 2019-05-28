package al.edu.fti.deep_gaming.models;

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
public class CpuBenchmarkType {

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

	/* Konstruktor me parametra */
	// ----------
	// ----------
	// ----------
	/* Konstruktori me parametra */

	/* Konstruktor pa parametra */
	// ----------
	// ----------
	// ----------
	/* Konstruktori pa parametra */

	/* Getter setterat e tjere */
	// ----------
	// ----------
	// ----------
	/* Getter setterat e tjere */

	/* toString */
	// -----
	// -----
	// -----
	/* toString */

	/* hashCode */
	// -----
	// -----
	// -----
	/* hashCode */

	/* equals */
	// -----
	// -----
	// -----
	/* equals */

}
