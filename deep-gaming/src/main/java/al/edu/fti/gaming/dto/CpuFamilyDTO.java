package al.edu.fti.gaming.dto;

public class CpuFamilyDTO extends IdNameDescriptionDTO{

	private CompanyDTO companyOfThisCpuFamily;

	public CpuFamilyDTO() {
		super();
	}
	
	public CompanyDTO getCompanyOfThisCpuFamily() {
		return companyOfThisCpuFamily;
	}

	public void setCompanyOfThisCpuFamily(CompanyDTO companyOfThisCpuFamily) {
		this.companyOfThisCpuFamily = companyOfThisCpuFamily;
	}

}
