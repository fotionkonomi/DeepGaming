package al.edu.fti.gaming.exception;

public class NoChipsetsFoundForCompanyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643711669806631791L;

	private String companyName;

	public NoChipsetsFoundForCompanyException(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

}
