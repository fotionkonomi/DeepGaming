package al.edu.fti.gaming.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computer")
public class Computer extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7474921385167013548L;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu", nullable = false)
	private CPU cpuOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu", nullable = false)
	private GPU gpuOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_motherboard", nullable = false)
	private Motherboard motherboardOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_ram", nullable = false)
	private Ram ramOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_operating_system", nullable = false)
	private OperatingSystem operatingSystemOfThisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_power_supply", nullable = false)
	private PowerSupply powerSupplyOfThisComputer;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "computer_storage", joinColumns = { @JoinColumn(name = "id_computer") }, inverseJoinColumns = {
			@JoinColumn(name = "id_storage") })
	private Set<Storage> storagesOfThisComputer = new HashSet<Storage>();

	public Computer() {
		super();
	}

	public CPU getCpuOfThisComputer() {
		return cpuOfThisComputer;
	}

	public void setCpuOfThisComputer(CPU cpuOfThisComputer) {
		this.cpuOfThisComputer = cpuOfThisComputer;
	}

	public GPU getGpuOfThisComputer() {
		return gpuOfThisComputer;
	}

	public void setGpuOfThisComputer(GPU gpuOfThisComputer) {
		this.gpuOfThisComputer = gpuOfThisComputer;
	}

	public Motherboard getMotherboardOfThisComputer() {
		return motherboardOfThisComputer;
	}

	public void setMotherboardOfThisComputer(Motherboard motherboardOfThisComputer) {
		this.motherboardOfThisComputer = motherboardOfThisComputer;
	}

	public Ram getRamOfThisComputer() {
		return ramOfThisComputer;
	}

	public void setRamOfThisComputer(Ram ramOfThisComputer) {
		this.ramOfThisComputer = ramOfThisComputer;
	}

	public Company getCompanyOfThisComputer() {
		return companyOfThisComputer;
	}

	public void setCompanyOfThisComputer(Company companyOfThisComputer) {
		this.companyOfThisComputer = companyOfThisComputer;
	}

	public OperatingSystem getOperatingSystemOfThisComputer() {
		return operatingSystemOfThisComputer;
	}

	public void setOperatingSystemOfThisComputer(OperatingSystem operatingSystemOfThisComputer) {
		this.operatingSystemOfThisComputer = operatingSystemOfThisComputer;
	}

	public PowerSupply getPowerSupplyOfThisComputer() {
		return powerSupplyOfThisComputer;
	}

	public void setPowerSupplyOfThisComputer(PowerSupply powerSupplyOfThisComputer) {
		this.powerSupplyOfThisComputer = powerSupplyOfThisComputer;
	}

	public Set<Storage> getStoragesOfThisComputer() {
		return storagesOfThisComputer;
	}

	public void setStoragesOfThisComputer(Set<Storage> storagesOfThisComputer) {
		this.storagesOfThisComputer = storagesOfThisComputer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisComputer == null) ? 0 : companyOfThisComputer.hashCode());
		result = prime * result + ((cpuOfThisComputer == null) ? 0 : cpuOfThisComputer.hashCode());
		result = prime * result + ((gpuOfThisComputer == null) ? 0 : gpuOfThisComputer.hashCode());
		result = prime * result + ((motherboardOfThisComputer == null) ? 0 : motherboardOfThisComputer.hashCode());
		result = prime * result
				+ ((operatingSystemOfThisComputer == null) ? 0 : operatingSystemOfThisComputer.hashCode());
		result = prime * result + ((powerSupplyOfThisComputer == null) ? 0 : powerSupplyOfThisComputer.hashCode());
		result = prime * result + ((ramOfThisComputer == null) ? 0 : ramOfThisComputer.hashCode());
		result = prime * result + ((storagesOfThisComputer == null) ? 0 : storagesOfThisComputer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (companyOfThisComputer == null) {
			if (other.companyOfThisComputer != null)
				return false;
		} else if (!companyOfThisComputer.equals(other.companyOfThisComputer))
			return false;
		if (cpuOfThisComputer == null) {
			if (other.cpuOfThisComputer != null)
				return false;
		} else if (!cpuOfThisComputer.equals(other.cpuOfThisComputer))
			return false;
		if (gpuOfThisComputer == null) {
			if (other.gpuOfThisComputer != null)
				return false;
		} else if (!gpuOfThisComputer.equals(other.gpuOfThisComputer))
			return false;
		if (motherboardOfThisComputer == null) {
			if (other.motherboardOfThisComputer != null)
				return false;
		} else if (!motherboardOfThisComputer.equals(other.motherboardOfThisComputer))
			return false;
		if (operatingSystemOfThisComputer == null) {
			if (other.operatingSystemOfThisComputer != null)
				return false;
		} else if (!operatingSystemOfThisComputer.equals(other.operatingSystemOfThisComputer))
			return false;
		if (powerSupplyOfThisComputer == null) {
			if (other.powerSupplyOfThisComputer != null)
				return false;
		} else if (!powerSupplyOfThisComputer.equals(other.powerSupplyOfThisComputer))
			return false;
		if (ramOfThisComputer == null) {
			if (other.ramOfThisComputer != null)
				return false;
		} else if (!ramOfThisComputer.equals(other.ramOfThisComputer))
			return false;
		if (storagesOfThisComputer == null) {
			if (other.storagesOfThisComputer != null)
				return false;
		} else if (!storagesOfThisComputer.equals(other.storagesOfThisComputer))
			return false;
		return true;
	}

}
