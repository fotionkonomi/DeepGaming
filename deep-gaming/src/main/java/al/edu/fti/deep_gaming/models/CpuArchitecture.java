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
@Table(name = "cpu_architecture")
/**
 * This class is mapped to the "cpu_architecture" table in the database which
 * contains information regarding different CPU architectures
 * 
 * @author kfotj
 *
 */
public class CpuArchitecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_architecture")
	/**
	 * This field is mapped to the primary key of the "cpu_architecture" table in
	 * the database
	 */
	private Integer idCpuArchitecture;

	@Column(name = "cpu_architecture_name", nullable = false, length = 50)
	/**
	 * This variable is mapped to the "cpu_architecture_name" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * the name of a CPU architecture
	 */
	private String cpuArchitectureName;

	@Column(name = "cpu_architecture_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "cpu_architecture_name" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * generic information of a CPU architecture
	 */
	private String cpuArchitectureDescription;

	@Column(name = "cpu_process_nm", nullable = false)
	/**
	 * This variable is mapped to the "cpu_process_nm" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * the sizes of the transistors which are forming a CPU
	 */
	private Byte cpuProcessNanometers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable represents the company which created this architecture. It is
	 * mapped to the foreign key which connects "cpu_architecture" and "company"
	 * tables
	 */
	private Company companyOfThisCpuArchitecture;

	@OneToMany(mappedBy = "architectureOfThisCpu")
	private List<CPU> cpusOfThisArchitecture = new ArrayList<CPU>();

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
