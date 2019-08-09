package al.edu.fti.gaming.dto;

import javax.validation.constraints.NotNull;

public class ChipsetDTO extends IdNameDescriptionDTO {

	@NotNull(message = "{Pattern.CompanyOfObject.Validation}")
	private CompanyDTO companyOfThisChipset;

	public ChipsetDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisChipset() {
		return companyOfThisChipset;
	}

	public void setCompanyOfThisChipset(CompanyDTO companyOfThisChipset) {
		this.companyOfThisChipset = companyOfThisChipset;
	}

}
