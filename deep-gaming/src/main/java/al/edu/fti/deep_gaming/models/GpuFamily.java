package al.edu.fti.deep_gaming.models;

import javax.persistence.Table;

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

@Entity
@Table(name = "gpu_family")
/**
 * The class which is mapped to the "cpu_family" table in the database which
 * contains information regarding the CPU families
 * 
 * @author kfotj
 *
 */
public class GpuFamily {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_family", nullable = false)
	/**
	 * This field is mapped to the primary key of the "gpu_family" table in the
	 * database
	 */
	private Integer idGpuFamily;

	@Column(name = "gpu_family_name", nullable = false, length = 50)
	/**
	 * This variable is mapped to the "gpu_family_name" field in the "gpu_family"
	 * table in the database which contains information regarding the GPU family's
	 * name
	 */
	private String gpuFamilyName;

	@Column(name = "gpu_family_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "gpu_family_description" field in the
	 * "gpu_family" table in the database which contains information regarding
	 * generic information about a GPU family
	 */
	private String gpuFamilyDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable represents the company which created a GPU family. It maps the
	 * id of the company in the database
	 */
	private Company companyOfThisGpuFamily;

	@OneToMany(mappedBy = "familyOfThisGpu")
	private List<GPU> gpusOfThisFamily = new ArrayList<GPU>();

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
