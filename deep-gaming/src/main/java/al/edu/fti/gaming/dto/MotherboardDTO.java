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

}
