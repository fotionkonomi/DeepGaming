package al.edu.fti.gaming.dto;

public class CpuSocketDTO extends IdNameDescriptionDTO {

	private CompanyDTO companyOfThisSocket;

	public CpuSocketDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisSocket() {
		return companyOfThisSocket;
	}

	public void setCompanyOfThisSocket(CompanyDTO companyOfThisSocket) {
		this.companyOfThisSocket = companyOfThisSocket;
	}

}
