package al.edu.fti.deep_gaming.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gpu_architecture")
/**
 * This is the class which is mapped to the "gpu_architecture" table in the
 * database which contains information regarding the different types of graphic
 * card architectures
 * 
 * @author kfotj
 *
 */
public class GpuArchitecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_architecture", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "gpu_architecture" table in
	 * the database
	 */
	private Integer idGpuArchitecture;

	@Column(name = "gpu_architecture_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "gpu_architecture_name" field in the
	 * "gpu_architecture" table in the database which contains the name of the
	 * specific graphic card architecture
	 */
	private String gpuArchitectureName;

	@Column(name = "gpu_architecture_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "gpu_architecture_description" field in the
	 * "gpu_architecture" table in the database and it contains generic information
	 * regarding a specific graphic card architecture
	 */
	private String gpuArchitectureDescription;

	@Column(name = "gpu_process_nm", nullable = false)
	/**
	 * This variable is mapped to the "gpu_process_nm" field in the
	 * "gpu_architecture" table in the database which contains information regarding
	 * the size of the transistors in this architecture
	 */
	private Byte gpuProcessNanometers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable contains the company that created a specific graphic card
	 * architecture
	 */
	private Company companyOfThisGpuArchitecture;

	@OneToMany(mappedBy = "architectureOfThisGpu")
	private List<GPU> gpusOfThisArchitecture = new ArrayList<GPU>();

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
