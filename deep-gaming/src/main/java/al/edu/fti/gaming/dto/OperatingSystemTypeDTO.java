package al.edu.fti.gaming.dto;

public class OperatingSystemTypeDTO extends IdNameDescriptionDTO{

	private CompanyDTO companyOfThisOS;

	public OperatingSystemTypeDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisOS() {
		return companyOfThisOS;
	}

	public void setCompanyOfThisOS(CompanyDTO companyOfThisOS) {
		this.companyOfThisOS = companyOfThisOS;
	}

}
