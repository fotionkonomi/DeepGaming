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

}
