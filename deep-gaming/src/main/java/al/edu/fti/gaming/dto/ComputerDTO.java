package al.edu.fti.gaming.dto;

public class ComputerDTO extends ProductDTO {
	private CpuDTO cpuOfThisComputer;

	private GpuDTO gpuOfThisComputer;

	private MotherboardDTO motherboardOfThisComputer;

	private RamDTO ramOfThisComputer;

	private CompanyDTO companyOfThisComputer;

	private OperatingSystemDTO operatingSystemOfThisComputer;

	private PowerSupplyDTO powerSupplyOfThisComputer;

	public ComputerDTO() {
		super();
	}

	public CpuDTO getCpuOfThisComputer() {
		return cpuOfThisComputer;
	}

	public void setCpuOfThisComputer(CpuDTO cpuOfThisComputer) {
		this.cpuOfThisComputer = cpuOfThisComputer;
	}

	public GpuDTO getGpuOfThisComputer() {
		return gpuOfThisComputer;
	}

	public void setGpuOfThisComputer(GpuDTO gpuOfThisComputer) {
		this.gpuOfThisComputer = gpuOfThisComputer;
	}

	public MotherboardDTO getMotherboardOfThisComputer() {
		return motherboardOfThisComputer;
	}

	public void setMotherboardOfThisComputer(MotherboardDTO motherboardOfThisComputer) {
		this.motherboardOfThisComputer = motherboardOfThisComputer;
	}

	public RamDTO getRamOfThisComputer() {
		return ramOfThisComputer;
	}

	public void setRamOfThisComputer(RamDTO ramOfThisComputer) {
		this.ramOfThisComputer = ramOfThisComputer;
	}

	public CompanyDTO getCompanyOfThisComputer() {
		return companyOfThisComputer;
	}

	public void setCompanyOfThisComputer(CompanyDTO companyOfThisComputer) {
		this.companyOfThisComputer = companyOfThisComputer;
	}

	public OperatingSystemDTO getOperatingSystemOfThisComputer() {
		return operatingSystemOfThisComputer;
	}

	public void setOperatingSystemOfThisComputer(OperatingSystemDTO operatingSystemOfThisComputer) {
		this.operatingSystemOfThisComputer = operatingSystemOfThisComputer;
	}

	public PowerSupplyDTO getPowerSupplyOfThisComputer() {
		return powerSupplyOfThisComputer;
	}

	public void setPowerSupplyOfThisComputer(PowerSupplyDTO powerSupplyOfThisComputer) {
		this.powerSupplyOfThisComputer = powerSupplyOfThisComputer;
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
		ComputerDTO other = (ComputerDTO) obj;
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
		return true;
	}

}
