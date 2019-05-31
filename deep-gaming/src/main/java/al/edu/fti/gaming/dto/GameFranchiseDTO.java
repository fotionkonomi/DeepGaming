package al.edu.fti.gaming.dto;

public class GameFranchiseDTO extends IdNameDescriptionDTO{

	private CompanyDTO companyOfThisGameFranchise;

	public GameFranchiseDTO() {
		super();
	}
	
	public CompanyDTO getCompanyOfThisGameFranchise() {
		return companyOfThisGameFranchise;
	}

	public void setCompanyOfThisGameFranchise(CompanyDTO companyOfThisGameFranchise) {
		this.companyOfThisGameFranchise = companyOfThisGameFranchise;
	}

}
