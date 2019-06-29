package al.edu.fti.gaming.dto;

public class RamDTO extends ProductDTO {

	private Double capacity;

	private Integer frequency;

	private CompanyDTO ramSticksCompany;

	private RamMemoryTechnologyDTO technologyOfThisRamStick;

	public RamDTO() {
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

	public CompanyDTO getRamSticksCompany() {
		return ramSticksCompany;
	}

	public void setRamSticksCompany(CompanyDTO ramSticksCompany) {
		this.ramSticksCompany = ramSticksCompany;
	}

	public RamMemoryTechnologyDTO getTechnologyOfThisRamStick() {
		return technologyOfThisRamStick;
	}

	public void setTechnologyOfThisRamStick(RamMemoryTechnologyDTO technologyOfThisRamStick) {
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
		RamDTO other = (RamDTO) obj;
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
