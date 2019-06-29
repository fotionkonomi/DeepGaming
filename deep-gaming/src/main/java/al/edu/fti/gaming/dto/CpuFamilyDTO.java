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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisCpuFamily == null) ? 0 : companyOfThisCpuFamily.hashCode());
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
		CpuFamilyDTO other = (CpuFamilyDTO) obj;
		if (companyOfThisCpuFamily == null) {
			if (other.companyOfThisCpuFamily != null)
				return false;
		} else if (!companyOfThisCpuFamily.equals(other.companyOfThisCpuFamily))
			return false;
		return true;
	}

	
}
