package al.edu.fti.gaming.dto;

public class PowerSupplyDTO extends ProductDTO {

	private Integer powerCapacity;

	private CompanyDTO companyOfThisPowerSupply;

	public PowerSupplyDTO() {
		super();
	}

	public Integer getPowerCapacity() {
		return powerCapacity;
	}

	public void setPowerCapacity(Integer powerCapacity) {
		this.powerCapacity = powerCapacity;
	}

	public CompanyDTO getCompanyOfThisPowerSupply() {
		return companyOfThisPowerSupply;
	}

	public void setCompanyOfThisPowerSupply(CompanyDTO companyOfThisPowerSupply) {
		this.companyOfThisPowerSupply = companyOfThisPowerSupply;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisPowerSupply == null) ? 0 : companyOfThisPowerSupply.hashCode());
		result = prime * result + ((powerCapacity == null) ? 0 : powerCapacity.hashCode());
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
		PowerSupplyDTO other = (PowerSupplyDTO) obj;
		if (companyOfThisPowerSupply == null) {
			if (other.companyOfThisPowerSupply != null)
				return false;
		} else if (!companyOfThisPowerSupply.equals(other.companyOfThisPowerSupply))
			return false;
		if (powerCapacity == null) {
			if (other.powerCapacity != null)
				return false;
		} else if (!powerCapacity.equals(other.powerCapacity))
			return false;
		return true;
	}
	
	

}
