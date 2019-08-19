package al.edu.fti.gaming.exception;

public class CompanyNotFoundException extends ObjectNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2691604647400090608L;

	public CompanyNotFoundException(int companyId) {
		super(companyId);
	}

	

}
