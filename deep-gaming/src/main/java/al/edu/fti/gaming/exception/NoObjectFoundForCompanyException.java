package al.edu.fti.gaming.exception;

public abstract class NoObjectFoundForCompanyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7372644883723813089L;
	
	private String companyName;
	
	public NoObjectFoundForCompanyException(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}

}
