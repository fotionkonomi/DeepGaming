package al.edu.fti.gaming.models;

import javax.persistence.Table;

import java.io.Serializable;
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
public class RamMemoryTechnology implements Serializable , IModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8376351355048643125L;

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

	public RamMemoryTechnology(Integer idRamMemoryTechnology, String ramMemoryTechnologyName,
			String ramMemoryTechnologyDescription, List<Motherboard> motherboardsThatHaveThisRamMemoryTechnology,
			List<Ram> ramsOfThisTechnology) {
		super();
		this.idRamMemoryTechnology = idRamMemoryTechnology;
		this.ramMemoryTechnologyName = ramMemoryTechnologyName;
		this.ramMemoryTechnologyDescription = ramMemoryTechnologyDescription;
		this.motherboardsThatHaveThisRamMemoryTechnology = motherboardsThatHaveThisRamMemoryTechnology;
		this.ramsOfThisTechnology = ramsOfThisTechnology;
	}

	public RamMemoryTechnology() {

	}

	public Integer getIdRamMemoryTechnology() {
		return idRamMemoryTechnology;
	}

	public void setIdRamMemoryTechnology(Integer idRamMemoryTechnology) {
		this.idRamMemoryTechnology = idRamMemoryTechnology;
	}

	public String getRamMemoryTechnologyName() {
		return ramMemoryTechnologyName;
	}

	public void setRamMemoryTechnologyName(String ramMemoryTechnologyName) {
		this.ramMemoryTechnologyName = ramMemoryTechnologyName;
	}

	public String getRamMemoryTechnologyDescription() {
		return ramMemoryTechnologyDescription;
	}

	public void setRamMemoryTechnologyDescription(String ramMemoryTechnologyDescription) {
		this.ramMemoryTechnologyDescription = ramMemoryTechnologyDescription;
	}

	public List<Motherboard> getMotherboardsThatHaveThisRamMemoryTechnology() {
		return motherboardsThatHaveThisRamMemoryTechnology;
	}

	public void setMotherboardsThatHaveThisRamMemoryTechnology(
			List<Motherboard> motherboardsThatHaveThisRamMemoryTechnology) {
		this.motherboardsThatHaveThisRamMemoryTechnology = motherboardsThatHaveThisRamMemoryTechnology;
	}

	public List<Ram> getRamsOfThisTechnology() {
		return ramsOfThisTechnology;
	}

	public void setRamsOfThisTechnology(List<Ram> ramsOfThisTechnology) {
		this.ramsOfThisTechnology = ramsOfThisTechnology;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRamMemoryTechnology == null) ? 0 : idRamMemoryTechnology.hashCode());
		result = prime * result + ((motherboardsThatHaveThisRamMemoryTechnology == null) ? 0
				: motherboardsThatHaveThisRamMemoryTechnology.hashCode());
		result = prime * result
				+ ((ramMemoryTechnologyDescription == null) ? 0 : ramMemoryTechnologyDescription.hashCode());
		result = prime * result + ((ramMemoryTechnologyName == null) ? 0 : ramMemoryTechnologyName.hashCode());
		result = prime * result + ((ramsOfThisTechnology == null) ? 0 : ramsOfThisTechnology.hashCode());
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
		RamMemoryTechnology other = (RamMemoryTechnology) obj;
		if (idRamMemoryTechnology == null) {
			if (other.idRamMemoryTechnology != null)
				return false;
		} else if (!idRamMemoryTechnology.equals(other.idRamMemoryTechnology))
			return false;
		if (motherboardsThatHaveThisRamMemoryTechnology == null) {
			if (other.motherboardsThatHaveThisRamMemoryTechnology != null)
				return false;
		} else if (!motherboardsThatHaveThisRamMemoryTechnology
				.equals(other.motherboardsThatHaveThisRamMemoryTechnology))
			return false;
		if (ramMemoryTechnologyDescription == null) {
			if (other.ramMemoryTechnologyDescription != null)
				return false;
		} else if (!ramMemoryTechnologyDescription.equals(other.ramMemoryTechnologyDescription))
			return false;
		if (ramMemoryTechnologyName == null) {
			if (other.ramMemoryTechnologyName != null)
				return false;
		} else if (!ramMemoryTechnologyName.equals(other.ramMemoryTechnologyName))
			return false;
		if (ramsOfThisTechnology == null) {
			if (other.ramsOfThisTechnology != null)
				return false;
		} else if (!ramsOfThisTechnology.equals(other.ramsOfThisTechnology))
			return false;
		return true;
	}

}
