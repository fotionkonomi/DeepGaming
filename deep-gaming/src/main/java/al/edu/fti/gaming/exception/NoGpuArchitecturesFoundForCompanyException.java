package al.edu.fti.gaming.exception;

public class NoGpuArchitecturesFoundForCompanyException extends NoObjectFoundForCompanyException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2897587191377339519L;

	public NoGpuArchitecturesFoundForCompanyException(String companyName) {
		super(companyName);
	}

}
