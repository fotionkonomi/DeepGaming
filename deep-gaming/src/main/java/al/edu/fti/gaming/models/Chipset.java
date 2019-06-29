package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chipset")
/**
 * This class is mapped to the "chipset" table in the database which contains
 * information about the different chipsets of a CPU
 * 
 * @author kfotj
 *
 */
public class Chipset implements IModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5538838921457668758L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_chipset", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "chipset" table in the
	 * database
	 */
	private Integer idChipset;

	@Column(name = "chipset_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "chipset_name" field in the "chipset" table in
	 * the database which contains the name of the CPU chipset. Has to be 50 or less
	 * characters long
	 */
	private String chipsetName;

	@Column(name = "chipset_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "chipset_description" field in the "chipset"
	 * table which contains generic information of a specific type of chipset
	 */
	private String chipsetDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * The company which created this chipset
	 */
	private Company companyThatCreatedThisChipset;
	
	@ManyToMany(mappedBy = "chipsetsThatSupportThisCpu")
	private Set<CPU> cpusThatAreSupportedByThisChipset = new HashSet<CPU>();
	
	@OneToMany(mappedBy = "chipsetOfThisMotherboard")
	private List<Motherboard> motherboardsThatHaveThisChipset = new ArrayList<Motherboard>();

	public Chipset(Integer idChipset, String chipsetName, String chipsetDescription,
			Company companyThatCreatedThisChipset, Set<CPU> cpusThatAreSupportedByThisChipset,
			List<Motherboard> motherboardsThatHaveThisChipset) {
		super();
		this.idChipset = idChipset;
		this.chipsetName = chipsetName;
		this.chipsetDescription = chipsetDescription;
		this.companyThatCreatedThisChipset = companyThatCreatedThisChipset;
		this.cpusThatAreSupportedByThisChipset = cpusThatAreSupportedByThisChipset;
		this.motherboardsThatHaveThisChipset = motherboardsThatHaveThisChipset;
	}

	public Chipset() {
		
	}

	public Integer getIdChipset() {
		return idChipset;
	}

	public void setIdChipset(Integer idChipset) {
		this.idChipset = idChipset;
	}

	public String getChipsetName() {
		return chipsetName;
	}

	public void setChipsetName(String chipsetName) {
		this.chipsetName = chipsetName;
	}

	public String getChipsetDescription() {
		return chipsetDescription;
	}

	public void setChipsetDescription(String chipsetDescription) {
		this.chipsetDescription = chipsetDescription;
	}

	public Company getCompanyThatCreatedThisChipset() {
		return companyThatCreatedThisChipset;
	}

	public void setCompanyThatCreatedThisChipset(Company companyThatCreatedThisChipset) {
		this.companyThatCreatedThisChipset = companyThatCreatedThisChipset;
	}

	public Set<CPU> getCpusThatAreSupportedByThisChipset() {
		return cpusThatAreSupportedByThisChipset;
	}

	public void setCpusThatAreSupportedByThisChipset(Set<CPU> cpusThatAreSupportedByThisChipset) {
		this.cpusThatAreSupportedByThisChipset = cpusThatAreSupportedByThisChipset;
	}

	public List<Motherboard> getMotherboardsThatHaveThisChipset() {
		return motherboardsThatHaveThisChipset;
	}

	public void setMotherboardsThatHaveThisChipset(List<Motherboard> motherboardsThatHaveThisChipset) {
		this.motherboardsThatHaveThisChipset = motherboardsThatHaveThisChipset;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chipsetDescription == null) ? 0 : chipsetDescription.hashCode());
		result = prime * result + ((chipsetName == null) ? 0 : chipsetName.hashCode());
		result = prime * result
				+ ((companyThatCreatedThisChipset == null) ? 0 : companyThatCreatedThisChipset.hashCode());
		result = prime * result
				+ ((cpusThatAreSupportedByThisChipset == null) ? 0 : cpusThatAreSupportedByThisChipset.hashCode());
		result = prime * result + ((idChipset == null) ? 0 : idChipset.hashCode());
		result = prime * result
				+ ((motherboardsThatHaveThisChipset == null) ? 0 : motherboardsThatHaveThisChipset.hashCode());
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
		Chipset other = (Chipset) obj;
		if (chipsetDescription == null) {
			if (other.chipsetDescription != null)
				return false;
		} else if (!chipsetDescription.equals(other.chipsetDescription))
			return false;
		if (chipsetName == null) {
			if (other.chipsetName != null)
				return false;
		} else if (!chipsetName.equals(other.chipsetName))
			return false;
		if (companyThatCreatedThisChipset == null) {
			if (other.companyThatCreatedThisChipset != null)
				return false;
		} else if (!companyThatCreatedThisChipset.equals(other.companyThatCreatedThisChipset))
			return false;
		if (cpusThatAreSupportedByThisChipset == null) {
			if (other.cpusThatAreSupportedByThisChipset != null)
				return false;
		} else if (!cpusThatAreSupportedByThisChipset.equals(other.cpusThatAreSupportedByThisChipset))
			return false;
		if (idChipset == null) {
			if (other.idChipset != null)
				return false;
		} else if (!idChipset.equals(other.idChipset))
			return false;
		if (motherboardsThatHaveThisChipset == null) {
			if (other.motherboardsThatHaveThisChipset != null)
				return false;
		} else if (!motherboardsThatHaveThisChipset.equals(other.motherboardsThatHaveThisChipset))
			return false;
		return true;
	}
	
	
	
}
