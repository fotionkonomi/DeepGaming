package al.edu.fti.gaming.models;

import java.io.Serializable;
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

	@OneToMany(mappedBy = "gpuSlot")
	private List<Motherboard> motherboardsThatHaveThisSlot;

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

	public List<Motherboard> getMotherboardsThatHaveThisSlot() {
		return motherboardsThatHaveThisSlot;
	}

	public void setMotherboardsThatHaveThisSlot(List<Motherboard> motherboardsThatHaveThisSlot) {
		this.motherboardsThatHaveThisSlot = motherboardsThatHaveThisSlot;
	}

	
}
