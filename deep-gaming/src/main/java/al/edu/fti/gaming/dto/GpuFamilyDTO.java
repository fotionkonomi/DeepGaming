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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisGpuFamily == null) ? 0 : companyOfThisGpuFamily.hashCode());
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
		GpuFamilyDTO other = (GpuFamilyDTO) obj;
		if (companyOfThisGpuFamily == null) {
			if (other.companyOfThisGpuFamily != null)
				return false;
		} else if (!companyOfThisGpuFamily.equals(other.companyOfThisGpuFamily))
			return false;
		return true;
	}

}
