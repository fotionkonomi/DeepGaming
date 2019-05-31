package al.edu.fti.gaming.dto;

public class GpuFamilyDTO extends IdNameDescriptionDTO {

	private CompanyDTO companyOfThisGpuFamily;

	public GpuFamilyDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisGpuFamily() {
		return companyOfThisGpuFamily;
	}

	public void setCompanyOfThisGpuFamily(CompanyDTO companyOfThisGpuFamily) {
		this.companyOfThisGpuFamily = companyOfThisGpuFamily;
	}

}
