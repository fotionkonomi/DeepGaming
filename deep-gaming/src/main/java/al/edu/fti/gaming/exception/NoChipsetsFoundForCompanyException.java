package al.edu.fti.gaming.exception;

public class NoChipsetsFoundForCompanyException extends NoObjectFoundForCompanyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643711669806631791L;

	public NoChipsetsFoundForCompanyException(String companyName) {
		super(companyName);
	}

}
