package al.edu.fti.deep_gaming.models;

import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "gpu_memory_technology")
/**
 * Klasa e cila lidhet me tabelen "gpu_memory_technology" ne bazen e te dhenave,
 * e cila mban informacion rreth teknologjive te memories se kartave grafike
 * 
 * @author kfotj
 *
 */
public class GpuMemoryTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_memory_technology", nullable = false)
	/**
	 * Celesi primar ne tabelen "gpu_memory_technology" ne bazen e te dhenave
	 */
	private Integer idGpuMemoryTechnology;

	@Column(name = "gpu_memory_technology_name", unique = true, nullable = false, length = 50)
	/**
	 * Variabli lidhet me fushen "gpu_memory_technology_name" ne tabelen
	 * "gpu_memory_technology" ne bazen e te dhenave, e cila mban informacion ne
	 * lidhje me emrin e teknologjise
	 */
	private String gpuMemoryTechnologyName;

	@Column(name = "gpu_memory_technology_description", nullable = false, length = 65535)
	/**
	 * Variabli lidhet me fushen "gpu_memory_technology_description" ne tabelen
	 * "gpu_memory_technology" ne bazen e te dhenave, e cila mban informacion qe
	 * pershkruan kete lloj teknologjie
	 */
	private String gpuMemoryTechnologyDescription;
	
	@OneToMany(mappedBy = "memoryTechnologyOfThisGpi")
	private List<GPU> gpusWithThisMemoryTechnology = new ArrayList<GPU>();


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
