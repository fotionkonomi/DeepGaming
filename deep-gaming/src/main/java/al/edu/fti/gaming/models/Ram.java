package al.edu.fti.gaming.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ram")
public class Ram extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1489059578582214853L;

	@Column(name = "capacity", nullable = false)
	private Double capacity;

	@Column(name = "frequency", nullable = false)
	private Integer frequency;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company ramSticksCompany;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_ram_memory_technology", nullable = false)
	private RamMemoryTechnology technologyOfThisRamStick;
	
	@OneToMany(mappedBy = "ramOfThisComputer")
	private List<Computer> computersThatHaveThisRam = new ArrayList<Computer>();

	public Ram(Integer idProduct, String productName, String productDescription, Date releaseDate, Integer price,
			Integer quantity, Date uploadDate, Date editedDate, User suggestedBy, User approvedBy, String hyperlink,
			Double capacity, Integer frequency, Company ramSticksCompany,
			RamMemoryTechnology technologyOfThisRamStick) {
		super(idProduct, productName, productDescription, releaseDate, price, quantity, uploadDate, editedDate,
				suggestedBy, approvedBy, hyperlink);
		this.capacity = capacity;
		this.frequency = frequency;
		this.ramSticksCompany = ramSticksCompany;
		this.technologyOfThisRamStick = technologyOfThisRamStick;
	}

	public Ram() {
		super();
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Company getRamSticksCompany() {
		return ramSticksCompany;
	}

	public void setRamSticksCompany(Company ramSticksCompany) {
		this.ramSticksCompany = ramSticksCompany;
	}

	public RamMemoryTechnology getTechnologyOfThisRamStick() {
		return technologyOfThisRamStick;
	}

	public void setTechnologyOfThisRamStick(RamMemoryTechnology technologyOfThisRamStick) {
		this.technologyOfThisRamStick = technologyOfThisRamStick;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((ramSticksCompany == null) ? 0 : ramSticksCompany.hashCode());
		result = prime * result + ((technologyOfThisRamStick == null) ? 0 : technologyOfThisRamStick.hashCode());
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
		Ram other = (Ram) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (ramSticksCompany == null) {
			if (other.ramSticksCompany != null)
				return false;
		} else if (!ramSticksCompany.equals(other.ramSticksCompany))
			return false;
		if (technologyOfThisRamStick == null) {
			if (other.technologyOfThisRamStick != null)
				return false;
		} else if (!technologyOfThisRamStick.equals(other.technologyOfThisRamStick))
			return false;
		return true;
	}

}
