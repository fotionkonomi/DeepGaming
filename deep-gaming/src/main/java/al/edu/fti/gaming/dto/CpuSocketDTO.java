package al.edu.fti.gaming.dto;

public class CpuSocketDTO extends IdNameDescriptionDTO {

	private CompanyDTO companyOfThisSocket;

	private Boolean laptopOrDesktop;

	public CpuSocketDTO() {
		super();
	}

	public Boolean getLaptopOrDesktop() {
		return laptopOrDesktop;
	}

	public void setLaptopOrDesktop(Boolean laptopOrDesktop) {
		this.laptopOrDesktop = laptopOrDesktop;
	}

	public CompanyDTO getCompanyOfThisSocket() {
		return companyOfThisSocket;
	}

	public void setCompanyOfThisSocket(CompanyDTO companyOfThisSocket) {
		this.companyOfThisSocket = companyOfThisSocket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisSocket == null) ? 0 : companyOfThisSocket.hashCode());
		result = prime * result + ((laptopOrDesktop == null) ? 0 : laptopOrDesktop.hashCode());
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
		CpuSocketDTO other = (CpuSocketDTO) obj;
		if (companyOfThisSocket == null) {
			if (other.companyOfThisSocket != null)
				return false;
		} else if (!companyOfThisSocket.equals(other.companyOfThisSocket))
			return false;
		if (laptopOrDesktop == null) {
			if (other.laptopOrDesktop != null)
				return false;
		} else if (!laptopOrDesktop.equals(other.laptopOrDesktop))
			return false;
		return true;
	}

	
}
