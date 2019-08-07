package al.edu.fti.gaming.dto;

public class MotherboardDTO extends ProductDTO {

	private Double maximumRamCapacity;
	private Integer maximumRamSpeed;
	private CompanyDTO companyOfThisMotherboard;
	private CpuSocketDTO cpuSocketOfThisMotherboard;
	private ChipsetDTO chipsetOfThisMotherboard;
	private RamMemoryTechnologyDTO memoryTechnologyOfThisMotherboard;
	private MotherboardFormFactorDTO formFactorOfThisMotherboard;

	public MotherboardDTO() {
		super();
	}

	public Double getMaximumRamCapacity() {
		return maximumRamCapacity;
	}

	public void setMaximumRamCapacity(Double maximumRamCapacity) {
		this.maximumRamCapacity = maximumRamCapacity;
	}

	public Integer getMaximumRamSpeed() {
		return maximumRamSpeed;
	}

	public void setMaximumRamSpeed(Integer maximumRamSpeed) {
		this.maximumRamSpeed = maximumRamSpeed;
	}

	public CompanyDTO getCompanyOfThisMotherboard() {
		return companyOfThisMotherboard;
	}

	public void setCompanyOfThisMotherboard(CompanyDTO companyOfThisMotherboard) {
		this.companyOfThisMotherboard = companyOfThisMotherboard;
	}

	public CpuSocketDTO getCpuSocketOfThisMotherboard() {
		return cpuSocketOfThisMotherboard;
	}

	public void setCpuSocketOfThisMotherboard(CpuSocketDTO cpuSocketOfThisMotherboard) {
		this.cpuSocketOfThisMotherboard = cpuSocketOfThisMotherboard;
	}

	public ChipsetDTO getChipsetOfThisMotherboard() {
		return chipsetOfThisMotherboard;
	}

	public void setChipsetOfThisMotherboard(ChipsetDTO chipsetOfThisMotherboard) {
		this.chipsetOfThisMotherboard = chipsetOfThisMotherboard;
	}

	public RamMemoryTechnologyDTO getMemoryTechnologyOfThisMotherboard() {
		return memoryTechnologyOfThisMotherboard;
	}

	public void setMemoryTechnologyOfThisMotherboard(RamMemoryTechnologyDTO memoryTechnologyOfThisMotherboard) {
		this.memoryTechnologyOfThisMotherboard = memoryTechnologyOfThisMotherboard;
	}

	public MotherboardFormFactorDTO getFormFactorOfThisMotherboard() {
		return formFactorOfThisMotherboard;
	}

	public void setFormFactorOfThisMotherboard(MotherboardFormFactorDTO formFactorOfThisMotherboard) {
		this.formFactorOfThisMotherboard = formFactorOfThisMotherboard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chipsetOfThisMotherboard == null) ? 0 : chipsetOfThisMotherboard.hashCode());
		result = prime * result + ((companyOfThisMotherboard == null) ? 0 : companyOfThisMotherboard.hashCode());
		result = prime * result + ((cpuSocketOfThisMotherboard == null) ? 0 : cpuSocketOfThisMotherboard.hashCode());
		result = prime * result + ((formFactorOfThisMotherboard == null) ? 0 : formFactorOfThisMotherboard.hashCode());
		result = prime * result + ((maximumRamCapacity == null) ? 0 : maximumRamCapacity.hashCode());
		result = prime * result + ((maximumRamSpeed == null) ? 0 : maximumRamSpeed.hashCode());
		result = prime * result
				+ ((memoryTechnologyOfThisMotherboard == null) ? 0 : memoryTechnologyOfThisMotherboard.hashCode());
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
		MotherboardDTO other = (MotherboardDTO) obj;
		if (chipsetOfThisMotherboard == null) {
			if (other.chipsetOfThisMotherboard != null)
				return false;
		} else if (!chipsetOfThisMotherboard.equals(other.chipsetOfThisMotherboard))
			return false;
		if (companyOfThisMotherboard == null) {
			if (other.companyOfThisMotherboard != null)
				return false;
		} else if (!companyOfThisMotherboard.equals(other.companyOfThisMotherboard))
			return false;
		if (cpuSocketOfThisMotherboard == null) {
			if (other.cpuSocketOfThisMotherboard != null)
				return false;
		} else if (!cpuSocketOfThisMotherboard.equals(other.cpuSocketOfThisMotherboard))
			return false;
		if (formFactorOfThisMotherboard == null) {
			if (other.formFactorOfThisMotherboard != null)
				return false;
		} else if (!formFactorOfThisMotherboard.equals(other.formFactorOfThisMotherboard))
			return false;
		if (maximumRamCapacity == null) {
			if (other.maximumRamCapacity != null)
				return false;
		} else if (!maximumRamCapacity.equals(other.maximumRamCapacity))
			return false;
		if (maximumRamSpeed == null) {
			if (other.maximumRamSpeed != null)
				return false;
		} else if (!maximumRamSpeed.equals(other.maximumRamSpeed))
			return false;
		if (memoryTechnologyOfThisMotherboard == null) {
			if (other.memoryTechnologyOfThisMotherboard != null)
				return false;
		} else if (!memoryTechnologyOfThisMotherboard.equals(other.memoryTechnologyOfThisMotherboard))
			return false;
		return true;
	}

}