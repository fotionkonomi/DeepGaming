package al.edu.fti.gaming.dto;

public class GpuArchitectureDTO extends IdNameDescriptionDTO {

	private CompanyDTO companyOfThisGpuArchitectureType;

	public GpuArchitectureDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisGpuArchitectureType() {
		return companyOfThisGpuArchitectureType;
	}

	public void setCompanyOfThisGpuArchitectureType(CompanyDTO companyOfThisGpuArchitectureType) {
		this.companyOfThisGpuArchitectureType = companyOfThisGpuArchitectureType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((companyOfThisGpuArchitectureType == null) ? 0 : companyOfThisGpuArchitectureType.hashCode());
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
		GpuArchitectureDTO other = (GpuArchitectureDTO) obj;
		if (companyOfThisGpuArchitectureType == null) {
			if (other.companyOfThisGpuArchitectureType != null)
				return false;
		} else if (!companyOfThisGpuArchitectureType.equals(other.companyOfThisGpuArchitectureType))
			return false;
		return true;
	}

}
