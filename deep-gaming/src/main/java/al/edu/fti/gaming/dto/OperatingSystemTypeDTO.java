package al.edu.fti.gaming.dto;

import javax.validation.constraints.NotNull;

public class OperatingSystemTypeDTO extends IdNameDescriptionDTO{

	
	@NotNull(message = "{Pattern.CompanyOfObject.Validation}")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisOS == null) ? 0 : companyOfThisOS.hashCode());
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
		OperatingSystemTypeDTO other = (OperatingSystemTypeDTO) obj;
		if (companyOfThisOS == null) {
			if (other.companyOfThisOS != null)
				return false;
		} else if (!companyOfThisOS.equals(other.companyOfThisOS))
			return false;
		return true;
	}

}
