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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisGameFranchise == null) ? 0 : companyOfThisGameFranchise.hashCode());
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
		GameFranchiseDTO other = (GameFranchiseDTO) obj;
		if (companyOfThisGameFranchise == null) {
			if (other.companyOfThisGameFranchise != null)
				return false;
		} else if (!companyOfThisGameFranchise.equals(other.companyOfThisGameFranchise))
			return false;
		return true;
	}

}
