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
@Table(name = "ram_memory_technology")
/**
 * Klasa qe mban informacione rreth teknologjive te memories ram
 * 
 * @author kfotj
 *
 */
public class RamMemoryTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ram_memory_technology", nullable = false)
	/**
	 * Çelesi primar ne tabelen "ram_memory_technology" ne bazen e te dhenave
	 */
	private Integer idRamMemoryTechnology;

	@Column(name = "ram_memory_technology_name", nullable = false, unique = true, length = 50)
	/**
	 * Variabli lidhet me fushen "ram_memory_technology_name" ne tabelen
	 * "memory_technology" ne bazen e te dhenave, e cila mban informacion ne lidhje
	 * me emrin e teknologjise
	 */
	private String ramMemoryTechnologyName;

	@Column(name = "ram_memory_technology_description", nullable = false, length = 65535)
	/**
	 * Variabli lidhet me fushen "ram_memory_technology_description" ne tabelen
	 * "memory_technology" ne bazen e te dhenave, e cila mban informacion qe
	 * pershkruan kete lloj teknologjie
	 */
	private String ramMemoryTechnologyDescription;

	@OneToMany(mappedBy = "memoryTechnologyOfThisMotherboard")
	private List<Motherboard> motherboardsThatHaveThisRamMemoryTechnology = new ArrayList<Motherboard>();

	@OneToMany(mappedBy = "technologyOfThisRamStick")
	private List<Ram> ramsOfThisTechnology = new ArrayList<Ram>();

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

	/* Getter setterat */
	// ----------
	// ----------
	// ----------
	/* Getter setterat */

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
