package al.edu.fti.gaming.models;

import java.io.Serializable;
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
public class GpuSlot implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5252438898444701711L;

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

	public GpuSlot(Integer idGpuSlot, String gpuSlotName, String gpuSlotDescription, Boolean laptopOrDesktop,
			List<GPU> gpusThatHaveThisSlot, Set<Motherboard> motherboardsThatHaveThisGpuSlot) {
		super();
		this.idGpuSlot = idGpuSlot;
		this.gpuSlotName = gpuSlotName;
		this.gpuSlotDescription = gpuSlotDescription;
		this.laptopOrDesktop = laptopOrDesktop;
		this.gpusThatHaveThisSlot = gpusThatHaveThisSlot;
		this.motherboardsThatHaveThisGpuSlot = motherboardsThatHaveThisGpuSlot;
	}

	public GpuSlot() {

	}

	public Integer getIdGpuSlot() {
		return idGpuSlot;
	}

	public void setIdGpuSlot(Integer idGpuSlot) {
		this.idGpuSlot = idGpuSlot;
	}

	public String getGpuSlotName() {
		return gpuSlotName;
	}

	public void setGpuSlotName(String gpuSlotName) {
		this.gpuSlotName = gpuSlotName;
	}

	public String getGpuSlotDescription() {
		return gpuSlotDescription;
	}

	public void setGpuSlotDescription(String gpuSlotDescription) {
		this.gpuSlotDescription = gpuSlotDescription;
	}

	public Boolean getLaptopOrDesktop() {
		return laptopOrDesktop;
	}

	public void setLaptopOrDesktop(Boolean laptopOrDesktop) {
		this.laptopOrDesktop = laptopOrDesktop;
	}

	public List<GPU> getGpusThatHaveThisSlot() {
		return gpusThatHaveThisSlot;
	}

	public void setGpusThatHaveThisSlot(List<GPU> gpusThatHaveThisSlot) {
		this.gpusThatHaveThisSlot = gpusThatHaveThisSlot;
	}

	public Set<Motherboard> getMotherboardsThatHaveThisGpuSlot() {
		return motherboardsThatHaveThisGpuSlot;
	}

	public void setMotherboardsThatHaveThisGpuSlot(Set<Motherboard> motherboardsThatHaveThisGpuSlot) {
		this.motherboardsThatHaveThisGpuSlot = motherboardsThatHaveThisGpuSlot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gpuSlotDescription == null) ? 0 : gpuSlotDescription.hashCode());
		result = prime * result + ((gpuSlotName == null) ? 0 : gpuSlotName.hashCode());
		result = prime * result + ((gpusThatHaveThisSlot == null) ? 0 : gpusThatHaveThisSlot.hashCode());
		result = prime * result + ((idGpuSlot == null) ? 0 : idGpuSlot.hashCode());
		result = prime * result + ((laptopOrDesktop == null) ? 0 : laptopOrDesktop.hashCode());
		result = prime * result
				+ ((motherboardsThatHaveThisGpuSlot == null) ? 0 : motherboardsThatHaveThisGpuSlot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GpuSlot other = (GpuSlot) obj;
		if (gpuSlotDescription == null) {
			if (other.gpuSlotDescription != null)
				return false;
		} else if (!gpuSlotDescription.equals(other.gpuSlotDescription))
			return false;
		if (gpuSlotName == null) {
			if (other.gpuSlotName != null)
				return false;
		} else if (!gpuSlotName.equals(other.gpuSlotName))
			return false;
		if (gpusThatHaveThisSlot == null) {
			if (other.gpusThatHaveThisSlot != null)
				return false;
		} else if (!gpusThatHaveThisSlot.equals(other.gpusThatHaveThisSlot))
			return false;
		if (idGpuSlot == null) {
			if (other.idGpuSlot != null)
				return false;
		} else if (!idGpuSlot.equals(other.idGpuSlot))
			return false;
		if (laptopOrDesktop == null) {
			if (other.laptopOrDesktop != null)
				return false;
		} else if (!laptopOrDesktop.equals(other.laptopOrDesktop))
			return false;
		if (motherboardsThatHaveThisGpuSlot == null) {
			if (other.motherboardsThatHaveThisGpuSlot != null)
				return false;
		} else if (!motherboardsThatHaveThisGpuSlot.equals(other.motherboardsThatHaveThisGpuSlot))
			return false;
		return true;
	}

}
