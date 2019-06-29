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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisSocket == null) ? 0 : companyOfThisSocket.hashCode());
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
		return true;
	}

	
}
