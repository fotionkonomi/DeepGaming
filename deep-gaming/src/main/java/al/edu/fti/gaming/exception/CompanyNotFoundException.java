package al.edu.fti.gaming.exception;

public class CompanyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2691604647400090608L;

	private int companyId;

	public CompanyNotFoundException(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyId() {
		return companyId;
	}

}
