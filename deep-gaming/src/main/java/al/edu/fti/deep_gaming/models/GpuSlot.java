package al.edu.fti.deep_gaming.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gpu_slot")
/**
 * This class is mapped to the "gpu_slot" table in the database and it contains
 * information regarding the different slots used by the graphic cards
 * 
 * @author kfotj
 *
 */
public class GpuSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_slot", nullable = false)
	/**
	 * This variable is mapped to the primary key of "gpu_slot" table in the
	 * database
	 */
	private Integer idGpuSlot;

	@Column(name = "gpu_slot_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "gpu_slot_name" field of the "gpu_slot" table
	 * in the database which contains information about the slot's name
	 */
	private String gpuSlotName;

	@Column(name = "gpu_slot_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "gpu_slot_description" field of the "gpu_slot"
	 * table in the database which contains general information regarding that slot
	 */
	private String gpuSlotDescription;

	@Column(name = "laptop_desktop", nullable = false)
	private Boolean laptopOrDesktop;

	@OneToMany(mappedBy = "gpuSlotOfThisGpu")
	private List<GPU> gpusThatHaveThisSlot = new ArrayList<GPU>();

	@ManyToMany(mappedBy = "gpuSlotsOfThisMotherborad")
	private Set<Motherboard> motherboardsThatHaveThisGpuSlot = new HashSet<Motherboard>();
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
